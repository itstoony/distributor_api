package distribuitor.itstoony.com.github.service;

import distribuitor.itstoony.com.github.model.Costumer;
import distribuitor.itstoony.com.github.model.authentication.CostumerAccount;
import distribuitor.itstoony.com.github.model.dto.CostumerRecord;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class DBService {

    @Autowired
    private CostumerService costumerService;

    @Autowired
    private CostumerAccountService costumerAccountService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private DepositService depositService;

    @Autowired
    private DepositProductService depositProductService;


    public void populateDatabase() {
//
//        Company company = companyService.fromDto("Distribuitor", "45557474000177", "Tony Rene", 0, "01316900");
//        companyService.insert(company);
//
//        Deposit deposit = depositService.createDeposit("01316900");
//        depositService.insert(deposit);
//
////        Product pd1 = productService.createProduct("Notebook Samsung", "Notebook i3 8GB RAM", 1800.00, 1.8);
////        Product pd2 = productService.createProduct("Notebook Samsung", "Notebook i3 8GB RAM", 1800.00, 1.8);
////        Product pd3 = productService.createProduct("Notebook Samsung", "Notebook i3 8GB RAM", 1800.00, 1.8);
////
////        productService.insert(pd1);
////        productService.insert(pd2);
////        productService.insert(pd3);



        CostumerAccount ac1 = new CostumerAccount("iagov", "u7CeXio8hR");
        costumerAccountService.insert(ac1);
        CostumerRecord cd1 = new CostumerRecord("Iago Kevin Pedro Henrique Lopes", "02388223890", "88504461", "iagokevinlopes@slb.com.br", ac1);
        Costumer c1 = costumerService.fromRecord(cd1);
        ac1.setCostumer(c1);
        costumerService.insert(c1);
        costumerAccountService.insert(ac1);


        CostumerAccount ac2 = new CostumerAccount("prisllah", "51xl3Hm3x2");
        costumerAccountService.insert(ac2);
        CostumerRecord cd2 = new CostumerRecord("Priscila Sophia Almada", "48960107522", "77001006", "priscila-almada74@defensoria.sp.gov.br", ac2);
        Costumer c2 = costumerService.fromRecord(cd2);
        ac2.setCostumer(c2);
        costumerService.insert(c2);
        costumerAccountService.insert(ac2);

        CostumerAccount ac3 = new CostumerAccount("vicente12", "lggQ3xP0ST");
        costumerAccountService.insert(ac3);
        CostumerRecord cd3 = new CostumerRecord("Vicente Manoel Drumond", "27514241639", "65058650", "vicente-drumond86@raninho.com.br", ac3);
        Costumer c3 = costumerService.fromRecord(cd3);
        ac3.setCostumer(c3);
        costumerService.insert(c3);
        costumerAccountService.insert(ac3);

//        Deposit deposit = new Deposit(null, new ArrayList<Product>(), );

    }

}
