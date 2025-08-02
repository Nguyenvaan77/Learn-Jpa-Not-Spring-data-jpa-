package com.anhangda37.basis.payload.request;

import com.mysql.cj.jdbc.NonRegisteringDriver;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

@Data
public class AccountCreateRequest {
    @NotBlank
    private String userName;

    @NotBlank
    private String email;

    @NumberFormat
    private BigDecimal firstBalance;
}
