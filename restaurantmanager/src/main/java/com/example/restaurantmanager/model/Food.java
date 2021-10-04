package com.example.restaurantmanager.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Food implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, updatable=false)
	private Long id;
	private String name;
	private float price;
	private String imageUrl;
	private String description;
	
	public Food() {}
	public Food(String name,float price,String imageUrl)
	{
		this.name=name;
		this.price=price;
		this.imageUrl=imageUrl;
	}
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id=id;
	}
	public String getName()
	{
		return name;
	}
	public void  setName(String name)
	{
		this.name=name;
	}
	public float getPrice()
	{
		return price;
	}
	public void setPrice(float price)
	{
		 this.price=price;
	}
	public String getImageUrl()
	{
		return imageUrl;
	}
	public void setImageUrl(String imageUrl)
	{
		 this.imageUrl=imageUrl;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String description)
	{
		 this.description=description;
	}
	@Override
	public String toString()
	{
		return "Food {"+
				"id="+ id +
				", name='"+ name + '\''+
				", price= '"+ price + '\'' +
				", imageUrl='" + imageUrl + '\''+
				", description='" + description + '\''+
				'}';
	}
	
	
}