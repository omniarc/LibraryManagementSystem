package com.example.CRUDOPs.service;

import com.example.CRUDOPs.dto.request.BookAddRequestBody;
import com.example.CRUDOPs.dto.request.BookUpdateRequestBody;
import com.example.CRUDOPs.dto.response.*;

public interface BookService {
    public BookListResponseBody getAllBooks();
    public BookAddResponseBody addBook(BookAddRequestBody bookAddRequestBody);
    public BookDeletionResponseBody deleteBook(String id);
    public BookUpdateResponseBody updateBook(BookUpdateRequestBody bookUpdateRequestBody);
}