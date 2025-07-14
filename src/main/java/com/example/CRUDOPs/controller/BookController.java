package com.example.CRUDOPs.controller;


import com.example.CRUDOPs.dto.BookDTO;
import com.example.CRUDOPs.dto.request.BookAddRequestBody;
import com.example.CRUDOPs.dto.request.BookUpdateRequestBody;
import com.example.CRUDOPs.dto.response.*;
import com.example.CRUDOPs.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("allBooks")
    public BookListResponseBody getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("addBook")
    public BookAddResponseBody addBook(@RequestBody BookAddRequestBody bookAddRequestBody) {
        return bookService.addBook(bookAddRequestBody);
    }

    @DeleteMapping("deleteBook/{id}")
    public BookDeletionResponseBody deleteBook(@PathVariable String id){
        return bookService.deleteBook(id);
    }

    @PostMapping("update")
    public BookUpdateResponseBody updateBook(@RequestBody BookUpdateRequestBody bookUpdateRequestBody){
        return bookService.updateBook(bookUpdateRequestBody);
    }
}
