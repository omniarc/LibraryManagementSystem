package com.example.CRUDOPs.dto.request;

import com.example.CRUDOPs.dto.BookDTO;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookAddRequestBody {
    private BookDTO book;
}
