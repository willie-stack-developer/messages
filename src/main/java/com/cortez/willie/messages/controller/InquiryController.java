package com.cortez.willie.messages.controller;

import com.cortez.willie.messages.entities.Inquiry;
import com.cortez.willie.messages.service.InquiryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/messages")
public class InquiryController {

    private final InquiryService inquiryService;

    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @GetMapping
    public String getForm(Model model){
        Inquiry inquiry = new Inquiry();
        model.addAttribute("inquiry", inquiry);
        return "contact";
    }

    @PostMapping
    public String saveInquiries(@ModelAttribute("inquiry") Inquiry inquiry){
        inquiryService.saveInquiry(inquiry);
        return "redirect:/messages";
    }

    @GetMapping("/see/{id}")
    public String seeMessage(@PathVariable(value = "id") Long id, Model model){
        Inquiry inquiry = inquiryService.getInquiryById(id);
        model.addAttribute("inquiry", inquiry);
        return "view";
    }

    @GetMapping("/update/{id}")
    public String updateMessage(@PathVariable(value = "id") Long id, Model model){
        Inquiry inquiry = inquiryService.getInquiryById(id);
        model.addAttribute("inquiry", inquiry);
        return "update";
    }
}
