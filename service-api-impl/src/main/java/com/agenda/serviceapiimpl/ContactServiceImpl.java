package com.agenda.serviceapiimpl;

import com.agenda.model.dto.ContactDto;
import com.agenda.model.entity.Contact;
import com.agenda.model.repository.ContactRepository;
import com.agenda.serviceapi.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<ContactDto> getAllContactDTO() {
        List<ContactDto> listContactDto = new ArrayList<>();
        contactRepository.findAll().forEach(contact -> {
            listContactDto.add(contact.toContactDto());
        });
        return listContactDto;
    }
}
