package distribuitor.itstoony.com.github.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
public class CostumerDto {

    private String name;
    private String cpf;
    private String cep;

}
