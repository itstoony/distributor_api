package distribuitor.itstoony.com.github.service;

import distribuitor.itstoony.com.github.model.Address;
import distribuitor.itstoony.com.github.model.Company;
import distribuitor.itstoony.com.github.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    AddressService addressService;

    public Company fromDto(String name, String cnpj, String owner, double capital, String cep) {

        Address address = addressService.findByCep(cep);

        return Company.builder()
                .nome(name)
                .cnpj(cnpj)
                .owner(owner)
                .capital(capital)
                .address(address)
                .build();

    }

    @Transactional
    public void insert(Company company){
        company.setId(null);
        addressService.insert(company.getAddress());
        companyRepository.save(company);
    }

    @Transactional
    public void addCapital(Company company, Double value){
        company.setCapital(company.getCapital() + value);
    }
}
