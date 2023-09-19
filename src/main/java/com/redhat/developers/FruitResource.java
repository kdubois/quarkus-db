package com.redhat.developers;

import java.util.List;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/fruit")
public class FruitResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON) 
    public Uni<List<Fruit>> getFruits(@QueryParam("season") String season) {
        if (season != null ) {
            return Fruit.findBySeason(season);
        }
        Log.info("Listing all fruits");
        return Fruit.listAll();
    }
}
