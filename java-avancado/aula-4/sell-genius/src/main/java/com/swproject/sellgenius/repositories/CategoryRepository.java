package com.swproject.sellgenius.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swproject.sellgenius.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
  
}
