package com.xiana.mvc.dao;

import com.xiana.mvc.bean.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>包名称: com.xiana.mvc.dao </p>
 * <p>项目名称: java </p>
 * <p>文件名称: null.java </p>
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2022/1/4 上午10:48 </p>
 * <p>公司信息: 全球贸易通公司</p>
 *
 * @author <a href="mail to: 457066709@qq.com" rel="nofollow">唐科技</a>
 * @version v1.0
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
@Repository
public class EmployeeDao {
    private static Map<Integer,Employee> employees;
    static {
        employees = new HashMap<Integer,Employee>();
        employees.put(1001, new Employee(1001,"employee1","1@qq.com",0));
        employees.put(1002, new Employee(1002,"employee2","2@qq.com",1));
        employees.put(1003, new Employee(1003,"employee3","3@qq.com",0));
        employees.put(1004, new Employee(1004,"employee4","4@qq.com",1));
        employees.put(1005, new Employee(1005,"employee5","5@qq.com",0));
    }

    private static int autoInt = 1006;

    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(autoInt++);
        }
        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> list(){
        return employees.values();
    }

    public void delete(Integer id){
        employees.remove(id);
    }

    public Employee find(Integer id){
        return employees.get(id);
    }
}
