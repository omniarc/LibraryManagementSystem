package com.example.CRUDOPs.dto.request;


import com.example.CRUDOPs.dto.LibraryMemberDTO;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserUpdateRequestBody {
    private LibraryMemberDTO userDetailsUpdate;
}
