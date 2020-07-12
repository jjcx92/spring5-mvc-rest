package guru.springframework.api.v1.Mapper;

import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.domain.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Juerghens castro on 07-10-20 and  10:55 AM to 2020
 */
@Mapper
public interface VendorMapper {

    VendorMapper INSTANCE= Mappers.getMapper(VendorMapper.class);

    VendorDTO vendorToVendorDTO(Vendor vendor);
    Vendor vendorDTOToVendor(VendorDTO vendorDTO);

}
