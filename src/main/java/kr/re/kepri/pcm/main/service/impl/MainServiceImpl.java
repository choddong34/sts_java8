package kr.re.kepri.pcm.main.service.impl;

import kr.re.kepri.pcm.main.mapper.MainMapper;

import kr.re.kepri.pcm.main.service.MainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("mainService")
public class MainServiceImpl implements MainService {

    @Resource(name="mainMapper")
    private MainMapper mainMapper;


}
