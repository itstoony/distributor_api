package distribuitor.itstoony.com.github.service;

import distribuitor.itstoony.com.github.model.Costumer;
import distribuitor.itstoony.com.github.model.dto.CostumerDto;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class DBService {

    @Autowired
    private CostumerService costumerService;


    public void populateDatabase() {

        CostumerDto cd1 = new CostumerDto("Renato Enrico Monteiro", "02388223890", "88504461");
        Costumer c1 = costumerService.fromDto(cd1);
        costumerService.insert(c1);

        CostumerDto cd2 = new CostumerDto("Gabrielly Alice Laura Viana", "48960107522", "77001006");
        Costumer c2 = costumerService.fromDto(cd2);
        costumerService.insert(c2);

        CostumerDto cd3 = new CostumerDto("Joana Evelyn Adriana Freitas", "27514241639", "65058650");
        Costumer c3 = costumerService.fromDto(cd3);
        costumerService.insert(c3);
    }
}
