package com.anhangda37.basis.service;

import com.anhangda37.basis.entity.Account;
import com.anhangda37.basis.entity.TransferLog;
import com.anhangda37.basis.payload.request.TransferRequest;
import com.anhangda37.basis.payload.response.TransferResponse;
import com.anhangda37.basis.payload.response.TransferStatus;

import java.math.BigDecimal;

public interface LoggingService {
    void saveLog(Account sender, Account receiver, BigDecimal amount, TransferStatus status);
    void saveTransfer(Account sender, Account receiver, BigDecimal amount);
}
