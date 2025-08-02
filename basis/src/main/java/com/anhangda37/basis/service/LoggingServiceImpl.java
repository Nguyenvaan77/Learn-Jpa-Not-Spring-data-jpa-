package com.anhangda37.basis.service;

import com.anhangda37.basis.entity.Account;
import com.anhangda37.basis.entity.AllLog;
import com.anhangda37.basis.entity.TransferLog;
import com.anhangda37.basis.payload.response.TransferStatus;
import com.anhangda37.basis.repository.AllLogRepository;
import com.anhangda37.basis.repository.TransferLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class LoggingServiceImpl implements LoggingService{

    private final AllLogRepository allLogRepository;

    private final TransferLogRepository transferLogRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveLog(Account sender, Account receiver, BigDecimal amount, TransferStatus status) {
        AllLog allLog = new AllLog();
        allLog.setSender(sender);
        allLog.setReceiver(receiver);
        allLog.setAmount(amount);
        allLog.setStatus(status);

        allLogRepository.save(allLog);
    }

    @Override
    @Transactional()
    public void saveTransfer(Account sender, Account receiver, BigDecimal amount) {
        TransferLog transferLog = new TransferLog();
        transferLog.setSender(sender);
        transferLog.setReceiver(receiver);
        transferLog.setAmount(amount);

        transferLogRepository.save(transferLog);
    }
}
