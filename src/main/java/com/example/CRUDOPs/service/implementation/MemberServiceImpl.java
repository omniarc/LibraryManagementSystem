package com.example.CRUDOPs.service.implementation;

import com.example.CRUDOPs.Entity.LibraryMember;
import com.example.CRUDOPs.dao.MemberDao;
import com.example.CRUDOPs.dto.LibraryMemberDTO;
import com.example.CRUDOPs.dto.request.UserAddRequestBody;
import com.example.CRUDOPs.dto.request.UserUpdateRequestBody;
import com.example.CRUDOPs.dto.response.*;
import com.example.CRUDOPs.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;

    @Override
    public UserListResponseBody getAllUsers() {
        List<LibraryMember> allMembers = memberDao.findAll();
        return mapToLibraryMemberDTO(allMembers);
    }

    private UserListResponseBody mapToLibraryMemberDTO(List<LibraryMember> members) {
        List<LibraryMemberDTO> memberDTOList = new ArrayList<>();

        for (LibraryMember member : members) {
            LibraryMemberDTO libraryMemberDTO = new LibraryMemberDTO();
            libraryMemberDTO.setId(member.getId());
            libraryMemberDTO.setName(member.getName());
            libraryMemberDTO.setContactNumber(member.getContactNumber());

            memberDTOList.add(libraryMemberDTO);

        }
        UserListResponseBody userList = new UserListResponseBody();
        userList.setUsers(memberDTOList);
        return userList;
    }

    @Override
    public UserAddResponseBody addMember(UserAddRequestBody userAddRequestBody){
        LibraryMember newMember = mapToLibraryMember(userAddRequestBody);
        memberDao.save(newMember);
        UserAddResponseBody userAddResponseBody = new UserAddResponseBody();
        userAddResponseBody.setMessage("User added successfully.");
        return userAddResponseBody;
    }


    private LibraryMember mapToLibraryMember(UserAddRequestBody userAddRequestBody){
        LibraryMember newMember = new LibraryMember();
        newMember.setName(userAddRequestBody.getUser().getName());
        newMember.setContactNumber(userAddRequestBody.getUser().getContactNumber());
        return newMember;
    }

    @Override
    public UserDeletionResponseBody deleteUser(String id) {
        memberDao.deleteById(id);
        UserDeletionResponseBody userDeletionResponseBody = new UserDeletionResponseBody();
        userDeletionResponseBody.setMessage("User deleted successfully.");
        return userDeletionResponseBody;
    }

    public UserUpdateResponseBody updateUser(UserUpdateRequestBody userUpdateRequestBody){
        String id = userUpdateRequestBody.getUserDetailsUpdate().getId();
        Optional<LibraryMember> existingLibraryMemberOptional = memberDao.findById(id);
        if(existingLibraryMemberOptional.isPresent()){
            LibraryMember existingLibraryMember = existingLibraryMemberOptional.get();
            existingLibraryMember.setName(userUpdateRequestBody.getUserDetailsUpdate().getName());
            existingLibraryMember.setContactNumber(userUpdateRequestBody.getUserDetailsUpdate().getContactNumber());
            memberDao.save(existingLibraryMember);

            UserUpdateResponseBody updateResponseBody = new UserUpdateResponseBody();
            updateResponseBody.setMessage("Details updated successfully");
            return updateResponseBody;
        }
        else {
            UserUpdateResponseBody failedUpdateResponse = new UserUpdateResponseBody();
            failedUpdateResponse.setMessage("The given ID does not exist.");
            return failedUpdateResponse;
        }
    }

    public UserFetchResponseBody fetchUser(String id){
        Optional<LibraryMember> existingLibraryMemberOptional = memberDao.findById(id);
        if(existingLibraryMemberOptional.isPresent()){
            LibraryMember libraryMember = existingLibraryMemberOptional.get();
            LibraryMemberDTO libraryMemberDTO = new LibraryMemberDTO();
            libraryMemberDTO.setId(libraryMember.getId());
            libraryMemberDTO.setName(libraryMember.getName());
            libraryMemberDTO.setContactNumber(libraryMember.getContactNumber());

            UserFetchResponseBody userFetchResponseBody = new UserFetchResponseBody();
            userFetchResponseBody.setUser(libraryMemberDTO);
            return userFetchResponseBody;
        } else {
            UserFetchResponseBody failedFetch = new UserFetchResponseBody();
            failedFetch.setMessage("Fetch failed since given ID does not exist.");
            return failedFetch;
        }
    }
}
