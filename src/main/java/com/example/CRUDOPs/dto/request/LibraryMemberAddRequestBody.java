package com.example.CRUDOPs.dto.request;

import com.example.CRUDOPs.dto.LibraryMemberDTO;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LibraryMemberAddRequestBody {
    private LibraryMemberDTO user;
}
