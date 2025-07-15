package com.anhangda37.basis.service;

import com.anhangda37.basis.database.DatabaseManager;
import com.anhangda37.basis.entity.Contact;
import com.anhangda37.basis.mapper.ContactMapper;
import com.anhangda37.basis.payload.request.ContactCreateRequest;
import com.anhangda37.basis.payload.request.ContactUpdateRequest;
import com.anhangda37.basis.payload.response.ContactDetailResponse;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService{
    private final ContactMapper contactMapper;
    private final EntityManager em = DatabaseManager.getEm();

    @Override
    public ContactDetailResponse create(ContactCreateRequest createRequest) {
        Contact contact = new Contact();
        try {
            em.getTransaction().begin();

            contact.setName("Nguyen Van An");
            contact.setPhoneNumber("0972254523");
            em.persist(contact);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("create not successfully");
            em.getTransaction().rollback();
        } finally {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
        return contactMapper.toDetail(contact);
    }

    @Override
    public ContactDetailResponse read(Long id) {
        Contact contact = null;
        try {
            em.getTransaction().begin();
            contact = em.find(Contact.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Khong tim thay contact");
            em.getTransaction().rollback();
        } finally {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
        return contactMapper.toDetail(contact);
    }

    @Override
    public ContactDetailResponse update(Long id, ContactUpdateRequest updateResponse) {
        Contact contact = null;

        try {
            em.getTransaction().begin();
            contact = em.find(Contact.class, id);
            if(contact == null) {
                em.getTransaction().rollback();
                return null;
            }
            contactMapper.update(updateResponse, contact);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println();
            em.getTransaction().rollback();
        }
        return contactMapper.toDetail(contact);
    }

    @Override
    public void delete(Long id) {
        Contact contact = null;
        try {
            em.getTransaction().begin();
            contact = em.find(Contact.class, id);
            em.remove(contact);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Khong tim thay contact");
            em.getTransaction().rollback();
        }
    }
}
