package com.cortez.willie.messages.service;

import com.cortez.willie.messages.entities.Inquiry;
import com.cortez.willie.messages.repository.InquiryRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class InquiryServiceImpl implements InquiryService{

    private final InquiryRepository inquiryRepository;

    public InquiryServiceImpl(InquiryRepository inquiryRepository) {
        this.inquiryRepository = inquiryRepository;
    }

    @Override
    public void saveInquiry(Inquiry inquiry) {
        this.inquiryRepository.save(inquiry);
    }

    @Override
    public Inquiry getInquiryById(Long id) {
        Optional<Inquiry> optional = inquiryRepository.findById(id);
        Inquiry inquiry = null;
        if (optional.isPresent()){
            inquiry = optional.get();
        }else {
            throw new RuntimeException("Inquiry with id: "+ id+ " not exists.");
        }
        return inquiry;
    }
}
