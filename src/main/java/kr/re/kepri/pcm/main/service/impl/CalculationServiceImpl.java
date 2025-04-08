package kr.re.kepri.pcm.main.service.impl;

import kr.re.kepri.pcm.main.service.CalculationService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * packageName    : kr.re.kepri.pcm.main.service.impl
 * fileName       : CalculationService
 * author         : dj
 * date           : 4/8/2025
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/8/2025        dj       최초 생성
 */
@Service("calculationService")
public class CalculationServiceImpl implements CalculationService {

    private final ConcurrentHashMap<String, Integer> progressMap = new ConcurrentHashMap<>();

    @Override
    public void updateProgress(String key, int value) {
        progressMap.put(key, value);
    }

    @Override
    public int getProgress(String key) {
        return progressMap.getOrDefault(key, 0);
    }

    @Override
    public void removeProgress(String key) {
        progressMap.remove(key);
    }
}
