package com.anhangda37.basis.service;

import com.anhangda37.basis.entity.Account;
import com.anhangda37.basis.entity.AccountState;
import com.anhangda37.basis.exception.error.DuplicateEmailException;
import com.anhangda37.basis.exception.error.DuplicateUserException;
import com.anhangda37.basis.exception.error.ErrorMessage;
import com.anhangda37.basis.exception.error.NonExistEntityException;
import com.anhangda37.basis.mapper.AccountMapper;
import com.anhangda37.basis.payload.request.AccountCreateRequest;
import com.anhangda37.basis.payload.request.AccountUpdateRequest;
import com.anhangda37.basis.payload.response.AccountResponse;
import com.anhangda37.basis.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    @Transactional
    public AccountResponse create(AccountCreateRequest request) {
        if(accountRepository.existsByEmail(request.getEmail()))
            throw new DuplicateUserException(ErrorMessage.DUPLICATE_USER_ERROR_MESSAGE);

        Account account = accountMapper.toEntity(request);

        accountRepository.save(account);

        return accountMapper.toResponse(account);
    }

    @Override
    public void delete(Long id) {
        if(!accountRepository.existsById(id))
            throw new NonExistEntityException(ErrorMessage.NON_EXIST_ENTITY_ERROR_MESSAGE);

        accountRepository.deleteById(id);
    }

    @Override
    public AccountResponse update(Long id, AccountUpdateRequest request) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new NonExistEntityException(ErrorMessage.NON_EXIST_ENTITY_ERROR_MESSAGE));

        if(accountRepository.existsByEmail(request.getEmail()))
            throw new DuplicateEmailException(ErrorMessage.DUPLICATE_EMAIL_ERROR_MASSAGE);

        account.setEmail(request.getEmail());
        account.setUserName(request.getUserName());

        accountRepository.save(account);

        return accountMapper.toResponse(account);
    }

    @Override
    public AccountResponse find(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new NonExistEntityException(ErrorMessage.NON_EXIST_ENTITY_ERROR_MESSAGE));

        return accountMapper.toResponse(account);
    }
}
