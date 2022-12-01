package distribuitor.itstoony.com.github.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class ClientsDto {

    private final String name;

    private final String cpf;

    private final String cep;
}