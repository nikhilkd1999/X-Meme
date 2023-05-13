package com.nikhil.xmeme.services;

import java.util.List;

import com.nikhil.xmeme.entities.Meme;

public interface IMemeService {
    
    Meme save(Meme meme);

    List<Meme> getAllMemes();

    Meme findMemeById(String id);

    void deleteMeme(Meme meme);

}
