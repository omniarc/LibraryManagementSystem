package com.example.CRUDOPs.controller;


import com.example.CRUDOPs.dto.request.BorrowRequestBody;
import com.example.CRUDOPs.dto.request.ReturnRequestBody;
import com.example.CRUDOPs.dto.response.BorrowResponseBody;
import com.example.CRUDOPs.dto.response.ReturnResponseBody;
import com.example.CRUDOPs.service.BorrowReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("borrow")
public class BorrowReturnController {
    @Autowired
    BorrowReturnService borrowReturnService;

    @PostMapping("lend")
    public BorrowResponseBody borrowBook(@RequestBody BorrowRequestBody borrowRequestBody){
        return borrowReturnService.borrowBook(borrowRequestBody);
    }

    @PutMapping("return")
    public ReturnResponseBody returnBook(@RequestBody ReturnRequestBody returnRequestBody){
        return borrowReturnService.returnBook(returnRequestBody);
    }
}
