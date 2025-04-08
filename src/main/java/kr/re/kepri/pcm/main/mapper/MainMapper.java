package kr.re.kepri.pcm.main.mapper;


import kr.re.kepri.pcm.common.util.ResultMap;
import kr.re.kepri.pcm.main.vo.CalculationVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainMapper {

    ResultMap selectTest() throws Exception;

    void insertTest(CalculationVO calculationVO) throws Exception;
}
