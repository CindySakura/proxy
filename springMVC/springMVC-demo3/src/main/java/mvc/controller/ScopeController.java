package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能：
 * 作者：Cindy
 * 日期：30/04/2024 21:40
 */
@Controller
public class ScopeController {
    //使用ServletAPI向Request域对象共享数据
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request){
        request.setAttribute("testRequestScope","hello,servletAPI");
        return "success";
    }

    //使用ModelAndView向Request域对象共享数据
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mav = new ModelAndView();
        //处理模型数据，即向请求域request共享数据
        mav.addObject("testRequestScope","hello,ModelAndView");
        //设置视图名称
        mav.setViewName("success");
        return mav;
    }

    //使用Model向Request域对象共享数据
    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testRequestScope","hello,Model");
        return "success";
    }
}
