package com.kaishengit.pojo;

import javax.persistence.*;

/**
 * Created by lhn on 2016/8/1.
 */
@Entity
@Table(name = "t_kind")
public class Kind {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
