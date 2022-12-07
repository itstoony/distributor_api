package distribuitor.itstoony.com.github.service;

import distribuitor.itstoony.com.github.model.Address;
import distribuitor.itstoony.com.github.model.dto.AddressDto;
import distribuitor.itstoony.com.github.model.enums.AddressType;
import distribuitor.itstoony.com.github.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    /*
     * Consuming "via cep" webservice to get location by zipcode "cep"
     * https://viacep.com.br/
     */
    public AddressDto findCepDto(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        return new RestTemplate().getForObject(url, AddressDto.class);
    }

    public void setAddressType(Address address) {
        if (address.getCompany() == null && address.getDeposit() == null && address.getCostumer() != null) {
            address.setAddressType(AddressType.CLIENTS);
        } else if (address.getCompany() == null && address.getDeposit() != null && address.getCostumer() == null) {
            address.setAddressType(AddressType.DEPOSIT);
        } else if (address.getCompany() != null && address.getDeposit() == null && address.getCostumer() == null) {
            address.setAddressType(AddressType.COMPANY);
        }
    }

    public Address fromDto(AddressDto dto) {
        return Address.builder()
                .city(dto.getLocalidade())
                .states(dto.getUf())
                .neighborhood(dto.getBairro())
                .street(dto.getLogradouro())
                .zipcode(dto.getCep())
                .build();
    }

    public void save(Address address) {
        addressRepository.save(address);
    }

}
