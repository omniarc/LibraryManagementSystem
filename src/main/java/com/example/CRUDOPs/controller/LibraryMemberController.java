package com.example.CRUDOPs.controller;


import com.example.CRUDOPs.dto.request.UserAddRequestBody;
import com.example.CRUDOPs.dto.request.UserUpdateRequestBody;
import com.example.CRUDOPs.dto.response.*;
import com.example.CRUDOPs.service.LibraryMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("libraryMember")
public class LibraryMemberController {
    @Autowired
    LibraryMemberService libraryMemberService;

    @GetMapping("allMembers")
    public LibraryMemberListResponseBody getAllUsers(){
        return libraryMemberService.getAllUsers();
    }

    @PostMapping("addMember")
    public LibraryMemberAddResponseBody addUser(@RequestBody UserAddRequestBody userAddRequestBody){
        return libraryMemberService.addMember(userAddRequestBody);
    }

    @DeleteMapping("deleteUser/{id}")
    public LibraryMemberDeletionResponseBody deleteUser(@PathVariable String id){
        return libraryMemberService.deleteUser(id);
    }

    @PostMapping("update")
    public LibraryMemberUpdateResponseBody updateUser(@RequestBody UserUpdateRequestBody userUpdateRequestBody){
        return libraryMemberService.updateUser(userUpdateRequestBody);
    }

    @GetMapping("fetch/{id}")
    public LibraryMemberFetchResponseBody fetchUser(@PathVariable String id){
        return libraryMemberService.fetchUser(id);
    }
}
