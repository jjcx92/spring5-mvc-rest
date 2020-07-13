package guru.springframework.service;

//import guru.springframework.api.v1.model.CustomerDTO;


import guru.springframework.model.CustomerDTO;

import java.util.List;

/**
 * Juerghens castro on 07-02-20 and  08:45 AM to 2020
 */
public interface CustomerService {

    List<CustomerDTO> getAllCustomer();
    CustomerDTO getCustomerById(Long id);
    CustomerDTO createNewCustomer(CustomerDTO customerDTO);
    CustomerDTO saveCustomerByDTO(Long id, CustomerDTO CustomerDTO);
    CustomerDTO patchCustomer(Long id , CustomerDTO customerDTO);
    void deleteCustomerById(Long id);

}
