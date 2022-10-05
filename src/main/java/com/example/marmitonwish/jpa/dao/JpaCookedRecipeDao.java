package com.example.marmitonwish.jpa.dao;

import com.example.marmitonwish.jpa.PersistenceManager;
import com.example.marmitonwish.jpa.entity.CookedRecipe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JpaCookedRecipeDao implements CookedRecipeDao {
    @Override
    public List<CookedRecipe> findAll() {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        List<CookedRecipe> cookedRecipes = new ArrayList<>();
        try {

            cookedRecipes = em.createQuery("SELECT u FROM CookedRecipe u", CookedRecipe.class).getResultList();
            et.commit();
            return cookedRecipes;
        }catch (RuntimeException re){
            // TODO
            et.rollback();
            re.printStackTrace();
        }finally {
            em.close();
        }
        return cookedRecipes;
    }

    @Override
    public boolean addCookedRecipe(CookedRecipe cookedRecipe) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(cookedRecipe);
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
    public boolean deleteCookedRecipe(long id) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            CookedRecipe cookedRecipe = em.find(CookedRecipe.class,id);
            em.remove(cookedRecipe);
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
    public boolean updateCookedRecipe(CookedRecipe cookedRecipe) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.merge(cookedRecipe);
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
    public Optional<CookedRecipe> getCookedRecipeById(long id) {
        EntityManager em = PersistenceManager.getEMF().createEntityManager();
        try {
            Optional<CookedRecipe> cookedRecipeOptional = Optional.of(em.find(CookedRecipe.class,id));
            return cookedRecipeOptional;
        }catch (RuntimeException re){
            // todo
            re.printStackTrace();
        }finally {
            em.close();
        }
        return Optional.empty();
    }
}
