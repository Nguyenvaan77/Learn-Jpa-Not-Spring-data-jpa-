package com.anhangda37.basis.payload.request;

import lombok.Data;

@Data
public class ContactCreateRequest {
    private String name;
    private String phoneNumber;
}
