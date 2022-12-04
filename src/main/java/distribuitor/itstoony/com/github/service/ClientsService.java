package distribuitor.itstoony.com.github.service;

import distribuitor.itstoony.com.github.model.Address;
import distribuitor.itstoony.com.github.model.Costumer;
import distribuitor.itstoony.com.github.model.dto.AddressDto;
import distribuitor.itstoony.com.github.model.dto.ClientsDto;
import distribuitor.itstoony.com.github.repository.AddressRepository;
import distribuitor.itstoony.com.github.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;
    @Autowired
    private ClientsRepository clientsRepository;


    public Costumer fromDto(ClientsDto dto) {

        AddressDto addressDto = addressService.findCep(dto.getCep());

        Address address = addressService.fromDto(addressDto);

        Costumer costumer = Costumer.builder()
                .name(dto.getName())
                .cpf(dto.getCpf())
                .address(address)
                .registrationDate(LocalDate.now())
                .build();

        address.setCostumer(costumer);
        addressService.setAddressType(costumer.getAddress());
        return costumer;
    }

    @Transactional
    public void insert(Costumer costumer) {
        costumer.setId(null);
        addressRepository.save(costumer.getAddress());
        clientsRepository.save(costumer);
    }

    public Costumer findById(Long id) {
        Optional<Costumer> clients = clientsRepository.findById(id);
        return clients.orElseThrow(() -> new RuntimeException("Object not found"));
    }

    public List<ClientsDto> findAll() {
        List<Costumer> listClients = clientsRepository.findAll();
        List<ClientsDto> listDto = new ArrayList<>();

        for (Costumer c : listClients){
            listDto.add(ConvertToDto(c));
        }
        return listDto;
    }

    private ClientsDto ConvertToDto(Costumer costumer) {
        return   ClientsDto.builder()
                .cep(costumer.getAddress().getZipcode())
                .name(costumer.getName())
                .cpf(costumer.getCpf())
                .build();
    }

    public Page<Costumer> findByPageableClientsName(String name, Integer page, Integer linePerPage, String orderBy, String direction) {

        PageRequest clientsRequest = PageRequest.of(page, linePerPage, Sort.Direction.valueOf(direction), orderBy);
        return clientsRepository.findByPageableClientsName(name, clientsRequest);

    }

    public Costumer findByClientsName(String name) {
        Optional<Costumer> clients = Optional.ofNullable(clientsRepository.findAllByName(name));
        return clients.orElseThrow(() -> new RuntimeException("Object not found"));
    }

    public Page<ClientsDto> pageToDto(Page<Costumer> page) {
        return page.map(ClientsDto::new);
    }


}
