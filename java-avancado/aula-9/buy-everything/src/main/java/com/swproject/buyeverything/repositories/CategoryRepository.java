package com.swproject.buyeverything.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swproject.buyeverything.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
  
}
