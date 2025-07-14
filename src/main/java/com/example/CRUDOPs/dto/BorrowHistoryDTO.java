package com.example.CRUDOPs.dto;


import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BorrowHistoryDTO {
    private String id;
    private Integer borrowedDate;
    private Integer dueDate;
    private Integer returnDate;
}
