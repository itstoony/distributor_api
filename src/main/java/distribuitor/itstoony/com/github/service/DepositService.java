package distribuitor.itstoony.com.github.service;

import distribuitor.itstoony.com.github.model.Address;
import distribuitor.itstoony.com.github.model.Deposit;
import distribuitor.itstoony.com.github.model.DepositProduct;
import distribuitor.itstoony.com.github.repository.DepositProductRepository;
import distribuitor.itstoony.com.github.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DepositService {

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ProductService productService;

    @Autowired
    private DepositProductRepository depositProductRepository;

    public Deposit createDeposit( String cep) {

        Address address = addressService.findByCep(cep);

        DepositProduct products = new DepositProduct();

        Deposit deposit = Deposit.builder()
                .address(address)
                .products(new ArrayList<>())
                .build();

        addProduct(deposit, products);
        depositProductRepository.save(products);
        depositRepository.save(deposit);

        return deposit;

    }

//    public void addProduct(Deposit deposit, Product product){
//        deposit.getProductList().add(product);
//    }

    public void insert(Deposit deposit){
        depositRepository.save(deposit);
    }

    public void addProduct(Deposit deposit, DepositProduct product){
        deposit.getProducts().add(product);
    }
}
