/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistics.rest;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import logistics.business.DeliveryBean;

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
        return null;
    }
}
