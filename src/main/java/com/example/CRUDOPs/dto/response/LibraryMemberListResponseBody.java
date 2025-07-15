package com.example.CRUDOPs.dto.response;


import com.example.CRUDOPs.dto.LibraryMemberDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;
//GET
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LibraryMemberListResponseBody {
    private List<LibraryMemberDTO> users;
}

