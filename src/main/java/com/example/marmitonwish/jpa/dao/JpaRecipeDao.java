package com.example.marmitonwish.jpa.dao;

import com.example.marmitonwish.jpa.PersistenceManager;
import com.example.marmitonwish.jpa.entity.Recipe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

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

             recipes = em.createQuery("SELECT u FROM recipe u",Recipe.class).getResultList();
            et.commit();
             return recipes;
        }catch (RuntimeException re){
            // TODO
            et.rollback();
            re.printStackTrace();
        }finally {
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

    @Override
    public List<Recipe> getByName(String name) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        List<Recipe> recipes = new ArrayList<>();
        try {
            CriteriaQuery<Recipe> query = builder.createQuery(Recipe.class);
            Root<Recipe> root = query.from(Recipe.class);
            query.select(root).where(builder.like(root.get("recipeName").as(String.class),'%'+name+'%'));
            recipes = em.createQuery(query).getResultList();

            return recipes;
        }catch (RuntimeException re){
            // todo
            re.printStackTrace();
        }finally {
            em.close();
        }
        return recipes;
    }

    @Override
    public List<Recipe>  getByCategory(String category) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        List<Recipe> recipes = new ArrayList<>();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            Query query = em.createQuery("SELECT u FROM recipe u WHERE u.category = :category");
            query.setParameter("category",category);
            recipes= query.getResultList();
            et.commit();
            return recipes;
        }catch (RuntimeException re){
            // todo
            et.rollback();
            re.printStackTrace();
        }finally {
            em.close();
        }
        return recipes;
    }
}
