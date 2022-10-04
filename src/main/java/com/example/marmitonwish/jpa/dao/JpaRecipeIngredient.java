package com.example.marmitonwish.jpa.dao;

import com.example.marmitonwish.jpa.PersistenceManager;
import com.example.marmitonwish.jpa.entity.Recipe;
import com.example.marmitonwish.jpa.entity.RecipeIngredient;
import com.example.marmitonwish.jpa.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

public class JpaRecipeIngredient implements RecipeIngredientDao{


    @Override
    public List<RecipeIngredient> findAll() {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        try {
            List<RecipeIngredient> recipeIngredients = em.createQuery("SELECT r FROM recipe_ingredient r",RecipeIngredient.class).getResultList();
            return recipeIngredients;
        }catch (RuntimeException re){
            // TODO
        }finally {
            em.close();
        }
        return null;
    }

    @Override
    public boolean addRecipeIngredient(RecipeIngredient recipeIngredient) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(recipeIngredient);
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
    public boolean deleteRecipeIngredient(long id) { //todo
        return false;
    }

    @Override
    public boolean updateRecipeIngredient(RecipeIngredient recipe) { // todo
        return false;
    }

    @Override
    public Optional<RecipeIngredient> getRecipeIngredientById(long id) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        try {
            Query query = em.createQuery("select r from recipe_ingredient r WHERE r.recipe.id = :idRecipe");
            query.setParameter("idRecipe",id);
            Optional<RecipeIngredient> recipeIngredient = Optional.of(em.find(RecipeIngredient.class,id));
            return recipeIngredient;
        }catch (RuntimeException re){
            // todo
        }finally {
            em.close();
        }
        return Optional.empty();
    }
}
