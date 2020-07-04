package guru.springfamework.service;

import guru.springfamework.api.v1.model.CustomerDTO;


import java.util.List;

/**
 * Juerghens castro on 07-02-20 and  08:45 AM to 2020
 */
public interface CustomerService {

    List<CustomerDTO> getAllCustomer();
    CustomerDTO getCustomerById(Long id);
    CustomerDTO createNewCustomer(CustomerDTO customerDTO);

}
