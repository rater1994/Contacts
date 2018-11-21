package com.agenda.restapi.Contact;

import com.agenda.model.dto.ContactDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contact")
public interface ContactsController {

        @GetMapping("/list")
        List<ContactDto> getContacts();

}
