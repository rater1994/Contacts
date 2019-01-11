package com.agenda.model.repository;

import com.agenda.model.entity.Account;
import com.agenda.model.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository <Contact, Integer> {

    List <Contact> findByAccount(Account account);
}
