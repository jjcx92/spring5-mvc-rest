package guru.springframework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Juerghens castro on 07-02-20 and  08:35 AM to 2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    //private Long id;
    @ApiModelProperty(value = "this is the first name", required = true)
    private String firstName;
    @ApiModelProperty(required = true)
    private String lastName;
    @JsonProperty("customer_url")
    private String  customerUrl;

}
