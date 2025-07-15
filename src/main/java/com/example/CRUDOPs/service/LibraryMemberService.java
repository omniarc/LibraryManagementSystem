package com.example.CRUDOPs.service;

import com.example.CRUDOPs.dto.request.LibraryMemberAddRequestBody;
import com.example.CRUDOPs.dto.request.LibraryMemberUpdateRequestBody;
import com.example.CRUDOPs.dto.response.*;

public interface LibraryMemberService {
    public LibraryMemberListResponseBody getAllUsers();
    public LibraryMemberAddResponseBody addMember(LibraryMemberAddRequestBody libraryMemberAddRequestBody);
    public LibraryMemberDeletionResponseBody deleteUser(String id);
    public LibraryMemberUpdateResponseBody updateUser(LibraryMemberUpdateRequestBody libraryMemberUpdateRequestBody);
    public LibraryMemberFetchResponseBody fetchUser(String id);
}
