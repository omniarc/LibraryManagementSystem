package com.example.CRUDOPs.service.implementation;


import com.example.CRUDOPs.Entity.Book;
import com.example.CRUDOPs.Entity.BorrowReturnHistory;
import com.example.CRUDOPs.Entity.LibraryMember;
import com.example.CRUDOPs.dao.BookDao;
import com.example.CRUDOPs.dao.BorrowReturnHistoryDao;
import com.example.CRUDOPs.dao.LibraryMemberDao;
import com.example.CRUDOPs.dto.request.BorrowRequestBody;
import com.example.CRUDOPs.dto.request.ReturnRequestBody;
import com.example.CRUDOPs.dto.response.BorrowResponseBody;
import com.example.CRUDOPs.dto.response.ReturnResponseBody;
import com.example.CRUDOPs.service.BorrowReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class BorrowReturnReturnServiceImpl implements BorrowReturnService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BorrowReturnHistoryDao borrowReturnHistoryDao;
    @Autowired
    private LibraryMemberDao libraryMemberDao;


    @Override
    public BorrowResponseBody borrowBook(BorrowRequestBody borrowRequestBody) {
        //Checking if said book is available for lending or not.
        Optional<Book> bookOptional = bookDao.findById(borrowRequestBody.getBookId());
        if(bookOptional.isPresent()) {
            Book book = bookOptional.get();
            if (book.getIsBorrowed() == true) {
                BorrowResponseBody borrowResponseBody = new BorrowResponseBody();
                borrowResponseBody.setMessage("Book is already issued to another user, and hence cannot be issued.");
                return borrowResponseBody;
            }
            else {
                //Checking if user has the capacity to borrow more books.
                int activeBorrowCount = borrowReturnHistoryDao.findByLibraryMemberIdAndIsActiveAndIsDeleted(borrowRequestBody.getLibraryMemberId(), true,false).size();
                if (activeBorrowCount <= 4) {
                    BorrowReturnHistory newBorrow = new BorrowReturnHistory();
                    //Fetching timestamp of book lending.
                    LocalDateTime Stamp = LocalDateTime.now();
                    LocalDateTime dueStamp = Stamp.plusDays(14);
                    DateTimeFormatter Formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
                    String formattedStamp = Stamp.format(Formatter);
                    String formattedDueStamp = dueStamp.format(Formatter);

                    //Background changes to issue book
                    newBorrow.setBorrowedDate(formattedStamp);
                    newBorrow.setDueDate(formattedDueStamp);
                    Optional<LibraryMember> libraryMember = libraryMemberDao.findById(borrowRequestBody.getLibraryMemberId());
                    LibraryMember libMember = libraryMember.get();
                    newBorrow.setLibraryMember(libMember);
                    newBorrow.setBook(book);
                    //Changing base entity values to mark transaction status as active.
                    newBorrow.setIsActive(true);
                    newBorrow.setIsDeleted(false);
                    book.setIsBorrowed(true);
                    borrowReturnHistoryDao.save(newBorrow);
                    BorrowResponseBody borrowResponseBody = new BorrowResponseBody();
                    borrowResponseBody.setMessage("Book has been lent successfully. Return within two weeks!");
                    return borrowResponseBody;
                } else {
                    BorrowResponseBody borrowResponseBody = new BorrowResponseBody();
                    borrowResponseBody.setMessage("User has reached limit for issuing books.");
                    return borrowResponseBody;
                }
            }
        } else {
            BorrowResponseBody borrowResponseBody = new BorrowResponseBody();
            borrowResponseBody.setMessage("The given Book ID does not exist.");
            return borrowResponseBody;
        }
    }




    @Override
    public ReturnResponseBody returnBook(ReturnRequestBody returnRequestBody) {

        Optional<BorrowReturnHistory> borrowReturnHistory = borrowReturnHistoryDao.findByLibraryMemberIdAndBookIdAndIsActiveAndIsDeleted(returnRequestBody.getLibraryMemberId(), returnRequestBody.getBookId(), true, false);
        if(borrowReturnHistory.isPresent()) {
            BorrowReturnHistory borrowReturnHistory1 = borrowReturnHistory.get();

            //Fetching timestamp of book being returned.
            LocalDateTime Stamp = LocalDateTime.now();
            DateTimeFormatter Formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
            String formattedStamp = Stamp.format(Formatter);

            //Background changes to return book.
            borrowReturnHistory1.setReturnDate(formattedStamp);
            borrowReturnHistory1.setIsActive(false);
            borrowReturnHistory1.setIsDeleted(true);
            Optional<Book> existingBookIdOptional = bookDao.findById(returnRequestBody.getBookId());
            Book book = existingBookIdOptional.get();
            book.setIsBorrowed(false);
            borrowReturnHistoryDao.save(borrowReturnHistory1);

            //Returning response
            ReturnResponseBody returnResponseBody = new ReturnResponseBody();
            returnResponseBody.setMessage("Book has been returned successfully.");
            return returnResponseBody;
        }
        else{
            ReturnResponseBody returnResponseBody = new ReturnResponseBody();
            returnResponseBody.setMessage("Either the book Id, or the library member Id is invalid.");
            return returnResponseBody;
        }
    }
}
