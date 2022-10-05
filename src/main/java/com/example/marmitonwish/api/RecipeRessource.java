package com.example.marmitonwish.api;


import com.example.marmitonwish.jpa.DaoFactory;
import com.example.marmitonwish.jpa.dao.RecipeDao;
import com.example.marmitonwish.jpa.entity.Recipe;
import com.example.marmitonwish.model.RecipeDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        List<RecipeDto> recipeDtos = recipeList.stream().map(recipe -> recipe.RecipeToDto()).collect(Collectors.toList());
        return Response.ok(recipeDtos).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getIslandById(@PathParam("id") long idParam) {
        Optional<Recipe> optionalIsland = recipeDao.getRecipeById(idParam);

        if (optionalIsland.isPresent()) {
            RecipeDto recipeDto = optionalIsland.get().RecipeToDto();
            return Response.ok(recipeDto).build();
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
    @Path("/{islandId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("islandId") long idParam, Recipe recipe) {
        Optional<Recipe> optionalRecipe = recipeDao.getRecipeById(idParam);

        if (optionalRecipe.isPresent()) {
            optionalRecipe.get().setRecipeName(recipe.getRecipeName());
            optionalRecipe.get().setDificulty(recipe.getDificulty());
            optionalRecipe.get().setRecipeIngredients(recipe.getRecipeIngredients());
            optionalRecipe.get().setCookedRecipes(recipe.getCookedRecipes());
            optionalRecipe.get().setTimeToPrepare(recipe.getTimeToPrepare());
            optionalRecipe.get().setPrice(recipe.getPrice());
            optionalRecipe.get().setPortion(recipe.getPortion());
            optionalRecipe.get().setPreparation(recipe.getPreparation());
            optionalRecipe.get().setCategory(recipe.getCategory());
            recipeDao.updateRecipe(optionalRecipe.get()); // TODO
            return getAll();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{islandId}")
    public Response delete(@PathParam("islandId") long idParam) {
        recipeDao.deleteRecipe(idParam);
        return Response.noContent().build();
    }


}


