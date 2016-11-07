/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistics.view;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import logistics.business.DeliveryBean;

/**
 *
 * @author urquhart
 */
@RequestScoped
@Named
public class EnterDetailsView {
    
    @EJB DeliveryBean delBean;
    
    String name;
    String address;
    String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void addToDelivery(){
        delBean.AddDelivery(name, address, phone);
    }
    
}
