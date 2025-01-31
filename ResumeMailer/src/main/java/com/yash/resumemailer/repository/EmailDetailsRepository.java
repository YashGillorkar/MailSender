package com.yash.resumemailer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.resumemailer.model.EmailDetails;

@Repository
public interface EmailDetailsRepository extends JpaRepository<EmailDetails, Long> {

}
