package guru.springfamework.api.v1.Mapper;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.controllers.v1.VendorController;
import guru.springfamework.domain.Vendor;
import org.junit.Test;
import org.springframework.test.context.TestPropertySource;

import javax.naming.Name;

import static org.junit.Assert.*;

/**
 * Juerghens castro on 07-10-20 and  01:42 PM to 2020
 */
public class VendorMapperTest {

    public static final Long ID=1L;
    public static final String NAME="Jim";

    VendorMapper vendorMapper=VendorMapper.INSTANCE;

    @Test
    public void vendorToVendorDTO() throws Exception {

        //given
        Vendor vendor=new Vendor();
        vendor.setName(NAME);


        //when
        VendorDTO vendorDTO=vendorMapper.vendorToVendorDTO(vendor);

        //then

        //assertEquals(Long.valueOf(ID), vendorDTO.g);
        assertEquals(NAME,vendorDTO.getName());

    }

    @Test
    public void VendorDTOToVendor() throws Exception {
        VendorDTO vendorDTO=new VendorDTO();
        vendorDTO.setName(NAME);
        //vendorDTO.setVendorUrl(VendorController.BASE_URL+id);

        Vendor vendor= vendorMapper.vendorDTOToVendor(vendorDTO);


        assertEquals(NAME, vendor.getName());
    }

}
