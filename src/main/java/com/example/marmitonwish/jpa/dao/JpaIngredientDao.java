package com.example.marmitonwish.jpa.dao;

import com.example.marmitonwish.jpa.PersistenceManager;
import com.example.marmitonwish.jpa.entity.Ingredient;
import com.example.marmitonwish.jpa.entity.Recipe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class JpaIngredientDao implements IngredientDao{


    @Override
    public List<Ingredient> findAll() {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        try {
            List<Ingredient> ingredients = em.createQuery("SELECT u FROM ingredient u",Ingredient.class).getResultList();
            return ingredients;
        }catch (RuntimeException re){
            // TODO
        }finally {
            em.close();
        }
        return null;
    }

    @Override
    public boolean addIngredient(Ingredient ingredient) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(ingredient);
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
    public boolean deleteIngredient(long id) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            Ingredient ingredient = em.find(Ingredient.class,id);
            em.remove(ingredient);
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
    public boolean updateIngredient(Recipe ingredient) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.merge(ingredient);
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
    public Optional<Ingredient> getIngredientById(long id) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            Optional<Ingredient> ingredient = Optional.of(em.find(Ingredient.class,id));
            et.commit();
            return ingredient;
        }catch (RuntimeException re){
            // todo
            et.rollback();
            re.printStackTrace();
        }finally {
            em.close();
        }
        return Optional.empty();
    }
}

