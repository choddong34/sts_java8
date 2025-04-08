package kr.re.kepri.pcm.main.service.impl;

import kr.re.kepri.pcm.common.util.ResultMap;
import kr.re.kepri.pcm.main.mapper.MainMapper;

import kr.re.kepri.pcm.main.service.MainService;
import kr.re.kepri.pcm.main.vo.CalculationVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("mainService")
public class MainServiceImpl implements MainService {

    @Resource(name="mainMapper")
    private MainMapper mainMapper;


    @Override
    public ResultMap selectTest() throws Exception {
        return mainMapper.selectTest();
    }

    @Override
    public void insertTest(CalculationVO calculationVO) throws Exception {
        mainMapper.insertTest(calculationVO);
    }
}
