package guru.springfamework.service;

import guru.springfamework.api.v1.Mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * Juerghens castro on 07-03-20 and  08:04 AM to 2020
 */
public class CustomerServiceImplTest {

    public static final String FIRST_NAME = "Michale";
    public static final String LAST_NAME = "Weston";
    @Mock
    CustomerRepository customerRepository;

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    CustomerService customerService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImpl(customerMapper, customerRepository);
    }

    @Test
    public void getAllCustomers() throws Exception {
        //given
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstName("Michale");
        customer1.setLastName("Weston");

        Customer customer2 = new Customer();
        customer2.setId(2l);
        customer2.setFirstName("Sam");
        customer2.setLastName("Axe");

        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer1, customer2));

        //when
        List<CustomerDTO> customerDTOS = customerService.getAllCustomer();

        //then
        assertEquals(2, customerDTOS.size());

    }

    @Test
    public void getCustomerById() throws Exception {
        //given
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstName(FIRST_NAME);
        customer1.setLastName(LAST_NAME);

        when(customerRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(customer1));

        //when
        CustomerDTO customerDTO = customerService.getCustomerById(1L);

        assertEquals("Michale", customerDTO.getFirstName());
    }

    @Test
    public void createNewCustomer() {

        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(FIRST_NAME);
        Customer saveCustomer = new Customer();
        saveCustomer.setFirstName(customerDTO.getFirstName());
        saveCustomer.setLastName(customerDTO.getLastName());
        saveCustomer.setId(1l);

        when(customerRepository.save(any(Customer.class))).thenReturn(saveCustomer);

        CustomerDTO savedCustomerDTO = customerService.createNewCustomer(customerDTO);

        assertEquals(customerDTO.getFirstName(),savedCustomerDTO.getFirstName());
        assertEquals("api/v1/customers/1",savedCustomerDTO.getCustomerUrl());
    }
}
