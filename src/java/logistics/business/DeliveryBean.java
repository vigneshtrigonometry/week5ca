/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistics.business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import logistics.entity.Delivery;

/**
 *
 * @author urquhart
 */
@Stateless
public class DeliveryBean {
    
    @PersistenceContext EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void AddDelivery(String name, String address, String phone) {
        
        try{
        Delivery del = new Delivery();
        del.setName(name);
        del.setAddress(address);
        del.setPhone(phone);
        em.persist(del);
        } catch(Exception e){
        
            System.out.println("Error in DeliveryBean");
            e.printStackTrace();
        }
        
    }
}
