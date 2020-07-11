package guru.springfamework.service;

import guru.springfamework.api.v1.model.VendorDTO;

import java.util.List;

/**
 * Juerghens castro on 07-10-20 and  11:08 AM to 2020
 */
public interface VendorService {


    List<VendorDTO> getAllVendors();

    VendorDTO getVendorByName(String name);

    VendorDTO getVendorById(Long id);

    VendorDTO createNewVendor(VendorDTO vendorDTO);

    VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO);

    VendorDTO patchVendor(Long id, VendorDTO vendorDTO);

    void deleteVendorById(Long id);


}
