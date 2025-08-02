package com.anhangda37.basis.payload.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

@Data
public class TransferResponse {
    private Long idSender;
    private Long idReceiver;
    private BigDecimal amount;
    @Enumerated(value = EnumType.STRING)
    private TransferStatus status;
}
