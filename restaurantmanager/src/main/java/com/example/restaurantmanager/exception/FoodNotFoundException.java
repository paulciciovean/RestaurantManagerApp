package com.example.restaurantmanager.exception;

public class FoodNotFoundException extends RuntimeException{
	public FoodNotFoundException (String message)
	{
		super(message);
	}

}
