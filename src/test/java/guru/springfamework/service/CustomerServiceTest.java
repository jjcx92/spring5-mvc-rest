package guru.springfamework.service;

import guru.springfamework.api.v1.Mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Juerghens castro on 07-02-20 and  10:01 AM to 2020
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    public static final Long ID = 1L;
    public static final String FIRSTNAME = "Josep";
    public static final String lasTNAME = "Cas";

    CustomerService customerService;
    @Mock
    CustomerRepository customerRepository;

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImpl(customerMapper, customerRepository);

    }


    @Test
    public void getAllCateoories() throws Exception{

        //given
        List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        //when
        List<CustomerDTO> customerDTOS=customerService.getAllCustomer();

        //then
        assertEquals(3,customerDTOS.size());


    }


    @Test
    public void getCategoryId() throws Exception {

        //given
        Customer customer= new Customer();
        customer.setId(ID);
        customer.setFirstName(FIRSTNAME);
        customer.setLastName(lasTNAME);
        when(customerRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(customer));

        //when
        CustomerDTO customerDTO=customerService.getCustomerById(ID);

        //then

        assertEquals(FIRSTNAME,customerDTO.getFirstName());
        assertEquals(lasTNAME,customerDTO.getLastName());
    }
}
