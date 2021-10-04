package com.example.restaurantmanager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurantmanager.model.Food;

public interface FoodRepo extends JpaRepository<Food,Long>{

	void deleteFoodById(Long id);

	Optional<Food> findFoodById(Long id);
	

}
