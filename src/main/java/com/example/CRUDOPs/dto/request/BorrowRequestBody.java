package com.example.CRUDOPs.dto.request;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BorrowRequestBody {
    private String bookId;
    private String libraryMemberId;
}
