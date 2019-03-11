package com.fmi.store.models;

public class User {

    private Integer id;
    private String username;
    private String password;

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;

        // vom verifica cast dupa ce facem exceptiile
        User user = (User) obj;
        return (this.id.equals(user.getId()));
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
