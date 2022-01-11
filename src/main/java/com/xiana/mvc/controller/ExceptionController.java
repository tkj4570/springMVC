package com.xiana.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * <p>包名称: com.xiana.mvc.controller </p>
 * <p>项目名称: java </p>
 * <p>文件名称: null.java </p>
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2022/1/7 上午9:08 </p>
 * <p>公司信息: 全球贸易通公司</p>
 *
 * @author <a href="mail to: 457066709@qq.com" rel="nofollow">唐科技</a>
 * @version v1.0
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
@ControllerAdvice
@Controller
public class ExceptionController extends SimpleMappingExceptionResolver {
    //处理某异常的页面
    @ExceptionHandler
    public String error(Exception ex, Model model){
        model.addAttribute("ex", ex);
        return "error";
    }

    @RequestMapping(value = "/exception")
    public String testException(){
        System.out.println(1/0);
        return "success";
    }
}
