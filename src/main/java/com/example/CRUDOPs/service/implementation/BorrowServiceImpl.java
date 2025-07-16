package com.example.CRUDOPs.service.implementation;
import com.example.CRUDOPs.Entity.Book;
import com.example.CRUDOPs.Entity.BorrowHistory;
import com.example.CRUDOPs.dao.BorrowHistoryDao;
import com.example.CRUDOPs.dto.request.BorrowRequestBody;
import com.example.CRUDOPs.dto.response.BorrowResponseBody;
import com.example.CRUDOPs.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowHistoryDao borrowHistoryDao;

    private BorrowHistory borrowHistory;



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
         //   borrowHistoryDao.findByUserIdAndIsDeletedAndIsActive(String )
            int test = borrowHistoryDao.findByLibraryMemberIdAndIsActiveAndIsDeleted(borrowHistory.getLibraryMember().getId(), borrowHistory.isActive(), borrowHistory.isDeleted()).size();
            if(test <= 4){
                BorrowResponseBody borrowResponseBody = new BorrowResponseBody();
                borrowResponseBody.setMessage("User can issue the book.");
                return borrowResponseBody;
            } else {
                BorrowResponseBody borrowResponseBody = new BorrowResponseBody();
                borrowResponseBody.setMessage("User has reached limit for issuing books.");
                return borrowResponseBody;
            }
        }
    }

}
