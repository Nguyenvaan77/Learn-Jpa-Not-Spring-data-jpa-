package com.anhangda37.basis.payload.request;

import lombok.Data;

@Data
public class ContactUpdateRequest {
    private String name;
    private String phoneNumber;
}
