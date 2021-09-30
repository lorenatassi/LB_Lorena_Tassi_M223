package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Break;
import ch.zli.m223.punchclock.domain.JiraStat;
import ch.zli.m223.punchclock.service.BreakService;
import ch.zli.m223.punchclock.service.JiraStatService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/breaks")
@Tag(name = "Breaks", description = "Handling of Breaks")
public class BreakController {
    @Inject
    BreakService breakService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all Breaks", description = "Gives back a list of all breaks")
    public List<Break> list() {
        return breakService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @Operation(summary = "Get one Break", description = "Get one Break over id")
    public Break getJiraStat(@PathParam Long id) {
        return breakService.getBreak(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new Break", description = "The newly created Break is returned. The id may not be passed.")
    public Break add(Break brek) {
        return breakService.createBreak(brek);
    }


    @DELETE
    @Operation(summary = "Deletes one Objekt", description = "Object with this id gets deleted")
    @Path("/{id}")
    public void deletePerId(@PathParam Long id){
        breakService.delBreakId(id);
    }

    @DELETE
    @Operation(summary = "Deletes one Objekt", description = "Deletes the given Object")
    public void deleteObject(Break brek){
        breakService.delBreakObj(brek);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Updates Object", description = "Updates given object")
    public Break update(Break brek){
        return breakService.updateBreak(brek);
    }
}
