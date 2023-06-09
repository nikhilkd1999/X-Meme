package com.nikhil.xmeme.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikhil.xmeme.entities.Meme;
import com.nikhil.xmeme.repositories.IMemeRepository;
import com.nikhil.xmeme.services.IMemeService;

@Service
public class MemeService implements IMemeService {

    @Autowired
    private IMemeRepository memeRepository;

    @Override
    public Meme save(final Meme meme) {
        final Meme savedMeme = memeRepository.save(meme);
        return savedMeme;
    }

    @Override
    public List<Meme> getAllMemes() {
        final List<Meme> allMemes = memeRepository.findAll();

        allMemes.sort((x, y) -> {
            if (x.getTimeStamp() != null && y.getTimeStamp() != null)
                return y.getTimeStamp().compareTo(x.getTimeStamp());
            else
                return 0;
        });

        return allMemes;
    }

    @Override
    public Meme findMemeById(String id) {
        
        return memeRepository.findById(id).get();
        
    }
    @Override
    public void deleteMeme(Meme meme) {
        memeRepository.delete(meme);
    }

}
