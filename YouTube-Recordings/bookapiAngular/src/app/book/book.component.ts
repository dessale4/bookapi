// import few classes from angular core library and create a component class

import {Component, OnInit, APP_ID} from '@angular/core';// OnInit is angular lifecycle method
import {Book} from './book'
import {BookService} from './book.service'
//selector specifies the xml tag that can be used to fetch all the views of this component
@Component({
    selector: 'book-api',
    templateUrl:'./book.component.html',
    styleUrls:['./book.component.css']
})
export class BookComponent implements OnInit{
    // BookInterface
    books:Book[];
    book = new Book();
    constructor(private _bookService: BookService){}
    ngOnInit(): void{
        this.getBooks();
    }
    getBooks():void{
        this._bookService.getAllBooks()
        .subscribe((bookData)=>{this.books=bookData, console.log(bookData)},
         (error)=>{
            console.log(error)
        })
    }
    //
    addBook(){
        this._bookService.addBook(this.book)
            .subscribe((response)=>{
                console.log(response)
                this.reset();// to clear the input fields
                this.getBooks(); // to see the newly added book in the books list
            }, (error)=>{
                console.log(error);
            })
    }
    //clear input field after submitting a form.
    private reset(){
        this.book.id = null;
        this.book.title=  null;
        this.book.author = null;
    }
    // delete a book from a database
    deleteBook(bookId:string){
        this._bookService.deleteBook(bookId)
        .subscribe((response)=>{
            console.log(response);
            this.getBooks();
        }, (error=>{
            console.log(error)
        }))
    }
    getBookById(bookId:string){
        this._bookService.getBookById(bookId)
        .subscribe((bookData)=>{
            this.book = bookData;}, (error)=>{
                console.log(error)
            }
        )
    }
}