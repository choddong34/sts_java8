package kr.re.kepri.pcm.main.controller;

import kr.re.kepri.pcm.main.vo.CalculationVO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * packageName    : kr.re.kepri.pcm.main.controller
 * fileName       : CalculationController
 * author         : dj
 * date           : 4/8/2025
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/8/2025        dj       최초 생성
 */

@RestController
@RequestMapping("/api")
public class CalculationController {
    @PostMapping("/calculate")
    @Async
    public CompletableFuture<String> calculateStrength(@RequestBody CalculationVO request) {
        System.out.println("전주강도 계산 시작 (비동기)");
        System.out.println("사업소코드: " + request.getOfficeCd());
        System.out.println("조회년월: " + request.getSearchYm());

        // 실제 계산 로직은 여기서 진행 예정
        try {
            Thread.sleep(1000); // 예시용 딜레이
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return CompletableFuture.completedFuture("요청을 성공적으로 받았습니다. 전주강도 계산 완료 예정.");
    }
}
