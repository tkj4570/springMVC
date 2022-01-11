package com.xiana.mvc.bean;

/**
 * <p>包名称: com.xiana.mvc.bean </p>
 * <p>项目名称: java </p>
 * <p>文件名称: null.java </p>
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2022/1/4 上午10:51 </p>
 * <p>公司信息: 全球贸易通公司</p>
 *
 * @author <a href="mail to: 457066709@qq.com" rel="nofollow">唐科技</a>
 * @version v1.0
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;

    public Employee() {
    }

    public Employee(Integer id, String lastName, String email, Integer gender) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }
}
