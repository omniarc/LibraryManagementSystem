package com.example.CRUDOPs.service;

import com.example.CRUDOPs.dto.request.UserAddRequestBody;
import com.example.CRUDOPs.dto.request.UserUpdateRequestBody;
import com.example.CRUDOPs.dto.response.*;

public interface LibraryMemberService {
    public LibraryMemberListResponseBody getAllUsers();
    public LibraryMemberAddResponseBody addMember(UserAddRequestBody userAddRequestBody);
    public LibraryMemberDeletionResponseBody deleteUser(String id);
    public LibraryMemberUpdateResponseBody updateUser(UserUpdateRequestBody userUpdateRequestBody);
    public LibraryMemberFetchResponseBody fetchUser(String id);
}
