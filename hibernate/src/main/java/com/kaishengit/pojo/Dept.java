package com.kaishengit.pojo;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by lhn on 2016/7/26.
 */
@Entity
@Table(name = "t_dept")
public class Dept {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String deptname;
    @OneToMany(mappedBy = "dept")/*放弃关系维护 */
    private Set<Employee> employeeSet;/*SET可以换成list*/

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptname='" + deptname + '\'' +
                ", id=" + id +
                ", employeeSet=" + employeeSet +
                '}';
    }
}
