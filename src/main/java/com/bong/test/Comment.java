package com.bong.test;

import javax.persistence.*;

/**
 * Created by coupang on 2017. 6. 29..
 */
@Entity
@Table(name="cmmt")
public class Comment {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String comment;

    private String user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
