package com.kaishengit.pojo;

import javax.persistence.*;

/**
 * Created by lhn on 2016/8/1.
 */
@Entity
@Table("t_lizename")
public class Lize {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany
    private String  lizename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLizename() {
        return lizename;
    }

    public void setLizename(String lize) {
        this.lizename = lize;
    }
}
