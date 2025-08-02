package com.anhangda37.basis.service;

import com.anhangda37.basis.payload.request.AccountCreateRequest;
import com.anhangda37.basis.payload.request.AccountUpdateRequest;
import com.anhangda37.basis.payload.response.AccountResponse;
import com.anhangda37.basis.repository.AccountRepository;

import java.util.function.LongFunction;

public interface AccountService {
    AccountResponse create(AccountCreateRequest request);
    void delete(Long id);
    AccountResponse update(Long id, AccountUpdateRequest request);
    AccountResponse find(Long id);
}
