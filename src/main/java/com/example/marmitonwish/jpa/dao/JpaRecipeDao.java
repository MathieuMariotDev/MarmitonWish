package com.example.marmitonwish.jpa.dao;

import com.example.marmitonwish.jpa.PersistenceManager;
import com.example.marmitonwish.jpa.entity.Recipe;
import com.example.marmitonwish.jpa.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JpaRecipeDao implements RecipeDao{

    @Override
    public List<Recipe> findAll() {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        List<Recipe> recipes = new ArrayList<>();
        try {

            recipes = em.createQuery("SELECT u FROM recipe u", Recipe.class).getResultList();
            et.commit();
            return recipes;
        } catch (RuntimeException re) {
            // TODO
            et.rollback();
            re.printStackTrace();
        } finally {
            em.close();
        }
        return recipes;
    }

    @Override
    public boolean addRecipe(Recipe recipe) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(recipe);
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
    public boolean deleteRecipe(long id) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            Recipe recipe = em.find(Recipe.class,id);
            em.remove(recipe);
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
    public boolean updateRecipe(Recipe recipe) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.merge(recipe);
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
    public Optional<Recipe> getRecipeById(long id) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        try {
            Optional<Recipe> recipe = Optional.of(em.find(Recipe.class,id));
            return recipe;
        }catch (RuntimeException re){
            // todo
            re.printStackTrace();
        }finally {
            em.close();
        }
        return Optional.empty();
    }
}
