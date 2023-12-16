package org.example.Service;

import org.example.DTO.WordDTO;
import org.example.Repository.Wordrepository;
import org.example.utils.ScannerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class Wordservice {
  private   Random random=new Random();

    @Autowired
   private ScannerUtils scannerUtils;
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





    public void test_uz() {
        List<WordDTO> wordDTOS = wordrepository.showWord();
        int size = 0;
        char javob ='A';
        Random random=new Random();
        int num = 0;
        String uz = null;
        String a = "",b = "",c = "";
        Collections.shuffle(wordDTOS);
            num=random.nextInt(0, 4);
            WordDTO wordDTO = wordDTOS.get(num);
            System.out.println("Exam :"+wordDTO.getUz_name());
            String engNameJavob = wordDTO.getEng_name();
            for (WordDTO dto : wordDTOS) {
                size++;
                System.out.println(javob++ +")"+dto.getEng_name());
                if (dto.getEng_name().equals(engNameJavob)){
                    engNameJavob= dto.getEng_name();
                }
                if (size==4){
                    break;
                }
            }
            String s = scannerUtils.nextLine("Enter :");
            //            switch (i){
//                case 0-> {
//                    List<WordDTO> wordDTOS1 = wordrepository.searchIdUz(num);
//                    for (WordDTO wordDTO : wordDTOS1) {
//                       uz=wordDTO.getUz_name();
//                    }
//                }
//                case 1->{
//                    List<WordDTO> wordDTOS1 = wordrepository.searchIdEng(num);
//                    for (WordDTO wordDTO : wordDTOS1) {
//                      a=wordDTO.getEng_name();
//                    }
//                }
//                case 2->{
//                    List<WordDTO> wordDTOS1 = wordrepository.searchIdEng(num);
//                    for (WordDTO wordDTO : wordDTOS1) {
//                        b=wordDTO.getEng_name();
//                    }
//                }
//                case 3->{
//                    List<WordDTO> wordDTOS1 = wordrepository.searchIdEng(num);
//                    for (WordDTO wordDTO : wordDTOS1) {
//                        c=wordDTO.getEng_name();
//                    }
//                }
//
//
//            }

//        System.out.println("Exam:"+uz+"\nA]"+a+"\n"+"B]"+b+"\n"+"C]"+ c);}
           if (s.equals(engNameJavob)){
            System.out.println("👌👌👌");
            test_uz();
           }else {
            System.out.println("🤦‍♂️🤦‍♂️🤦‍♂️");
           }



    }

    public void test_eng() {
        List<WordDTO> wordDTOS = wordrepository.showWord();
        int size = 0;
        char javob ='A';
        int num = 0;
        String uz = null;
        String a = "",b = "",c = "";
        Collections.shuffle(wordDTOS);
        num=random.nextInt(0, 4);
        WordDTO wordDTO = wordDTOS.get(num);
        System.out.println("Exam :"+wordDTO.getEng_name());
        String engNameJavob = wordDTO.getUz_name();
        for (WordDTO dto : wordDTOS) {
            size++;
            System.out.println(javob++ +")"+dto.getUz_name());
            if (dto.getUz_name().equals(engNameJavob)){
                engNameJavob= dto.getUz_name();
            }
            if (size==4){
                break;
            }
        }
        String s = scannerUtils.nextLine("Enter :");
        //            switch (i){
//                case 0-> {
//                    List<WordDTO> wordDTOS1 = wordrepository.searchIdUz(num);
//                    for (WordDTO wordDTO : wordDTOS1) {
//                       uz=wordDTO.getUz_name();
//                    }
//                }
//                case 1->{
//                    List<WordDTO> wordDTOS1 = wordrepository.searchIdEng(num);
//                    for (WordDTO wordDTO : wordDTOS1) {
//                      a=wordDTO.getEng_name();
//                    }
//                }
//                case 2->{
//                    List<WordDTO> wordDTOS1 = wordrepository.searchIdEng(num);
//                    for (WordDTO wordDTO : wordDTOS1) {
//                        b=wordDTO.getEng_name();
//                    }
//                }
//                case 3->{
//                    List<WordDTO> wordDTOS1 = wordrepository.searchIdEng(num);
//                    for (WordDTO wordDTO : wordDTOS1) {
//                        c=wordDTO.getEng_name();
//                    }
//                }
//
//
//            }

//        System.out.println("Exam:"+uz+"\nA]"+a+"\n"+"B]"+b+"\n"+"C]"+ c);}
        if (s.equals(engNameJavob)){
            System.out.println("👌👌👌");
            test_uz();
        }else {
            System.out.println("🤦‍♂️🤦‍♂️🤦‍♂️");
        }


    }

    public void translete() {
        List<WordDTO> wordDTOS = wordrepository.showWord();
        int size = wordDTOS.size();
        String uzName="";
        String trans="";
        int i = random.nextInt(0, size);
        List<WordDTO> wordDTOS1 = wordrepository.searchIdUz(i);
        for (WordDTO wordDTO : wordDTOS1) {
            uzName = wordDTO.getUz_name();
            trans = wordDTO.getEng_name();
        }
        System.out.println(uzName);
        String translate="";
        do {
          translate = scannerUtils.nextLine("Enter translate {0.Javob} :");
          if (translate.equals("0")){
              System.out.println("translate 🙋‍ :"+trans);
              return;
          }
        }while (!translate.equals(trans));
        translete();


    }
}
