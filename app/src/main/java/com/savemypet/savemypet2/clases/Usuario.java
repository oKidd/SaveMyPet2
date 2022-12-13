package com.savemypet.savemypet2.clases;

public class Usuario {
    String id;
    String userName;
    String password;
    String email;
    String fono;

    public Usuario(String id, String userName, String password, String email, String fono) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.fono = fono;
    }

    public Usuario(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }
}
