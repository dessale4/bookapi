import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {BookComponent}  from './book/book.component'
import {BookService} from './book/book.service'
import { HttpModule } from '@angular/http';// HttpModule is used to facilitate http requests from Angular to spring data bases
import {FormsModule} from '@angular/forms';// FormsModule is helpful to facilitate data binding for form controls in Angular

//in declarations we tell angular the list of components we have in our project
@NgModule({
  declarations: [ 
    AppComponent,
    BookComponent
  ],
  imports: [
    BrowserModule, HttpModule, 
    FormsModule
  ],
  providers: [BookService],
  bootstrap: [AppComponent]
})
export class AppModule { }
