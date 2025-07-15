package com.anhangda37.basis.service;

import com.anhangda37.basis.payload.request.ContactCreateRequest;
import com.anhangda37.basis.payload.request.ContactUpdateRequest;
import com.anhangda37.basis.payload.response.ContactDetailResponse;
import org.springframework.stereotype.Service;

public interface ContactService {
    //create
    ContactDetailResponse create(ContactCreateRequest createRequest);
    //read
    ContactDetailResponse read(Long id);
    //update
    ContactDetailResponse update(Long id, ContactUpdateRequest updateResponse);
    //delete
    void delete(Long id);
}
