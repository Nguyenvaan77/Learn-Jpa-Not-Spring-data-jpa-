package com.anhangda37.basis.mapper;

import com.anhangda37.basis.entity.Contact;
import com.anhangda37.basis.payload.request.ContactCreateRequest;
import com.anhangda37.basis.payload.request.ContactUpdateRequest;
import com.anhangda37.basis.payload.response.ContactDetailResponse;
import org.mapstruct.*;
import org.springframework.boot.context.properties.source.MapConfigurationPropertySource;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    Contact toEntity(ContactCreateRequest contactCreateRequest);

    ContactDetailResponse toDetail(Contact contact);

    @Mapping(target = "name")
    @Mapping(target = "phoneNumber")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(ContactUpdateRequest contactUpdateRequest,@MappingTarget Contact contact);
}
