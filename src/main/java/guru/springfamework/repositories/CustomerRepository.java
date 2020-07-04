package guru.springfamework.repositories;

import guru.springfamework.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Juerghens castro on 07-02-20 and  08:38 AM to 2020
 */
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    //Customer findByFirstName(String name);
}
