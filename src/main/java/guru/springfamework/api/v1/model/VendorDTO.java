package guru.springfamework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * Juerghens castro on 07-10-20 and  10:52 AM to 2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDTO {

    private String name;
    @JsonProperty("vendorUrl")
    private String vendorUrl;

}
