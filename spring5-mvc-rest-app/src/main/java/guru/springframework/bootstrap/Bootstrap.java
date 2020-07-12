package guru.springframework.bootstrap;

import guru.springframework.domain.Category;
import guru.springframework.domain.Customer;
import guru.springframework.domain.Vendor;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.CustomerRepository;
import guru.springframework.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Juerghens castro on 07-01-20 and  08:35 AM to 2020
 */

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository,
                     CustomerRepository customerRepository,
                     VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        loadCategories();
        LoadCustomers();
        LoadVendor();
    }

    private void LoadCustomers() {
        Customer jass = new Customer();
        jass.setId(1L);
        jass.setFirstName("jass");
        jass.setLastName("Jimenez");
        Customer Jose = new Customer();
        Jose.setId(2L);
        Jose.setFirstName("Jose");
        Jose.setLastName("Castro");
        Customer meysi = new Customer();
        meysi.setId(3L);
        meysi.setFirstName("meysi");
        meysi.setLastName("jimenez");


        customerRepository.save(jass);
        customerRepository.save(Jose);
        customerRepository.save(meysi);


        System.out.println("Customer loaded= " + customerRepository.count());
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");
        Category dried = new Category();
        dried.setName("Dried");
        Category fresh = new Category();
        fresh.setName("Fresh");
        Category exotic = new Category();
        exotic.setName("Exotic");
        Category nuts = new Category();
        nuts.setName("nuts");
        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);
        System.out.println("Data loaded= " + categoryRepository.count());
    }

    private void LoadVendor() {
        Vendor Jass = new Vendor();
        Jass.setName("Jass");
        Vendor Joss = new Vendor();
        Joss.setName("Joss");
        Vendor Paty = new Vendor();
        Paty.setName("Paty");
        Vendor Ana = new Vendor();
        Ana.setName("Ana");
        Vendor Poss = new Vendor();
        Poss.setName("poss");
        vendorRepository.save(Jass);
        vendorRepository.save(Joss);
        vendorRepository.save(Ana);
        vendorRepository.save(Paty);
        vendorRepository.save(Poss);
        System.out.println("Data loaded= " + vendorRepository.count());
    }
}
