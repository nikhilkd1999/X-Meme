package com.nikhil.xmeme.controllers;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nikhil.xmeme.entities.Meme;
import com.nikhil.xmeme.services.IMemeService;

@Controller
public class MemeController {

    @Autowired
    private IMemeService memeService;

    @GetMapping("/")
    public String getAllMemes(final Model model) {

        final List<Meme> memes = memeService.getAllMemes();

        model.addAttribute("memes", memes);

        return "home";

    }

    @GetMapping("/add-meme")
    public String getAllMemes() {

        return "meme_form";

    }

    // @PostMapping("/")
    // public String saveMeme(@RequestBody Meme meme) {

    // meme.setTimeStamp(LocalDateTime.now());
    // memeService.save(meme);
    // return "redirect:/";
    // }

    @PostMapping("/save-meme")
    public String saveMeme(@RequestParam MultiValueMap<String, String> formData, final Principal principal) {

        final String userName = principal.getName();

        final Meme meme = new Meme();
        meme.setTitle(formData.getFirst("title"));
        meme.setDescription(formData.getFirst("description"));
        meme.setUrl(formData.getFirst("url"));
        meme.setTimeStamp(LocalDateTime.now());
        meme.setUserName(userName);
        memeService.save(meme);
        return "redirect:/";
    }

    // @PostMapping("/save-meme")
    // public String saveMeme(@ModelAttribute("meme") Meme meme) {
    // memeService.save(meme);
    // return "redirect:/";
    // }

    @DeleteMapping("/delete/{memeId}")
    public String deleteMeme(@PathVariable("memeId") String memeId, final Principal principal) {

        final String userName = principal.getName();

        final Meme meme = memeService.findMemeById(memeId);

        if (userName.equals(meme.getUserName())) {
            memeService.deleteMeme(meme);
        } else {

        }

        return "redirect:/";
    }

}
