package org.example.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Setter
@Getter
@Component

public class WordDTO {
   private int id;
   private String uz_name;
   private String eng_name;
   private String some_description;

   @Override
   public String toString() {
      return
              id + "." + uz_name  +
              " -> " + eng_name  +
              " -> " + some_description;
   }
}
