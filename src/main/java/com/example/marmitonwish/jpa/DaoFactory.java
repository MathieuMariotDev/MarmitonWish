package com.example.marmitonwish.jpa;

public class DaoFactory {

    public DaoFactory() {
    }

    public static UserDao getUserDao(){
        return new UserDao();
    }

}
