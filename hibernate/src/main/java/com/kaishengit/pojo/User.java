package com.kaishengit.pojo;

import org.hibernate.annotations.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * Created by lhn on 2016/7/25.
 */
@Entity
@Table(name ="t_user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)/*相当于二级缓存*/
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /*如果属性名誉变量名相同无需注解
    * 不同：添加@Column（name="列名"）*/
    private String  password;
    private String  username;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
