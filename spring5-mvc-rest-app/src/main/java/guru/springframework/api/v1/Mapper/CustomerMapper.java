package guru.springframework.api.v1.Mapper;

import guru.springframework.api.v1.model.CustomerDTO;
import guru.springframework.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Juerghens castro on 07-02-20 and  08:48 AM to 2020
 */

@Mapper
public interface CustomerMapper  {

    CustomerMapper INSTANCE=  Mappers.getMapper(CustomerMapper.class);

    //Mapping (source = "get_id", target="Id")
    CustomerDTO customerToCustomerDTO(Customer customer);
    Customer customerDTOToCustomer(CustomerDTO customerDTO);

}

