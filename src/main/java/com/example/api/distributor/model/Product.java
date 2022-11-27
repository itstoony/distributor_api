package com.example.api.distributor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue
  private Long id;

//  @Size(min = 1, max = 255, message = "Category Name Required.")
  private String name;

  @ManyToMany
  private List<Category> category;

  public Product(){

  }
}
