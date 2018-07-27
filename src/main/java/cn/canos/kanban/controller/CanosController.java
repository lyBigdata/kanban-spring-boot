package cn.canos.kanban.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author canos
 */
@RestController
@RequestMapping("/api/canos")
public class CanosController extends BaseController {

    @RequestMapping(path = "sayhi", method = RequestMethod.POST)
    @ResponseBody
    public String sayHi(HttpServletRequest request, HttpServletResponse servletRequest) {

        return "Hi.";
    }
}
