package kr.re.kepri.pcm.main.controller;

import kr.re.kepri.pcm.main.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.annotation.Resource;


/**
 * 메인 컨트롤러 클래스
 */
@Controller
public class MainController {

    @Resource(name="mainService")
    private MainService mainService;

    /**
     * 메인 페이지
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/mainPage", method = RequestMethod.GET)
    public String mainPage() throws Exception {
        return "contents/main/mainPage";
    }

}
