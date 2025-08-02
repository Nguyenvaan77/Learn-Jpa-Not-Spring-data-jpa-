package com.anhangda37.basis.controller;

import com.anhangda37.basis.payload.request.AccountCreateRequest;
import com.anhangda37.basis.payload.request.AccountUpdateRequest;
import com.anhangda37.basis.payload.response.AccountResponse;
import com.anhangda37.basis.service.AccountService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> findById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(accountService.find(id));
    }

    @PostMapping
    public ResponseEntity<AccountResponse> create(@Valid @RequestBody AccountCreateRequest request) {
        return ResponseEntity.status(200).body(accountService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountResponse> update(@PathVariable Long id, @Valid @RequestBody AccountUpdateRequest request) {
        return ResponseEntity.status(200).body(accountService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
