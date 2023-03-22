/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.cedric.tpcustomer.ejb;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import mg.cedric.tpcustomer.entities.Customer;

/**
 *
 * @author CEDRIC
 */
@Stateless
public class CustomerManager {
    
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public void persist(Customer customer) {
      em.persist(customer);
    }

    public List<Customer> getAllCustomers() {  
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }  
        
    public Customer update(Customer customer) {
        return em.merge(customer);  
    }
    
    public Customer findById(int idCustomer) {  
        return em.find(Customer.class, idCustomer);  
    }    
}
