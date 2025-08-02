package com.anhangda37.basis.mapper;

import com.anhangda37.basis.entity.Account;
import com.anhangda37.basis.payload.request.AccountCreateRequest;
import com.anhangda37.basis.payload.request.AccountUpdateRequest;
import com.anhangda37.basis.payload.response.AccountResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.context.annotation.AnnotationConfigUtils;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    @Mapping(source = "firstBalance", target = "balance", defaultValue = "0")
    Account toEntity(AccountCreateRequest request);

    AccountResponse toResponse(Account entity);
}
