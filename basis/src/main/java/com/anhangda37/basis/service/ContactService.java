package com.anhangda37.basis.service;

import com.anhangda37.basis.entity.Contact;
import com.anhangda37.basis.payload.request.ContactCreateRequest;
import com.anhangda37.basis.payload.request.ContactUpdateRequest;
import com.anhangda37.basis.payload.response.ContactDetailResponse;

public interface ContactService {
    ContactDetailResponse create(ContactCreateRequest contactCreateRequest);

    ContactDetailResponse read(Long id);

    ContactDetailResponse update(Long id, ContactUpdateRequest contactUpdateRequest);

    void delete(Long id);
}
