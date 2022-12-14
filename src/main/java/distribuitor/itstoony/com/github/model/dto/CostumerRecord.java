package distribuitor.itstoony.com.github.model.dto;

import distribuitor.itstoony.com.github.model.Costumer;
import distribuitor.itstoony.com.github.model.authentication.CostumerAccount;

public record CostumerRecord(String name, String cpf, String cep, String email, CostumerAccount account) {

    public CostumerRecord(Costumer costumer) {
        this(costumer.getName(), costumer.getCpf(), costumer.getAddress().getZipcode(), costumer.getEmail(), costumer.getAccount());
    }

}
