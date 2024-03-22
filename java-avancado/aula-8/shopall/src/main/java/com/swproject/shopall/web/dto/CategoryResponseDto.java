package com.swproject.shopall.web.dto;

import java.util.Set;

import com.swproject.shopall.entities.AbstractEntity;
import com.swproject.shopall.entities.Category;
import com.swproject.shopall.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryResponseDto extends AbstractEntity {

  private Long id;
  private String name;
  private Set<Product> products;

  public CategoryResponseDto(String name, Category category, Set<Product> products) {
    setId(category.getId());
    this.name = category.getName();
    this.products = category.getProducts();
  }
}
