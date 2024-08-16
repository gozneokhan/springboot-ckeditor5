package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

    @GetMapping("/content") // 세부 주소 설정 추후에
    public String contentPage() {

        return "content";
    }
}
