import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Food } from './food';
import { FoodService } from './food.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  
  public foods: Food[] = []; 
  public updatedFood!: Food; 
  public deleteFoodId!: number;

  constructor(private foodService: FoodService){}

  ngOnInit(){
    this.getFoods();
  }

  public getFoods(): void
  {
    this.foodService.getFoods().subscribe(
      (response: Food[]) => {
        this.foods=response;
      },(error: HttpErrorResponse)=> {
        console.log("error")
      }
    )
  }
  public onAddFood(addForm: NgForm): void
  {
    document.getElementById("add-food-form")?.click()
    this.foodService.addFood(addForm.value).subscribe(
      (response: Food) => {
        console.log(response);
        this.getFoods();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public getUpdatedFood(food: Food): void
  {
    this.updatedFood=food;
    console.log("You clicked on : ",this.updatedFood)
  
  }


  public onUpdateFood(updateForm: NgForm): void
  {
    document.getElementById("update-food-form")?.click()
    updateForm.value['id']=this.updatedFood.id;
    this.foodService.updateFood(updateForm.value).subscribe(
      (response: Food) =>
      {
        console.log(response);
        this.getFoods();
        
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        
      }
    );

    
  
  /*console.log("You clicked to update this",this.updatedFood);
  console.log("you want to swap with: ",updateForm.value);*/
  }
  public getDeleteId(id: number): void
  {
    this.deleteFoodId=id;
    console.log(this.deleteFoodId);
  }
  public onDeleteFood(): void
    {
      document.getElementById("closeButton")?.click();
      this.foodService.deleteFood(this.deleteFoodId).subscribe(
        (response: void) =>
        {
          console.log(response);
        this.getFoods();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
          
        }
      )
    }

    public searchFood(key: string): void
    {
      const searchedFoods: Food[]=[];
      for(const sFoods of this.foods)
      {
        if(sFoods.name.toLowerCase().indexOf(key.toLowerCase())!= -1 )
          searchedFoods.push(sFoods);
      }
    this.foods=searchedFoods;
    if(searchedFoods.length==0 || !key)
      this.getFoods();
    }
}


