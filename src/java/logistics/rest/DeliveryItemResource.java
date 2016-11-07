/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistics.rest;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import logistics.business.DeliveryBean;
import logistics.entity.Delivery;

/**
 *
 * @author Vignesh
 */
@RequestScoped
@Path("/items")
public class DeliveryItemResource {
    @EJB private DeliveryBean mgr;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItems()
    {
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        
        List<Delivery> deliveries = mgr.getDeliveryItems();
        for(Delivery d:deliveries)
        {
            JsonObjectBuilder objBuilder = Json.createObjectBuilder();
            objBuilder.add("teamId","40b66c20");
            objBuilder.add("podId", d.getPod().getPodId());
            objBuilder.add("name", d.getName());
            objBuilder.add("address", d.getAddress());
            objBuilder.add("name", d.getPhone());
            arrBuilder.add(objBuilder);
        }
        return Response.ok(arrBuilder.build()).build();
    }
}
