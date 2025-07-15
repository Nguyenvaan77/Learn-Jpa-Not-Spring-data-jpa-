package com.anhangda37.basis.mapper;

import com.anhangda37.basis.entity.Contact;
import com.anhangda37.basis.payload.request.ContactCreateRequest;
import com.anhangda37.basis.payload.request.ContactUpdateRequest;
import com.anhangda37.basis.payload.response.ContactDetailResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    Contact toEntity(ContactCreateRequest createRequest);

    ContactDetailResponse toDetail(Contact contact);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(ContactUpdateRequest updateResponse, @MappingTarget Contact contact);
}
