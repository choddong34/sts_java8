package kr.re.kepri.pcm.main.controller;

import kr.re.kepri.pcm.main.service.CalculationService;
import kr.re.kepri.pcm.main.vo.CalculationVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.*;

@RestController
@RequestMapping("/api")
public class CalculationController {

    @Resource(name = "calculationService")
    private CalculationService calculationService;

    private final ExecutorService executor = Executors.newCachedThreadPool();

    @PostMapping("/calculate")
    public String startCalculation(@RequestBody CalculationVO request) {
        String key = getKey(request);

        executor.submit(() -> {
            try {
                for (int i = 1; i <= 100; i += 10) {
                    calculationService.updateProgress(key, i);
                    Thread.sleep(500); // 계산 진행 시뮬레이션
                }
                calculationService.updateProgress(key, 100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        return "계산 작업이 시작되었습니다.";
    }

    @GetMapping("/progress/{key}")
    public SseEmitter getProgress(@PathVariable String key) {
        SseEmitter emitter = new SseEmitter();

        executor.submit(() -> {
            try {
                int lastProgress = 0;
                while (lastProgress < 100) {
                    int current = calculationService.getProgress(key);
                    if (current != lastProgress) {
                        emitter.send(SseEmitter.event().data(current));
                        lastProgress = current;
                    }
                    Thread.sleep(300);
                }
                emitter.send(SseEmitter.event().data(100));
                emitter.complete();
                calculationService.removeProgress(key);
            } catch (IOException | InterruptedException e) {
                emitter.completeWithError(e);
            }
        });

        return emitter;
    }

    private String getKey(CalculationVO req) {
        return req.getOfficeCd() + "_" + req.getSearchYm();
    }
}
