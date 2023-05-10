package com.nikhil.xmeme.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nikhil.xmeme.entities.Meme;
import com.nikhil.xmeme.services.IMemeService;

@Controller
public class MemeController {

    @Autowired
    IMemeService memeService;

    @GetMapping("/")
    public String getAllMemes(Model model) {

        final List<Meme> memes = memeService.getAllMemes();

        model.addAttribute("memes", memes);

        return "home";

    }

    @PostMapping("/")
    public String saveMeme(@RequestBody Meme meme) {

        meme.setTimeStamp(LocalDateTime.now());
        memeService.save(meme);
        return "redirect:/";
    }

}
