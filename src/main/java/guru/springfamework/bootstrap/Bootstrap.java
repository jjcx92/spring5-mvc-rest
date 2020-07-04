package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Juerghens castro on 07-01-20 and  08:35 AM to 2020
 */

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        loadCategories();
//        LoadCustomers();
    }

    private void LoadCustomers() {
        Customer jass= new Customer();
        jass.setId(1L);
        jass.setFirstName("jass");
        jass.setLastName("Jimenez");
        Customer Jose= new Customer();
        Jose.setId(2L);
        Jose.setFirstName("Jose");
        Jose.setLastName("Castro");
        Customer meysi= new Customer();
        meysi.setId(3L);
        meysi.setFirstName("meysi");
        meysi.setLastName("jimenez");


        customerRepository.save(jass);
        customerRepository.save(Jose);
        customerRepository.save(meysi);


        System.out.println("Customer loaded= "+ customerRepository.count());
    }

    private void loadCategories() {
        Category fruits=new Category();
        fruits.setName("Fruits");
        Category dried=new Category();
        dried.setName("Dried");
        Category fresh=new Category();
        fresh.setName("Fresh");
        Category exotic=new Category();
        exotic.setName("Exotic");
        Category nuts=new Category();
        nuts.setName("nuts");
        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);
        System.out.println("Data loaded= " + categoryRepository.count());
    }
}
