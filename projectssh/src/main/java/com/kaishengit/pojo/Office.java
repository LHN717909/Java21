package com.kaishengit.pojo;


import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by lhn on 2016/8/1.
 */
@Entity
@Table("t_office")
public class Office {
    private Integer id;
    private String  name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
