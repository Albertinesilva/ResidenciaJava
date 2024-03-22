package com.swproject.shopall.web.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.swproject.shopall.entities.Product;
import com.swproject.shopall.web.dto.ProductResponseDto;
import com.swproject.shopall.web.dto.form.ProductForm;

public class ProductMapper {

  public static Product toProduct(ProductForm createDto) {
    return new ModelMapper().map(createDto, Product.class);
  }

  public static ProductResponseDto toDto(Product product) {
    PropertyMap<Product, ProductResponseDto> props = new PropertyMap<Product, ProductResponseDto>() {
      @Override
      protected void configure() {
        map().setId(source.getId());
        map().setName(source.getName());
        map().setPrice(source.getPrice());
        map().setImgUrl(source.getImgUrl());
        map().setCategories(source.getCategories());
      }
    };
    ModelMapper mapper = new ModelMapper();
    mapper.addMappings(props);
    return mapper.map(product, ProductResponseDto.class);
  }

  public static List<ProductResponseDto> toListDto(List<Product> products) {
    return products.stream().map(product -> toDto(product)).collect(Collectors.toList());
  }
}
