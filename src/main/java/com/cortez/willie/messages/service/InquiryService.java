package com.cortez.willie.messages.service;

import com.cortez.willie.messages.entities.Inquiry;

public interface InquiryService {
    void saveInquiry(Inquiry inquiry);
    Inquiry getInquiryById(Long id);
}
