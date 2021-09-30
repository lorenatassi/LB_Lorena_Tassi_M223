package ch.zli.m223.punchclock.controller;


import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.UserService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Tag(name = "Users", description = "Handling of users")
public class UserController {
    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all Users", description = "displays all users")
    public List<User> list() {
        return userService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @Operation(summary = "Get one User", description = "returns one users over id")
    public User getUser(@PathParam Long id) {
        return userService.getUser(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new user", description = "The newly created user is returned. The id may not be passed.")
    public User add(User user) {
        return userService.createUser(user);
    }


    @DELETE
    @Operation(summary = "Deletes one Objekt", description = "deletes object over id")
    @Path("/{id}")
    public void deletePerId(@PathParam Long id){
        userService.delUserId(id);
    }

    @DELETE
    @Operation(summary = "Deletes one Objekt", description = "deletes given object")
    public void deleteObject(User user){
        userService.delUserObject(user);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Updates user", description = "updates user over given object")
    public User update(User user){
        return userService.updateUser(user);
    }
}
