package com.example.marmitonwish.api;


import com.example.marmitonwish.jpa.DaoFactory;
import com.example.marmitonwish.jpa.dao.JpaRecipeDao;
import com.example.marmitonwish.jpa.dao.RecipeDao;
import com.example.marmitonwish.jpa.entity.Recipe;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Path("/recipes")
public class RecipeRessource {

    private RecipeDao recipeDao;

    public RecipeRessource() {
        this.recipeDao = DaoFactory.getRecipeDao();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Recipe> recipeList = DaoFactory.getRecipeDao().findAll();
        return Response.ok(recipeList).build();
    }

    @GET
    @Path("/{recipesId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getIslandById(@PathParam("recipesId") long idParam) {
        Optional<Recipe> optionalIsland = recipeDao.getRecipeById(idParam);

        if (optionalIsland.isPresent()) {
            return Response.ok(optionalIsland.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Recipe dto, @Context UriInfo uriInfo) {
        Recipe createdRecipe = new Recipe( dto.getRecipeName(), dto.getTimeToPrepare(), dto.getPreparation(),
                dto.getPortion(), dto.getPrice(), dto.getCreateDate(),dto.getPreparation(),dto.getCategory(),
                dto.getUser());

        recipeDao.addRecipe(createdRecipe);

        URI location = uriInfo
                .getRequestUriBuilder()
                .path(String.valueOf(createdRecipe.getId()))
                .build();

        return Response.created(location).entity(createdRecipe).build();
    }


    @PUT
    @Path("/{recipesId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("recipesId") long idParam, Recipe dto) {
        Optional<Recipe> optionalRecipe = recipeDao.getRecipeById(idParam);
        if (optionalRecipe.isPresent()) {
            new JpaRecipeDao().updateRecipe(new Recipe( dto.getRecipeName(), dto.getTimeToPrepare(), dto.getPreparation(),
                    dto.getPortion(), dto.getPrice(), dto.getCreateDate(),dto.getPreparation(),dto.getCategory(),
                    dto.getUser()));
            return getAll();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{recipesId}")
    public Response delete(@PathParam("recipesId") long idParam) {
        new JpaRecipeDao().deleteRecipe(idParam);
        return Response.noContent().build();
    }


}


