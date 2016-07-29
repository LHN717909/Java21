package com.kaishengit.pojo;

import javax.persistence.*;

/**
 * Created by lhn on 2016/7/27.
 */
@Entity
@Table(name = "t_topic_content")
public class TopicContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
