package guru.springframework.api.v1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Juerghens castro on 07-02-20 and  09:24 AM to 2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerListDTO {

    List<CustomerDTO> customers;
}
