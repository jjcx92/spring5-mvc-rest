package guru.springfamework.service;

import guru.springfamework.api.v1.Mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
                    System.out.println(customer.getId());
                    customerDTO.setCustomerUrl("/api/v1/customers/" + customer.getId());

                    return customerDTO;
                })
                .collect(Collectors.toList());
    }


    @Override
    public CustomerDTO getCustomerById(Long id) {
 /*       return customerMapper.customerToCustomerDTO
                (customerRepository.findByFirstName(name));*/

      /*  return customerRepository.findById(id)
                .map(customerMapper::customerToCustomerDTO)
                .orElseThrow(RuntimeException::new);//todo implement better exception handling*/

        return customerRepository.findById(id)
                .map(customer -> {
                    CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
                    customerDTO.setCustomerUrl("/api/v1/customers/" + customer.getId());

                    return customerDTO;
                }).orElseThrow(RuntimeException::new); //todo implement better exception handling

    }

    //implementacion de crear un nuevo customer
    // se recibe un Customer de tipo DTO se convienrte a un tipo domain
    // se procesa para guardar en
    //con el custom repository y se procede
    // a convertir nuevamente a tipo data transfer object.
    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {

        //Customer customer=customerMapper.customerDTOToCustomer(customerDTO);
        // se desestima se creo un metodo para crear y actualizar
        /*Customer savedCustomer=customerRepository.save(customer);
        CustomerDTO returnDTO=customerMapper.customerToCustomerDTO(savedCustomer);
        returnDTO.setCustomerUrl("api/v1/customers/"+ savedCustomer.getId());
*/

        return saveAndReturnDTO(customerMapper.customerDTOToCustomer(customerDTO));
    }

    //receive a Customer and proceed to save with de customer repository method save
    // declare a object type DTO and convert the object type domain to dto
    //add the custome url at the dto and concat the id of saved customer
    private CustomerDTO saveAndReturnDTO(Customer customer) {

        Customer savedCustomer = customerRepository.save(customer);
        CustomerDTO returnDTO = customerMapper.customerToCustomerDTO(savedCustomer);
        returnDTO.setCustomerUrl(("/api/v1/customers/" + savedCustomer.getId()));
        return returnDTO;
    }

    @Override
    public CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        customer.setId(id);

        return saveAndReturnDTO(customer);
    }

    @Override
    public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {

        return customerRepository.findById(id).map(customer -> {
            //Optional<CustomerDTO>customerDTO1=customerDTO;
            if (customerDTO.getFirstName() != null) {
                customer.setFirstName(customerDTO.getFirstName());
            }
            if (customerDTO.getLastName() != null) {
                customer.setLastName(customerDTO.getLastName());
            }
//            return customerMapper.customerToCustomerDTO(customerRepository.save(customer));

            CustomerDTO returnDTO= customerMapper.customerToCustomerDTO(customerRepository.save(customer));
            returnDTO.setCustomerUrl("/api/v1/customers/"+ id);
            return returnDTO;

        }).orElseThrow(RuntimeException::new);// todo implement better exception handling
    }

    @Override
    public void deleteCustomerById(Long id) {

        /*if (id == null || id<=0) {
        }else*/
            customerRepository.deleteById(id);
    }
}
