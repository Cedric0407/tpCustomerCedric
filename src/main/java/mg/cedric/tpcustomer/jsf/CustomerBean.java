/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.cedric.tpcustomer.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import mg.cedric.tpcustomer.ejb.CustomerManager;
import mg.cedric.tpcustomer.entities.Customer;

/**
 *
 * @author CEDRIC
 */
@Named(value = "customerBean")
@ViewScoped
public class CustomerBean implements Serializable {
    
    @EJB  
    private CustomerManager customerManager;
    
    private List<Customer> customerList;
    
    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
    }
    
    /** 
   * Retourne la liste des clients pour affichage dans une DataTable.
   */  
    public List<Customer> getCustomers() {
        if (customerList == null) {
          customerList = customerManager.getAllCustomers();
        }
        return customerList;
    } 
    
}
