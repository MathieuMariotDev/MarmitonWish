package com.example.marmitonwish.jpa;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
final public class PersistenceManager {


    private static EntityManagerFactory entityManagerFactory = null;


    // Init EntityManagerFactory db
    public static EntityManagerFactory getEMF(){
        if (entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        }
        return entityManagerFactory;
    }

    public static void closeConnection() {
        if (entityManagerFactory !=null ){
            entityManagerFactory.close();
        }
    }



}
