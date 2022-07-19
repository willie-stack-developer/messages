package com.cortez.willie.messages.repository;

import com.cortez.willie.messages.entities.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
}