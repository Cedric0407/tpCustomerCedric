/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.cedric.tpcustomer.jsf;

import  jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import java.io.Serializable;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import mg.cedric.tpcustomer.ejb.CustomerManager;
import mg.cedric.tpcustomer.entities.Customer;

/**
 *
 * @author CEDRIC
 */
@Named(value = "customerDetailsBean")
@Dependent
public class CustomerDetailsBean {
    
    private int idCustomer;
    private Customer customer;
    
    @EJB
    private CustomerManager customerManager;

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
    customer = customerManager.update(customer);
    return "customerList";
  }

  public void loadCustomer() {
    this.customer = customerManager.findById(idCustomer);
  }
    
}
