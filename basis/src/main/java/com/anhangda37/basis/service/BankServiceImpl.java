package com.anhangda37.basis.service;

import com.anhangda37.basis.entity.Account;
import com.anhangda37.basis.exception.error.BankException;
import com.anhangda37.basis.exception.error.ErrorMessage;
import com.anhangda37.basis.exception.error.NonExistEntityException;
import com.anhangda37.basis.mapper.AccountMapper;
import com.anhangda37.basis.payload.request.TransferRequest;
import com.anhangda37.basis.payload.response.TransferResponse;
import com.anhangda37.basis.payload.response.TransferStatus;
import com.anhangda37.basis.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.logging.Logger;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService{
    private static final Logger logging = (Logger) LoggerFactory.getLogger(BankServiceImpl.class);

    private final AccountRepository accountRepository;
    private final LoggingService loggingService;
    private final AccountMapper accountMapper;
    @Override
    @Transactional(rollbackFor = {NonExistEntityException.class, BankException.class})
    public TransferResponse transfer(TransferRequest request) {
        Account sender = accountRepository.findById(request.getIdSender())
                .orElseThrow(() -> new NonExistEntityException(ErrorMessage.NON_EXIST_ENTITY_ERROR_MESSAGE));

        Account receiver = accountRepository.findById(request.getIdReceiver())
                .orElseThrow(() -> new NonExistEntityException(ErrorMessage.NON_EXIST_ENTITY_ERROR_MESSAGE));

        if (sender.getBalance().subtract(request.getAmount()).compareTo(BigDecimal.ZERO) < 0) {
            loggingService.saveLog(sender, receiver, request.getAmount(), TransferStatus.FAIL);
            throw new BankException(ErrorMessage.DEFAULT_BANK_ERROR_MESSAGE);
        }

        sender.setBalance(sender.getBalance().subtract(request.getAmount()));
        receiver.setBalance(receiver.getBalance().add(request.getAmount()));

        loggingService.saveTransfer(sender, receiver, request.getAmount());
        loggingService.saveLog(sender, receiver, request.getAmount(), TransferStatus.SUCCESS);
        accountRepository.save(sender);
        accountRepository.save(receiver);

        TransferResponse response = new TransferResponse();
        response.setIdSender(request.getIdSender());
        response.setIdReceiver(request.getIdReceiver());
        response.setAmount(request.getAmount());
        response.setStatus(TransferStatus.SUCCESS);

        return response;
    }
}