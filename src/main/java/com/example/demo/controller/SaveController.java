package com.example.demo.controller;

import com.example.demo.dto.SaveDTO;
import com.example.demo.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SaveController {

    private ContentService contentService;

    @Autowired
    public SaveController(ContentService contentService) {

        this.contentService = contentService;

    }

    @PostMapping("/save")
    public String saveLogic(SaveDTO saveDTO) {

//        System.out.println(saveDTO);
        contentService.saveContent(saveDTO);

        return "redirect:/";
    }
}
