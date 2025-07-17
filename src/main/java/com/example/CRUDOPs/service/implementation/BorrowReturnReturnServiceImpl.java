package com.example.CRUDOPs.service.implementation;
import com.example.CRUDOPs.Entity.Book;
import com.example.CRUDOPs.Entity.BorrowHistory;
import com.example.CRUDOPs.Entity.LibraryMember;
import com.example.CRUDOPs.dao.BorrowHistoryDao;
import com.example.CRUDOPs.dto.request.BorrowRequestBody;
import com.example.CRUDOPs.dto.request.ReturnRequestBody;
import com.example.CRUDOPs.dto.response.BorrowResponseBody;
import com.example.CRUDOPs.dto.response.ReturnResponseBody;
import com.example.CRUDOPs.service.BorrowReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class BorrowReturnReturnServiceImpl implements BorrowReturnService {
    @Autowired
    private BorrowHistoryDao borrowHistoryDao;

    private BorrowHistory borrowHistory;
    private LibraryMember libraryMember;

    @Override
    public BorrowResponseBody borrowBook(BorrowRequestBody borrowRequestBody) {
        //Checking if said book is available for lending or not.
        Book book = new Book();
        if(book.isBorrowed() == true){
            BorrowResponseBody borrowResponseBody = new BorrowResponseBody();
            borrowResponseBody.setMessage("Book is already issued to another user, and hence cannot be issued.");
            return borrowResponseBody;
        }
        else{
            //Checking if user has the capacity to borrow more books.
            int test = borrowHistoryDao.findByLibraryMemberIdAndIsActiveAndIsDeleted(borrowHistory.getLibraryMember().getId(), borrowHistory.isActive(), borrowHistory.isDeleted()).size();
            if(test <= 4 && test >= 0){
//                BorrowResponseBody borrowResponseBody = new BorrowResponseBody();
//                borrowResponseBody.setMessage("User can issue the book.");
//                return borrowResponseBody;
                BorrowHistory newBorrow = mapToBorrow(borrowRequestBody);
                borrowHistoryDao.save(newBorrow);
                BorrowResponseBody borrowResponseBody = new BorrowResponseBody();
                borrowResponseBody.setMessage("Book has been lent to " + libraryMember.getName() + ". Return within two weeks!");
                return borrowResponseBody;

            } else {
                BorrowResponseBody borrowResponseBody = new BorrowResponseBody();
                borrowResponseBody.setMessage("User has reached limit for issuing books.");
                return borrowResponseBody;
            }

        }
    }

    private BorrowHistory mapToBorrow(BorrowRequestBody borrowRequestBody){
        BorrowHistory newBorrow = new BorrowHistory();
        LocalDateTime Stamp = LocalDateTime.now();
        DateTimeFormatter Formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        String formattedStamp = Stamp.format(Formatter);

        newBorrow.setBorrowedDate(formattedStamp);
        newBorrow.setDueDate(formattedStamp);               //Needs configuring to add 2 weeks.
        newBorrow.setLibraryMember(borrowHistory.getLibraryMember());
        newBorrow.setBook(borrowHistory.getBook());
        return newBorrow;
    }



    @Override
    public ReturnResponseBody returnBook(ReturnRequestBody returnRequestBody) {
        return null;
    }
}
