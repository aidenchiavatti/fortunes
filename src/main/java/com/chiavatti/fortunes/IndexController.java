package com.chiavatti.fortunes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private FortuneRepository fortunes;

    public IndexController(FortuneRepository fortunes) {
        this.fortunes = fortunes;
    }

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("fortune", fortunes.getFortune());
        return "index";
    }
}