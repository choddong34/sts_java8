package kr.re.kepri.pcm.main.service;

/**
 * packageName    : kr.re.kepri.pcm.main.service
 * fileName       : CalculationService
 * author         : dj
 * date           : 4/8/2025
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/8/2025        dj       최초 생성
 */
public interface CalculationService {
    void updateProgress(String key, int value);
    int getProgress(String key);
    void removeProgress(String key);
}
