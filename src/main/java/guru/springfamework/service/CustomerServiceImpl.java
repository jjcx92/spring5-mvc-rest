package guru.springfamework.service;

import guru.springfamework.api.v1.Mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Juerghens castro on 07-02-20 and  08:48 AM to 2020
 */
@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper,
                               CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        /*return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());*/
        return customerRepository.findAll()
                .stream()
                .map(customer -> {
                    CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
                    customerDTO.setCustomerUrl("/api/v1/customer/" + customer.getId());

                    return customerDTO;
                })
                .collect(Collectors.toList());
    }


    @Override
    public CustomerDTO getCustomerById(Long id) {
 /*       return customerMapper.customerToCustomerDTO
                (customerRepository.findByFirstName(name));*/

 return customerRepository.findById(id)
         .map(customerMapper::customerToCustomerDTO)
         .orElseThrow(RuntimeException::new);//todo implement better exception handling
    }
}
