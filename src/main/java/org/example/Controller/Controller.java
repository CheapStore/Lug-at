package org.example.Controller;

import org.example.DTO.WordDTO;
import org.example.Db.DatabaseUtil;
import org.example.Repository.Wordrepository;
import org.example.Service.Wordservice;
import org.example.utils.ScannerUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
   private DatabaseUtil databaseUtil;
    @Autowired
   private WordDTO wordDTO;
    @Autowired
    private Wordrepository wordrepository;
    @Autowired
    private ScannerUtils scannerUtils;
    @Autowired
 private    Wordservice wordservice;


    public void start() {
       databaseUtil.createWordTable();
        do {
            showMain();
        } while (true);

    }

    private void showMain() {
        while (true) {
            System.out.println("""
                         ***** Menu *****
                          1. Add Word
                          2. WordList List
                          3. Multiple Choice
                          4. Spelling
                          5. Searching
                          6. Delete by id
                    """);
            int i = scannerUtils.nextInt("Choose option:");
            switch (i){
                case 1-> AddMainu();
                case 2-> ShowWord();
                case 3->{}
                case 4->{}
                case 5-> search();
                case 6->{}
                default -> {
                    System.out.println("Wrong!!!");
                }
                }
            }

        }

    private void search() {
        String searchName = scannerUtils.nextLine("Enter word name (uz/eng) :");
        wordservice.search(searchName);
    }

    private void ShowWord() {
        List<WordDTO> show = wordservice.show();
        for (WordDTO dto : show) {
            System.out.println(dto);
        }
    }

    private void AddMainu() {
        String name_eng = scannerUtils.nextLine("Enter word (Book) : ");
        String name_uz = scannerUtils.nextLine("Enter Translate (Kitob) : ");
        String description = scannerUtils.nextLine(" Enter description  (I love reading book): ");
        wordDTO.setUz_name(name_uz);
        wordDTO.setEng_name(name_eng);
        wordDTO.setSome_description(description);
        wordservice.addWord(wordDTO);
    }
}


