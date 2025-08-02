package com.anhangda37.basis.payload.response;

import com.anhangda37.basis.entity.AccountState;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AccountResponse {
    private String userName;
    private String email;
    private BigDecimal balance;
    private LocalDateTime createdAt;
    private AccountState state;
}
