package com.example.demo.controller;

import com.example.demo.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EditorController {

    private ContentService contentService;

    @Autowired
    public EditorController(ContentService contentService) {

        this.contentService = contentService;
    }

    @GetMapping("/editor")
    public String editorPage() {

        return "editor";
    }

    @GetMapping("/editor/{id}")
    public String updatePage(@PathVariable("id")String id, Model model) {

//        System.out.println(id);

        model.addAttribute("data",  contentService.selectOneContent(id));


        return "editor";
    }
}
