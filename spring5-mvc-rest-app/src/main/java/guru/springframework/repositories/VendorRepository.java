package guru.springframework.repositories;

import guru.springframework.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Juerghens castro on 07-10-20 and  11:12 AM to 2020
 */
public interface VendorRepository extends JpaRepository<Vendor, Long> {
    Vendor findByName(String name);

}
