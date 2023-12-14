package org.example.Db;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class DatabaseUtil {
    @Autowired
   private JdbcTemplate jdbcTemplate;


//    public void createWordTable() {
//        String sql = "create table if not exists word("+
//                " id serial primary key,"+
//                " name varchar ,"+
//                " translate varchar,"+
//                " some_description varchar,"+
//                ")";
//
//        jdbcTemplate.execute(sql);
//    }

    public void createWordTable(){
        String sql ="create table if not exists dictionery (" +
                "id serial primary key," +
                "uz_name varchar," +
                "eng_name varchar," +
                "some_description varchar" +
                ")";

        jdbcTemplate.execute(sql);
    }
}
