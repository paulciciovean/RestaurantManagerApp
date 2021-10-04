package com.example.restaurantmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurantmanager.exception.FoodNotFoundException;
import com.example.restaurantmanager.model.Food;
import com.example.restaurantmanager.repo.FoodRepo;
import java.util.List;

@Service
public class FoodService {

	private final FoodRepo foodRepo;
	
	@Autowired
	public FoodService(FoodRepo foodRepo)
	{
		this.foodRepo=foodRepo;
	}
	
	public Food addFood(Food food)
	{
		return foodRepo.save(food);
	}
	public List<Food> findAllfoods()
	{
		return foodRepo.findAll();
	}
	public Food updateFood(Food food)
	{
		return foodRepo.save(food);
	}
	public Food findFood(Long id)
	{
		return foodRepo.findFoodById(id).orElseThrow(()-> new FoodNotFoundException("Food with this id" + id + "was not found") );
	}
	public void deleteFood(Long id)
	{
		
		foodRepo.deleteById(id);
	}
}
