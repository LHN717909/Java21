package com.kaishengit.pojo;

import javax.persistence.*;

/**
 * Created by lhn on 2016/7/26.
 */
@Entity
@Table(name = "t_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  empname;
    @ManyToOne//(fetch = FetchType.LAZY)默认避免N+1问题，如果用不到可以添加fetch
    @JoinColumn(name = "deptid")
    private Dept    dept;

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "dept=" + dept +
                ", id=" + id +
                ", empname='" + empname + '\'' +
                '}';
    }
}
