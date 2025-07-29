package com.anhangda37.basis.service;

import com.anhangda37.basis.entity.Contact;
import com.anhangda37.basis.mapper.ContactMapper;
import com.anhangda37.basis.payload.request.ContactCreateRequest;
import com.anhangda37.basis.payload.request.ContactUpdateRequest;
import com.anhangda37.basis.payload.response.ContactDetailResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService{
    private final ContactMapper contactMapper;
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.anhangda37.basis-postgres-hibernate-PU");
    private final static EntityManager em = emf.createEntityManager();

    @Override
    public ContactDetailResponse create(ContactCreateRequest contactCreateRequest) {
        Contact contact = null;

        try {
            em.getTransaction().begin();
            contact = new Contact();
            contact.setName(contactCreateRequest.getName());
            contact.setPhoneNumber(contact.getPhoneNumber());
            em.persist(contact);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Trung con tac");
            em.getTransaction().rollback();
        }
        return contactMapper.toDetail(contact);
    }

    @Override
    public ContactDetailResponse read(Long id) {
        return null;
    }

    @Override
    public ContactDetailResponse update(Long id, ContactUpdateRequest contactUpdateRequest) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
