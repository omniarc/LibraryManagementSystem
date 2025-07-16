package com.example.CRUDOPs.controller;


import com.example.CRUDOPs.dto.request.BorrowRequestBody;
import com.example.CRUDOPs.dto.response.BorrowResponseBody;
import com.example.CRUDOPs.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("borrow")
public class BorrowController {
    @Autowired
    BorrowService borrowService;

    @PostMapping("lend")
    public BorrowResponseBody borrowBook(@RequestBody BorrowRequestBody borrowRequestBody){
        return borrowService.borrowBook(borrowRequestBody);
    }
}
