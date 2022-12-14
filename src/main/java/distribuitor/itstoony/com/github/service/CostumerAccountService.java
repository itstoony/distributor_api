package distribuitor.itstoony.com.github.service;

import distribuitor.itstoony.com.github.model.authentication.CostumerAccount;
import distribuitor.itstoony.com.github.repository.CostumerAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostumerAccountService {

    @Autowired
    private CostumerAccountRepository costumerAccountRepository;


    public void insert(CostumerAccount costumerAccount){
        costumerAccountRepository.save(costumerAccount);
    }
}
