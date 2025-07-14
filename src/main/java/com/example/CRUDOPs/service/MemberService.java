package com.example.CRUDOPs.service;

import com.example.CRUDOPs.dto.request.UserAddRequestBody;
import com.example.CRUDOPs.dto.response.UserAddResponseBody;
import com.example.CRUDOPs.dto.response.UserDeletionResponseBody;
import com.example.CRUDOPs.dto.response.UserListResponseBody;

public interface MemberService {
    public UserListResponseBody getAllUsers();
    public UserAddResponseBody addMember(UserAddRequestBody userAddRequestBody);
    public UserDeletionResponseBody deleteUser(String id);
}
