package cn.canos.kanban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author canos
 */
@Controller
@RequestMapping("/")
public class WelcomeController {

    @RequestMapping
    public ModelAndView welcome() {

        return new ModelAndView("welcome");
    }
}
