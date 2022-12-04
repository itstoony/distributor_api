package distribuitor.itstoony.com.github.model.dto;

import distribuitor.itstoony.com.github.model.Costumer;
import lombok.*;

@Data
@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
public class ClientsDto {

    private String name;

    private String cpf;

    private String cep;

    public ClientsDto(Costumer client){}
}