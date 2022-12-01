package distribuitor.itstoony.com.github.service;

import distribuitor.itstoony.com.github.repository.*;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//TODO: Populate database
@Service
@NoArgsConstructor
public class DBService {


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

//        ResidencialAddress ad = new ResidencialAddress();
//        AddressDto dto = AddressDto.getAddress("26060230");
//        ad.setStreet(dto.getLogradouro());
//        ad.setNeighborhood(dto.getBairro());
//        ad.setCity(dto.getLocalidade());
//        ad.setStates(dto.getUf());
//        residencialAddressRepository.save(ad);
//
//        Clients c1 = new Clients("Tony", "123.123.123-23", ad);
//        clientsRepository.save(c1);

    }
}
