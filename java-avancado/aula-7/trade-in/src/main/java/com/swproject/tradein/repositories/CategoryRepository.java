package com.swproject.tradein.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swproject.tradein.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
  
}
