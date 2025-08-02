package com.anhangda37.basis.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

@Data
public class TransferRequest {
    private Long idSender;
    private Long idReceiver;
    private BigDecimal amount;
}
