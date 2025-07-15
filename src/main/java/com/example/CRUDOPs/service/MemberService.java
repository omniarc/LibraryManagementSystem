package com.example.CRUDOPs.service;

import com.example.CRUDOPs.dto.request.UserAddRequestBody;
import com.example.CRUDOPs.dto.request.UserUpdateRequestBody;
import com.example.CRUDOPs.dto.response.*;

public interface MemberService {
    public UserListResponseBody getAllUsers();
    public UserAddResponseBody addMember(UserAddRequestBody userAddRequestBody);
    public UserDeletionResponseBody deleteUser(String id);
    public UserUpdateResponseBody updateUser(UserUpdateRequestBody userUpdateRequestBody);
    public UserFetchResponseBody fetchUser(String id);
}
