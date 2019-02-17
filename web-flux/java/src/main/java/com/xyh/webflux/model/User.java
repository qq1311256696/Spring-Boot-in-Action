package com.xyh.webflux.model;

import java.math.BigInteger;

public class User {
    private Integer id;
    private BigInteger uid;
    private String nickname;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getUid() {
        return uid;
    }

    public void setUid(BigInteger uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
