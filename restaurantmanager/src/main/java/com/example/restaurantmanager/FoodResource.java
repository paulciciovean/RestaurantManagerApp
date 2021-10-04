package com.example.restaurantmanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.restaurantmanager.model.Food;
import com.example.restaurantmanager.service.FoodService;
import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodResource {
	private final FoodService foodService;
	public FoodResource(FoodService foodService)
	{
		this.foodService=foodService;
	}
	@GetMapping("/all")
	public ResponseEntity<List<Food>> getAllFoods()
	{
		List<Food> foods= foodService.findAllfoods();
		return new ResponseEntity<>(foods,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Food> getFoodById(@PathVariable("id") Long id)
	{
		Food food= foodService.findFood(id);
		return new ResponseEntity<>(food,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Food> addFood(@RequestBody Food food)
	{
		Food newFood = foodService.addFood(food);
		return new ResponseEntity<>(newFood,HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<Food> updateFood(@RequestBody Food food)
	{
		Food updateFood = foodService.updateFood(food);
		return new ResponseEntity<>(updateFood,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteFood(@PathVariable("id") Long id)
	{
		foodService.deleteFood(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
