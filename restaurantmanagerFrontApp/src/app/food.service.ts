import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http';
import { Food } from "./food";
import { environment } from "src/environments/environment";

@Injectable({
    providedIn: 'root'

})
export class FoodService
{
    private apiServerUrl=environment.apiBaseUrl;
    constructor(private http: HttpClient){}

    public getFoods(): Observable<Food[]>
    {
        return this.http.get<Food[]>(`${this.apiServerUrl}/food/all`);
    }
    public addFood(food: Food): Observable<Food>
    {
        return this.http.post<Food>(`${this.apiServerUrl}/food/add`,food);
    }
    public updateFood(food: Food): Observable<Food>
    {
        return this.http.put<Food>(`${this.apiServerUrl}/food/update`,food);
    }
    public deleteFood(foodId: number): Observable<void>
    {
        return this.http.delete<void>(`${this.apiServerUrl}/food/delete/${foodId}`);
    }
}