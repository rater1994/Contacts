package com.agenda.restapi.Contact;

import com.agenda.model.dto.ContactDto;
import com.agenda.model.entity.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/contact")
public interface ContactsController {

    @GetMapping("/list")
    List<ContactDto> getContacts();

    @PostMapping("/add")
    ContactDto addContact(@RequestBody ContactDto contactDto);

    @GetMapping("/get/{id}")
    ContactDto getContact(@PathVariable Integer id);

    @PutMapping("/edit/{id}")
    ContactDto editContact(@RequestBody ContactDto contactDto, @PathVariable Integer id);


}
