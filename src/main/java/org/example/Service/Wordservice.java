package org.example.Service;

import org.example.DTO.WordDTO;
import org.example.Repository.Wordrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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

    public boolean search(String searchName) {
        List<WordDTO> searching = wordrepository.searching(searchName);
        for (WordDTO wordDTO : searching) {
            if (wordDTO!=null){
                return true;
            }
        }
        return false;
    }

    public void delete(String id) {
        boolean deleteid = wordrepository.deleteid(id);
        if (deleteid){
            System.out.println("Sacsec 👌");
        }else {
            System.out.println("No delete 🤦‍♂️");
        }
    }



    public void showtest() {
    }

    public void test_uz() {
        String savol="";
        List<WordDTO> wordDTOS = wordrepository.showWord();
        Random random=new Random();
        int num = 0;
        for (int i=0;i<4;i++){
            num=random.nextInt(0, 4);

        }
    }

    public void test_eng() {

    }
}
