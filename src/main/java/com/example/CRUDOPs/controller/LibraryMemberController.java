package com.example.CRUDOPs.controller;


import com.example.CRUDOPs.dto.request.UserAddRequestBody;
import com.example.CRUDOPs.dto.request.UserUpdateRequestBody;
import com.example.CRUDOPs.dto.response.*;
import com.example.CRUDOPs.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("libraryMember")
public class LibraryMemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("allMembers")
    public UserListResponseBody getAllUsers(){
        return memberService.getAllUsers();
    }

    @PostMapping("addMember")
    public UserAddResponseBody addUser(@RequestBody UserAddRequestBody userAddRequestBody){
        return memberService.addMember(userAddRequestBody);
    }

    @DeleteMapping("deleteUser/{id}")
    public UserDeletionResponseBody deleteUser(@PathVariable String id){
        return memberService.deleteUser(id);
    }

    @PostMapping("update")
    public UserUpdateResponseBody updateUser(@RequestBody UserUpdateRequestBody userUpdateRequestBody){
        return memberService.updateUser(userUpdateRequestBody);
    }

    @GetMapping("fetch/{id}")
    public UserFetchResponseBody fetchUser(@PathVariable String id){
        return memberService.fetchUser(id);
    }
}
