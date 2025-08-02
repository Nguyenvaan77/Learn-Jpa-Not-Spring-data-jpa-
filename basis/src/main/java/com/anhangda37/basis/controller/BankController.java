package com.anhangda37.basis.controller;

import com.anhangda37.basis.payload.request.TransferRequest;
import com.anhangda37.basis.payload.response.TransferResponse;
import com.anhangda37.basis.service.BankService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank")
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;

    @GetMapping
    public ResponseEntity<TransferResponse> transfer(@Valid @RequestBody TransferRequest request) {
        TransferResponse response = bankService.transfer(request);
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping
    public void addAccount() {
        bankService.addAccount();
    }
}
