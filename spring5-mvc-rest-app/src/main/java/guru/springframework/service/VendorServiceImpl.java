package guru.springframework.service;

import guru.springframework.api.v1.Mapper.VendorMapper;
import guru.springframework.api.v1.model.VendorDTO;
import guru.springframework.controllers.v1.VendorController;
import guru.springframework.domain.Vendor;
import guru.springframework.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Juerghens castro on 07-10-20 and  11:10 AM to 2020
 */
@Service
public class VendorServiceImpl implements VendorService {

    private final VendorMapper vendorMapper;
    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorMapper vendorMapper, VendorRepository vendorRepository) {
        this.vendorMapper = vendorMapper;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public List<VendorDTO> getAllVendors() {


        return vendorRepository.findAll()
                .stream()
                .map(vendor -> {
                    VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
                    vendorDTO.setVendorUrl(getVendorUrl(vendor.getId()));
                    return vendorDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public VendorDTO getVendorByName(String name) {
        //return vendorRepository.findByName(name);
        Vendor vendorName = vendorRepository.findByName(name);
        VendorDTO returnDTO = vendorMapper.vendorToVendorDTO(vendorName);
        returnDTO.setVendorUrl(getVendorUrl(vendorName.getId()));

        return returnDTO;
    }

    @Override
    public VendorDTO getVendorById(Long id) {
        return vendorRepository.findById(id).
                map(vendor -> {
                    VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
                    vendorDTO.setVendorUrl(getVendorUrl(vendor.getId()));
                    return vendorDTO;
                }).orElseThrow(ResourceNotFoundException::new);
    }


    @Override
    public VendorDTO createNewVendor(VendorDTO vendorDTO) {
        return saveAndReturnDTO(vendorMapper.vendorDTOToVendor(vendorDTO));
    }

    @Override
    public VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO) {

        Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);
        vendor.setId(id);


        return saveAndReturnDTO(vendor);
    }

    @Override
    public VendorDTO patchVendor(Long id, VendorDTO vendorDTO) {


        return vendorRepository.findById(id)
                .map(vendor -> {
                    if (vendorDTO.getName() != null) {
                        vendor.setName(vendorDTO.getName());
                    }

                    VendorDTO returnDTO = vendorMapper.vendorToVendorDTO(vendor);
                    returnDTO.setVendorUrl(getVendorUrl(id));
                    return saveAndReturnDTO(vendor);
                }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteVendorById(Long id) {

        vendorRepository.deleteById(id);

    }

    //obtener el url del vendedor
    //se trae la url que se utiliza en el contralador.
    private String getVendorUrl(Long id) {

//        return "/api/v1/vendors" + id;

        return VendorController.BASE_URL +"/"+ id;

    }

    //en este metodo se realiza la accion de guardar un vendedor y retornarlo en
    //tipo data transfer object
    // se recibe un objeto de tipo Vendedor se declara un objeto nuevo donde se
    //guardara el vendedor se utiliza el metodo en el repositorio para guardar
    // se instancia un objeto de tipo vendedor datatransferobject, se utiliza el
    //mapper de vendedor donde convierte la instacia vendedor a el tipo data
    //transfer object y se agrega la url de la api
    // se retorna el vendedor de tipo data transfer object.
    private VendorDTO saveAndReturnDTO(Vendor vendor) {

        Vendor savedVendor = vendorRepository.save(vendor);
        VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(savedVendor);
        vendorDTO.setVendorUrl(getVendorUrl(savedVendor.getId()));

        return vendorDTO;
    }

}
