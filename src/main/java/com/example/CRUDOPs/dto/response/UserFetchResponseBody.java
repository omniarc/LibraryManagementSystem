package com.example.CRUDOPs.dto.response;


import com.example.CRUDOPs.dto.AddressDetailsDTO;
import com.example.CRUDOPs.dto.LibraryMemberDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
//GET
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserFetchResponseBody {
    private LibraryMemberDTO user;
    private AddressDetailsDTO address;
    private String message;
}
