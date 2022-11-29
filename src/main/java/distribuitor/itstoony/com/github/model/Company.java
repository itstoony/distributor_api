package distribuitor.itstoony.com.github.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Company {

  @Id
  @GeneratedValue
  private Long id;

  private String nome;
  private String cnpj;
  private String titular;
  private Double capital;
  private Adress adress;

}
