package com.sz.zhiling.module;


import org.hibernate.annotations.Entity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "t_user")
public class User {
    @Column(name="uid")
    private int uid;
    @Column(name="uname")
    private String uname;
    @Column(name="upwd")
    private String upwd;

    public User(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public User() {
    }

    public User(int uid, String uname, String upwd) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return uid == user.uid &&
                Objects.equals(uname, user.uname) &&
                Objects.equals(upwd, user.upwd);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uid, uname, upwd);
    }
}
