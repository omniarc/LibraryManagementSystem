package com.example.CRUDOPs.service.implementation;

import com.example.CRUDOPs.Entity.LibraryMember;
import com.example.CRUDOPs.dao.LibraryMemberDao;
import com.example.CRUDOPs.dto.LibraryMemberDTO;
import com.example.CRUDOPs.dto.request.UserAddRequestBody;
import com.example.CRUDOPs.dto.request.UserUpdateRequestBody;
import com.example.CRUDOPs.dto.response.*;
import com.example.CRUDOPs.service.LibraryMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryMemberServiceImpl implements LibraryMemberService {
    @Autowired
    private LibraryMemberDao libraryMemberDao;

    @Override
    public LibraryMemberListResponseBody getAllUsers() {
        List<LibraryMember> allMembers = libraryMemberDao.findAll();
        return mapToLibraryMemberDTO(allMembers);
    }

    private LibraryMemberListResponseBody mapToLibraryMemberDTO(List<LibraryMember> members) {
        List<LibraryMemberDTO> memberDTOList = new ArrayList<>();

        for (LibraryMember member : members) {
            LibraryMemberDTO libraryMemberDTO = new LibraryMemberDTO();
            libraryMemberDTO.setId(member.getId());
            libraryMemberDTO.setName(member.getName());
            libraryMemberDTO.setContactNumber(member.getContactNumber());

            memberDTOList.add(libraryMemberDTO);

        }
        LibraryMemberListResponseBody userList = new LibraryMemberListResponseBody();
        userList.setUsers(memberDTOList);
        return userList;
    }

    @Override
    public LibraryMemberAddResponseBody addMember(UserAddRequestBody userAddRequestBody){
        LibraryMember newMember = mapToLibraryMember(userAddRequestBody);
        libraryMemberDao.save(newMember);
        LibraryMemberAddResponseBody libraryMemberAddResponseBody = new LibraryMemberAddResponseBody();
        libraryMemberAddResponseBody.setMessage("User added successfully.");
        return libraryMemberAddResponseBody;
    }


    private LibraryMember mapToLibraryMember(UserAddRequestBody userAddRequestBody){
        LibraryMember newMember = new LibraryMember();
        newMember.setName(userAddRequestBody.getUser().getName());
        newMember.setContactNumber(userAddRequestBody.getUser().getContactNumber());
        return newMember;
    }

    @Override
    public LibraryMemberDeletionResponseBody deleteUser(String id) {
        libraryMemberDao.deleteById(id);
        LibraryMemberDeletionResponseBody libraryMemberDeletionResponseBody = new LibraryMemberDeletionResponseBody();
        libraryMemberDeletionResponseBody.setMessage("User deleted successfully.");
        return libraryMemberDeletionResponseBody;
    }

    public LibraryMemberUpdateResponseBody updateUser(UserUpdateRequestBody userUpdateRequestBody){
        String id = userUpdateRequestBody.getUserDetailsUpdate().getId();
        Optional<LibraryMember> existingLibraryMemberOptional = libraryMemberDao.findById(id);
        if(existingLibraryMemberOptional.isPresent()){
            LibraryMember existingLibraryMember = existingLibraryMemberOptional.get();
            existingLibraryMember.setName(userUpdateRequestBody.getUserDetailsUpdate().getName());
            existingLibraryMember.setContactNumber(userUpdateRequestBody.getUserDetailsUpdate().getContactNumber());
            libraryMemberDao.save(existingLibraryMember);

            LibraryMemberUpdateResponseBody updateResponseBody = new LibraryMemberUpdateResponseBody();
            updateResponseBody.setMessage("Details updated successfully");
            return updateResponseBody;
        }
        else {
            LibraryMemberUpdateResponseBody failedUpdateResponse = new LibraryMemberUpdateResponseBody();
            failedUpdateResponse.setMessage("The given ID does not exist.");
            return failedUpdateResponse;
        }
    }

    public LibraryMemberFetchResponseBody fetchUser(String id){
        Optional<LibraryMember> existingLibraryMemberOptional = libraryMemberDao.findById(id);
        if(existingLibraryMemberOptional.isPresent()){
            LibraryMember libraryMember = existingLibraryMemberOptional.get();
            LibraryMemberDTO libraryMemberDTO = new LibraryMemberDTO();
            libraryMemberDTO.setId(libraryMember.getId());
            libraryMemberDTO.setName(libraryMember.getName());
            libraryMemberDTO.setContactNumber(libraryMember.getContactNumber());

            LibraryMemberFetchResponseBody libraryMemberFetchResponseBody = new LibraryMemberFetchResponseBody();
            libraryMemberFetchResponseBody.setUser(libraryMemberDTO);
            return libraryMemberFetchResponseBody;
        } else {
            LibraryMemberFetchResponseBody failedFetch = new LibraryMemberFetchResponseBody();
            failedFetch.setMessage("Fetch failed since given ID does not exist.");
            return failedFetch;
        }
    }
}
