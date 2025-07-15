package com.example.CRUDOPs.controller;


import com.example.CRUDOPs.dto.request.LibraryMemberAddRequestBody;
import com.example.CRUDOPs.dto.request.LibraryMemberUpdateRequestBody;
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
    public LibraryMemberAddResponseBody addUser(@RequestBody LibraryMemberAddRequestBody libraryMemberAddRequestBody){
        return libraryMemberService.addMember(libraryMemberAddRequestBody);
    }

    @DeleteMapping("deleteUser/{id}")
    public LibraryMemberDeletionResponseBody deleteUser(@PathVariable String id){
        return libraryMemberService.deleteUser(id);
    }

    @PostMapping("update")
    public LibraryMemberUpdateResponseBody updateUser(@RequestBody LibraryMemberUpdateRequestBody libraryMemberUpdateRequestBody){
        return libraryMemberService.updateUser(libraryMemberUpdateRequestBody);
    }

    @GetMapping("fetch/{id}")
    public LibraryMemberFetchResponseBody fetchUser(@PathVariable String id){
        return libraryMemberService.fetchUser(id);
    }
}
