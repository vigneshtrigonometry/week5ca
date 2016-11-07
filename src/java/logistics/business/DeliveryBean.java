/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistics.business;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.MultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;
import java.io.File;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import logistics.entity.Delivery;
import logistics.entity.Pod;
import org.kohsuke.rngom.digested.Main;

/**
 *
 * @author urquhart
 */
@Stateless
public class DeliveryBean {

    @PersistenceContext
    EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void AddDelivery(String name, String address, String phone) {

        try {
            Delivery del = new Delivery();
            del.setName(name);
            del.setAddress(address);
            del.setPhone(phone);
            del.setCreateDate(new Date());
            Pod p = new Pod();
            p.setPkgId(del);
            p.setDeliveryDate(new Date());
            em.persist(del);
            em.persist(p);

        } catch (ConstraintViolationException ex) {
            System.out.println(ex.getConstraintViolations().toString());
        } catch (Exception e) {

            System.out.println("Error in DeliveryBean");
            e.printStackTrace();
        }

    }

    //gets the list of items from the delivery table and returns it as a list
    public List<Delivery> getDeliveryItems() {
        try {
            return em.createNamedQuery("Delivery.findAll", Delivery.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void getAcknowledgement() {
        List<Pod> pods = em.createNamedQuery("Pod.findAll", Pod.class).getResultList();
        for (Pod p : pods) {
            if (p.getAckId() == null || p.getAckId() == "") {

                final Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();
                
                WebTarget t = client.target("").path("multipart").path("upload2");

                FormDataMultiPart mp = new FormDataMultiPart();
                mp.field("teamId","40b66c20");
                mp.field("podId",p.getPodId().toString());
                mp.field("callback","http://172.23.134.156:8080/week5ca/callback");
                mp.field("note",p.getNote());
                mp.field("image", p.getImage(),MediaType.MULTIPART_FORM_DATA_TYPE);

            }
        }

    }

}
