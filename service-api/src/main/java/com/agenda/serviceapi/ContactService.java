package com.agenda.serviceapi;

import com.agenda.model.dto.ContactDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ContactService {

   List<ContactDto> getAllContactDTO();

}
