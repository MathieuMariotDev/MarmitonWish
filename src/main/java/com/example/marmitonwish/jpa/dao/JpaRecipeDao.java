package com.example.marmitonwish.jpa.dao;

import com.example.marmitonwish.jpa.PersistenceManager;
import com.example.marmitonwish.jpa.entity.Recipe;
import com.example.marmitonwish.jpa.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

public class JpaRecipeDao implements RecipeDao{

    @Override
    public List<Recipe> findAll() {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        try {
            List<Recipe> recipes = em.createQuery("SELECT u FROM recipe u",Recipe.class).getResultList();
            return recipes;
        }catch (RuntimeException re){
            // TODO
        }finally {
            em.close();
        }
        return null;
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

    @Override
    public Optional<Recipe> getByName(String name) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        try {
            Query query = em.createQuery("SELECT u FROM recipe u WHERE u.recipeName = :name");
            query.setParameter("name",name);
            Optional<Recipe> recipe = Optional.of((Recipe) query.getSingleResult());
            return recipe;
        }catch (RuntimeException re){
            // todo
            re.printStackTrace();
        }finally {
            em.close();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Recipe> getByCategory(String category) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        try {
            Query query = em.createQuery("SELECT u FROM recipe u WHERE u.category = :category");
            query.setParameter("category",category);
            Optional<Recipe> recipe = Optional.of((Recipe) query.getSingleResult());
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
