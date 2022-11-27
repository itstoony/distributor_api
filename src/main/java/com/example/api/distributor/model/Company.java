package com.example.api.distributor.model;

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

}
