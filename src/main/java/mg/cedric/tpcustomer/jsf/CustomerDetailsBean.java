/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.cedric.tpcustomer.jsf;

import  jakarta.inject.Named;
import java.io.Serializable;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.List;
import mg.cedric.tpcustomer.ejb.CustomerManager;
import mg.cedric.tpcustomer.entities.Customer;

import mg.cedric.tpcustomer.ejb.DiscountManager;
import mg.cedric.tpcustomer.entities.Discount;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.application.FacesMessage.Severity;
import jakarta.faces.context.FacesContext;


/**
 *
 * @author CEDRIC
 */
@Named(value = "customerDetailsBean")
@ViewScoped
public class CustomerDetailsBean implements Serializable{
    
    private int idCustomer;
    private Customer customer;
    
    @EJB
    private CustomerManager customerManager;
    
    @EJB
    private DiscountManager discountManager;

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
   * Retourne les détails du client courant (contenu dans l'attribut customer de
   * cette classe).
   */
    public Customer getCustomer() {
      return customer;
    }

  /**
   * Action handler - met à jour dans la base de données les données du client
   * contenu dans la variable d'instance customer.
   * @return la prochaine page à afficher, celle qui affiche la liste des clients.
   */
  public String update() {
    // Modifie la base de données.
    // Il faut affecter à customer (sera expliqué dans le cours).
    
    Severity severity = null;  
    String summary = "";
    String message = "";
    try{
        customer = customerManager.update(customer);
        severity = FacesMessage.SEVERITY_INFO;
        summary = "update done";
        message = customer.getName()+" is updated.";
    }catch(Exception e){
        severity = FacesMessage.SEVERITY_ERROR;
        summary = "update failed";
        message = e.getMessage();
        
    }finally{
        FacesMessage facesMessage = new FacesMessage(severity, summary, message);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
        
    return "CustomerList";
  }

  public void loadCustomer() {
    this.customer = customerManager.findById(idCustomer);
  }
  
  /**
   * Retourne la liste de tous les Discount.
   */
  public List<Discount> getDiscounts() {
    return discountManager.getAllDiscounts();
  }
    
}
