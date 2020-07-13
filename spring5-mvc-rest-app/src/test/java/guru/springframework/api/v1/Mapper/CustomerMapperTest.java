package guru.springframework.api.v1.Mapper;

//import guru.springframework.api.v1.model.CustomerDTO;
import guru.springframework.model.CustomerDTO;
import guru.springframework.domain.Customer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Juerghens castro on 07-02-20 and  09:31 AM to 2020
 */

public class CustomerMapperTest {

    public static final Long ID = 1L;
    public static final String FIRSTNAME = "Josep";
    public static final String lasTNAME = "Cas";
    CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    @Test
    public void customerToCustomerDTO() throws Exception{
        //given
        Customer customer = new Customer();
        //customer.setId(ID);
        customer.setFirstName(FIRSTNAME);
        customer.setLastName(lasTNAME);

        //when
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        //then
        // nose utiliza el ID assertEquals(Long.valueOf(ID), customerDTO.getId());
        assertEquals(FIRSTNAME, customerDTO.getFirstName());
        assertEquals(lasTNAME,customerDTO.getLastName());
    }

    @Test
    public void CustomerDTOToCustomer() throws Exception {
        CustomerDTO customerDTO= new CustomerDTO();
        customerDTO.setFirstName(FIRSTNAME);
        customerDTO.setLastName(lasTNAME);


        Customer customer= customerMapper.customerDTOToCustomer(customerDTO);

        assertEquals(FIRSTNAME, customer.getFirstName() );
        assertEquals(lasTNAME, customer.getLastName());
    }
}
