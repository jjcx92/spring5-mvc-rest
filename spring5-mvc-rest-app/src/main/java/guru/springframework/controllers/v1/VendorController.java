package guru.springframework.controllers.v1;


import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.api.v1.model.VendorListDTO;
import guru.springframework.service.VendorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Juerghens castro on 07-10-20 and  12:44 PM to 2020
 */

@Api(description = "this is my vendor API")
@RestController
@RequestMapping(VendorController.BASE_URL)
public class VendorController {

    public static final String BASE_URL = "/api/v1/vendors";

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }
    @ApiOperation(value = "View List of Vendors", notes="These are some API Notes")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public VendorListDTO getAllVendors() {

        return new VendorListDTO(vendorService.getAllVendors());
    }
    @ApiOperation(value = "Get Vendor by Name")
    @GetMapping("/findByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO getVendorByName(@PathVariable String name) {

        return vendorService.getVendorByName(name);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO getVendorById(@PathVariable Long id) {
        return vendorService.getVendorById(id);
    }
    @ApiOperation(value = "Create a new Vendor")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendorDTO createNewVendor(@RequestBody VendorDTO vendorDTO ) {

        return vendorService.createNewVendor(vendorDTO);
    }
    @ApiOperation(value = "Update an existing Vendor")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO updateVendor(@PathVariable Long id,@RequestBody VendorDTO vendorDTO) {
        return vendorService.saveVendorByDTO(id,vendorDTO);
    }

    @ApiOperation(value = "Update a Vendor Property")
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO patchVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO) {
        return vendorService.saveVendorByDTO(id,vendorDTO);
    }
    @ApiOperation(value = "Delete a Vendor")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendorById(id);
    }
}
