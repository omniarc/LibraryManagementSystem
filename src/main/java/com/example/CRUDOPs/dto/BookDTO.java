package com.example.CRUDOPs.dto;
import lombok.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDTO {
    private String id;
    private String title;
    private String author;
    private String genre;
    private String publishedYear;
    private boolean isBorrowed;
}
// fetch first