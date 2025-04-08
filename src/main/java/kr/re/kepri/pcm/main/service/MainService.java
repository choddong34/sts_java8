package kr.re.kepri.pcm.main.service;


import kr.re.kepri.pcm.common.util.ResultMap;
import kr.re.kepri.pcm.main.vo.CalculationVO;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MainService {

    ResultMap selectTest() throws Exception;

    void insertTest(CalculationVO calculationVO) throws Exception;
}
