package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.JiraStat;
import ch.zli.m223.punchclock.service.JiraStatService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/jirastats")
@Tag(name = "JiraStats", description = "Handling of JiraStats")
public class JiraStatController {
    @Inject
    JiraStatService jiraStatService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all JiraStats", description = "gives back a list of all Jiras")
    public List<JiraStat> list() {
        return jiraStatService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @Operation(summary = "Get one Jira", description = "gives back a on Jiras with id")
    public JiraStat getJiraStat(@PathParam Long id) {
        return jiraStatService.getJira(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new JiraStat", description = "The newly created JiraStat is returned. The id may not be passed.")
    public JiraStat add(JiraStat jiraStat) {
        return jiraStatService.createJiraStat(jiraStat);
    }


    @DELETE
    @Operation(summary = "Deletes one Objekt", description = "deltes the object over the id")
    @Path("/{id}")
    public void deletePerId(@PathParam Long id){
        jiraStatService.delJiraStatId(id);
    }

    @DELETE
    @Operation(summary = "Deletes one Objekt", description = "deletes given object")
    public void deleteObject(JiraStat jiraStat){
        jiraStatService.delJiraStatObj(jiraStat);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Updates Jira", description = "updates the given object")
    public JiraStat update(JiraStat jiraStat){
        return jiraStatService.updateJira(jiraStat);
    }

}
