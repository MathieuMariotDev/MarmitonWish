package com.example.marmitonwish.application;

import com.example.marmitonwish.jpa.PersistenceManager;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("-------------------------------APP INITIALIZED-------------------------------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("-------------------------------APP DESTROY-------------------------------");
        PersistenceManager.closeConnection();
    }
}
