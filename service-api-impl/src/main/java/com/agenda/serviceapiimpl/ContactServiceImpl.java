package com.agenda.serviceapiimpl;

import com.agenda.model.dto.ContactDto;
import com.agenda.model.entity.Account;
import com.agenda.model.entity.Contact;
import com.agenda.model.repository.AccountRepository;
import com.agenda.model.repository.ContactRepository;
import com.agenda.serviceapi.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List <ContactDto> getAllContactDTO() {
        List <ContactDto> listContactDto = new ArrayList <>();
        contactRepository.findAll().forEach( contact -> {
            listContactDto.add( contact.toContactDto() );
        } );
        return listContactDto;
    }

    @Override
    public ContactDto addNewContactDTO(ContactDto contactDto) {
        Contact contact = new Contact();
        contactDto.setAccountId( 6 );
        contact.updateContactDto( contactDto );
        Account account = accountRepository.findById( contactDto. getAccountId());

        contact.setAccount( account );
        account.getContacts().add( contact );
        return contactRepository.save( contact ).toContactDto();
    }

    @Override
    public ContactDto getContactDTO(Integer id) {
        if (contactRepository.findById( id ).isPresent()) {
            return contactRepository.findById( id ).get().toContactDto();
        }
        return null;
    }

    @Override
    public ContactDto editContactDTO(ContactDto contactDto, Integer id) {
        Optional <Contact> dbContact = contactRepository.findById( id );

        if (dbContact.isPresent()) {
            Contact contact = dbContact.get();

            contact.setFirstName( contactDto.getFirstNameDto() );
            contact.setLastName( contactDto.getLastNameDto() );
            contact.setNumberPhone( contactDto.getNumberPhoneDto() );
            return contactRepository.save( contact ).toContactDto();

        } else {
            return null;
        }
    }

    @Override
    public List <ContactDto> getAllContactsDTO(Integer id) {
        List <ContactDto> listOfContacts = new ArrayList <>();

        List <Contact> allByAccountAndId = contactRepository.findByAccount( accountRepository.findById( id ).get() );

        allByAccountAndId.forEach( contact -> {
            listOfContacts.add( contact.toContactDto() );
        } );
        return listOfContacts;
    }


}
