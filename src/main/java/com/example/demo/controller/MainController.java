package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/") // root 경로로 요청이 왔을 때
    public String mainPage() {

        return "main"; // mainPage가 응답한다.
    }
}
