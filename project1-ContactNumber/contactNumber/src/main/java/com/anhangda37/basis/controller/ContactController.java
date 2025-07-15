package com.anhangda37.basis.controller;

import com.anhangda37.basis.payload.request.ContactCreateRequest;
import com.anhangda37.basis.payload.request.ContactUpdateRequest;
import com.anhangda37.basis.payload.response.ContactDetailResponse;
import com.anhangda37.basis.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "/api/contact")
public class ContactController {
    private final ContactService contactService;

    @GetMapping(name = "/{id}")
    public ResponseEntity<ContactDetailResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(contactService.read(id));
    }

    @PostMapping()
    public ResponseEntity<ContactDetailResponse> createByRequestBody(@RequestBody ContactCreateRequest contactCreateRequest) {
        return ResponseEntity.ok(contactService.create(contactCreateRequest));
    }

    @PutMapping()
    public ResponseEntity<ContactDetailResponse> updateByRequestBody(@RequestParam(name = "id") Long id,
                                                                     @RequestBody ContactUpdateRequest contactUpdateRequest) {
        return ResponseEntity.ok(contactService.update(id, contactUpdateRequest));
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteById(@RequestParam(name = "id") Long id) {
        contactService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
