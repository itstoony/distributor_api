package distribuitor.itstoony.com.github.service;

import distribuitor.itstoony.com.github.model.Address;
import distribuitor.itstoony.com.github.model.Clients;
import distribuitor.itstoony.com.github.model.dto.AddressDto;
import distribuitor.itstoony.com.github.model.dto.ClientsDto;
import distribuitor.itstoony.com.github.model.enums.AddressType;
import distribuitor.itstoony.com.github.repository.AddressRepository;
import distribuitor.itstoony.com.github.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ClientsService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ClientsRepository clientsRepository;


    public AddressDto findCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        return new RestTemplate().getForObject(url, AddressDto.class);
    }

    public Clients fromDto(ClientsDto dto) {

        AddressDto addressDto = findCep(dto.getCep());

        Address address = Address.builder()
                .city(addressDto.getLocalidade())
                .states(addressDto.getUf())
                .neighborhood(addressDto.getBairro())
                .street(addressDto.getLogradouro())
                .zipcode(addressDto.getCep())
                .build();

        Clients clients = Clients.builder()
                .name(dto.getName())
                .cpf(dto.getCpf())
                .address(address)
                .dataDeCadastro(LocalDate.now())
                .build();

        address.setClients(clients);

        setAddressType(clients.getAddress());
        return clients;
    }

    private void setAddressType(Address address) {
        if (address.getCompany() == null && address.getDeposit() == null && address.getClients() != null) {
            address.setAddressType(AddressType.CLIENTS);
        } else if (address.getCompany() == null && address.getDeposit() != null && address.getClients() == null) {
            address.setAddressType(AddressType.DEPOSIT);
        } else if (address.getCompany() != null && address.getDeposit() == null && address.getClients() == null) {
            address.setAddressType(AddressType.COMPANY);
        }
    }

    @Transactional
    public void insert(Clients clients) {
        clients.setId(null);
        addressRepository.save(clients.getAddress());
        clientsRepository.save(clients);
    }

    public Clients findById(Long id) {
        Optional<Clients> clients = clientsRepository.findById(id);
        return clients.orElseThrow(() -> new RuntimeException("Object not found"));
    }
}
