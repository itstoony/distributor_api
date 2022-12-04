package distribuitor.itstoony.com.github.service;

import distribuitor.itstoony.com.github.model.Costumer;
import distribuitor.itstoony.com.github.model.dto.ClientsDto;
import distribuitor.itstoony.com.github.repository.*;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//TODO: Populate database
@Service
@NoArgsConstructor
public class DBService {

    @Autowired
    private ClientsService clientsService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ClientsRepository clientsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private StatesRepository statesRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private CompanyRepository companyRepository;


    public void populateDatabase() {

        ClientsDto cd1 = new ClientsDto("Renato Enrico Monteiro", "02388223890", "88504461");
        Costumer c1 = clientsService.fromDto(cd1);
        clientsService.insert(c1);

        ClientsDto cd2 = new ClientsDto("Gabrielly Alice Laura Viana", "48960107522", "77001006");
        Costumer c2 = clientsService.fromDto(cd2);
        clientsService.insert(c2);

        ClientsDto cd3 = new ClientsDto("Joana Evelyn Adriana Freitas", "27514241639", "65058650");
        Costumer c3 = clientsService.fromDto(cd3);
        clientsService.insert(c3);
    }
}
