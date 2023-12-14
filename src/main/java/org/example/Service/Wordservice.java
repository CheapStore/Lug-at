package org.example.Service;

import org.example.DTO.WordDTO;
import org.example.Repository.Wordrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Wordservice {
    @Autowired
   private Wordrepository wordrepository;
    public void addWord(WordDTO wordDTO) {
        boolean b = wordrepository.addWord(wordDTO);
        if (b){
            System.out.println(" Word add 👌");
        }else {
            System.out.println(" No add 🤦‍♂️");
        }


    }

    public List<WordDTO> show() {
        List<WordDTO> wordDTOS = wordrepository.showWord();
        return wordDTOS;
    }

    public void search(String searchName) {
        wordrepository.searching(searchName);
    }
}
