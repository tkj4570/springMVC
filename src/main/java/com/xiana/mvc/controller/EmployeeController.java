package com.xiana.mvc.controller;

import com.xiana.mvc.bean.Employee;
import com.xiana.mvc.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>包名称: com.xiana.mvc.controller </p>
 * <p>项目名称: java </p>
 * <p>文件名称: null.java </p>
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2022/1/4 上午9:53 </p>
 * <p>公司信息: 全球贸易通公司</p>
 *
 * @author <a href="mail to: 457066709@qq.com" rel="nofollow">唐科技</a>
 * @version v1.0
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.list();
        model.addAttribute("employees", employees);
        return "employee_list";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String add(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> delete(@PathVariable("id") Integer id, HttpServletResponse httpServletResponse){
        employeeDao.delete(id);
        Map<String,Object> res = new HashMap();
        res.put("code", 200);
        res.put("message","删除成功");
        /**
         * 原始response方式发送json字符串
        Gson gson = new Gson();
        String toJson = gson.toJson(res);
        try {
            httpServletResponse.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = httpServletResponse.getWriter();
            writer.write(toJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
         */
        return res;
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable(value = "id")Integer id,Model model){
        Employee employee = employeeDao.find(id);
        model.addAttribute("employee", employee);
        return "employee_edit";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String editEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }
}