import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FoodService } from './food.service';

@NgModule({
  declarations: [
    AppComponent
    
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [FoodService],
  bootstrap: [AppComponent]
})
export class AppModule { }
