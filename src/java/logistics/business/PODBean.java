/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistics.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import logistics.entity.Pod;

/**
 *
 * @author Vignesh
 */
@Stateless
public class PODBean {
    
    @PersistenceContext private EntityManager em;
    
    public List<Pod> getAllPods()
    {
        return em.createNamedQuery("Pod.findAll", Pod.class).getResultList();
    }
    
}
