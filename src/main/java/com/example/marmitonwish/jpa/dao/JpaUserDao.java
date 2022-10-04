package com.example.marmitonwish.jpa.dao;

import com.example.marmitonwish.jpa.PersistenceManager;
import com.example.marmitonwish.jpa.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

public class JpaUserDao implements UserDao{

    @Override
    public List<User> findAll() {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        try {
            List<User> users = em.createQuery("SELECT u FROM user u",User.class).getResultList();
            return users;
        }catch (RuntimeException re){
            // TODO
        }finally {
            em.close();
        }
        return null;
    }

    @Override
    public boolean addUser(User user) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(user);
            et.commit();
            return true;
        }catch (RuntimeException re){
            if (et.isActive()){
                et.rollback();
                re.printStackTrace();
            }
        }finally {
            em.close();
        }
        return false;
    }

    @Override
    public boolean deleteUser(long id) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            User user = em.find(User.class,id);
            em.remove(user);
            et.commit();
            return true;
        }catch (RuntimeException re){
            if (et.isActive()){
                et.rollback();
            }
        }finally {
            em.close();
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.merge(user);
            et.commit();
            return true;
        }catch (RuntimeException re){
            if (et.isActive()){
                et.rollback();
            }
        }finally {
            em.close();
        }
        return false;
    }

    @Override
    public Optional<User> getUserById(long id) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        try {
            Optional<User> user = Optional.of(em.find(User.class,id));
            return user;
        }catch (RuntimeException re){
            // todo
        }finally {
            em.close();
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        try {
            Query query = em.createQuery("select m from user m WHERE m.email = :email");
            query.setParameter("email",email);
            Optional<User> user = Optional.of((User)query.getSingleResult());
            return user;
        }catch (RuntimeException re){
            // todo
        }finally {
            em.close();
        }
        return Optional.empty();
    }

}
