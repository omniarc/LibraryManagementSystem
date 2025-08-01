package com.example.CRUDOPs.dto.request;


import com.example.CRUDOPs.dto.BaseEntityDTO;
import com.example.CRUDOPs.dto.BookDTO;
import com.example.CRUDOPs.dto.BorrowHistoryDTO;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReturnRequestBody {
    private String bookId;
    private String libraryMemberId;
}
