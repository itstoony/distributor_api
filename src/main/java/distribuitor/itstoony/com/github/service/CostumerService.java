package distribuitor.itstoony.com.github.service;

import distribuitor.itstoony.com.github.model.Address;
import distribuitor.itstoony.com.github.model.Costumer;
import distribuitor.itstoony.com.github.model.authentication.CostumerAccount;
import distribuitor.itstoony.com.github.model.dto.AddressDto;
import distribuitor.itstoony.com.github.model.dto.CostumerDto;
import distribuitor.itstoony.com.github.model.dto.CostumerRecord;
import distribuitor.itstoony.com.github.repository.CostumerRepository;
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
public class CostumerService {

    @Autowired
    private AddressService addressService;

    @Autowired
    private CostumerRepository clientsRepository;

    @Autowired
    private CostumerAccountService costumerAccountService;

    public Costumer fromDto(CostumerDto dto) {

        AddressDto addressDto = addressService.findCepDto(dto.getCep());

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


    public Costumer fromRecord(CostumerRecord record) {

        AddressDto dto = addressService.findCepDto(record.cep());

        Address address = addressService.fromDto(dto);

        CostumerAccount account = record.account();

        Costumer costumer = Costumer.builder()
                .name(record.name())
                .cpf(record.cpf())
                .email(record.email())
                .address(address)
                .registrationDate(LocalDate.now())
                .account(account)
                .build();

        address.setCostumer(costumer);
        account.setCostumer(costumer);
        addressService.setAddressType(costumer.getAddress());

        return costumer;
    }

    @Transactional
    public void insert(Costumer costumer) {
        costumer.setId(null);
        addressService.insert(costumer.getAddress());
        clientsRepository.save(costumer);
    }

    public Costumer findById(Long id) {
        Optional<Costumer> clients = clientsRepository.findById(id);
        return clients.orElseThrow(() -> new RuntimeException("Object not found"));
    }

    public Optional<Costumer> findByIdOptional(Long id) {
        return clientsRepository.findById(id);
    }

    public List<CostumerDto> findAllDto() {
        List<Costumer> listClients = clientsRepository.findAll();

        List<CostumerDto> listDto = new ArrayList<>();

        for (Costumer c : listClients) {
            listDto.add(ConvertToDto(c));
        }

        return listDto;
    }

    public List<Costumer> findAll(){
        return clientsRepository.findAll();
    }

    private CostumerDto ConvertToDto(Costumer costumer) {
        return CostumerDto.builder()
                .cep(costumer.getAddress().getZipcode())
                .name(costumer.getName())
                .cpf(costumer.getCpf())
                .build();
    }

    public Page<Costumer> findByPageableClientsName(String name, Integer page, Integer linePerPage, String orderBy, String direction) {
        PageRequest clientsRequest = PageRequest.of(page, linePerPage, Sort.Direction.valueOf(direction), orderBy);
        return clientsRepository.findByPageableClientsName(name, clientsRequest);
    }


    public void deleteById(Long id) {
        findById(id);
        clientsRepository.deleteById(id);
    }

    public CostumerDto toDto(Costumer customer) {
        return CostumerDto.builder()
                .name(customer.getName())
                .cep(customer.getAddress().getZipcode())
                .cpf(customer.getCpf())
                .build();
    }

    public Costumer update(Long id, CostumerDto updated) {
        AddressDto addressDto = addressService.findCepDto(updated.getCep());
        Address address = addressService.fromDto(addressDto);
        addressService.insert(address);

        Costumer costumer = findById(id);
        costumer.setName(updated.getName());
        costumer.setCpf(updated.getCpf());
        costumer.setAddress(address);

        return costumer;
    }

}
