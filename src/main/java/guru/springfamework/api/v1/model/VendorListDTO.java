package guru.springfamework.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Juerghens castro on 07-10-20 and  12:51 PM to 2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorListDTO {

    List<VendorDTO> vendors;

}
