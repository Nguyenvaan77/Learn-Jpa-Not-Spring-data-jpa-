package com.anhangda37.basis.service;

import com.anhangda37.basis.entity.Account;
import com.anhangda37.basis.entity.AccountState;
import com.anhangda37.basis.payload.request.TransferRequest;
import com.anhangda37.basis.payload.response.TransferResponse;

import java.math.BigDecimal;

public interface BankService {
    TransferResponse transfer(TransferRequest transferRequest);
}
