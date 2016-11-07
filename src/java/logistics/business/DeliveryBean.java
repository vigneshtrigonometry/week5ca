/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistics.business;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import logistics.entity.Delivery;
import logistics.entity.Pod;

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

        } 
        catch(ConstraintViolationException ex)
        {
            System.out.println(ex.getConstraintViolations().toString());
        }
        catch (Exception e) {

            System.out.println("Error in DeliveryBean");
            e.printStackTrace();
        }

    }

    //gets the list of items from the delivery table and returns it as a list
    public List<Delivery> getDeliveryItems() {
        try
        {
            return em.createNamedQuery("Delivery.findAll", Delivery.class).getResultList();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
