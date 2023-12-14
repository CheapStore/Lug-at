package org.example.Repository;

import org.example.DTO.WordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Wordrepository {
    @Autowired
  private   JdbcTemplate jdbcTemplate;


    public boolean addWord(WordDTO wordDTO) {
        String sql = "insert into dictionery(uz_name,eng_name,some_description) values ('%s','%s','%s')";
        sql=String.format(sql,wordDTO.getUz_name(),wordDTO.getEng_name(),wordDTO.getSome_description());
        int res = jdbcTemplate.update(sql);
        return res!=0;
    }


    public  List<WordDTO> showWord() {
        String sql = "select * from dictionery";
        List<WordDTO> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(WordDTO.class));
        return query;
    }

    public List<WordDTO> searching(String searchName) {

        String sql = "select * from dictionery where uz_name like ? or eng_name like ?";
        List<WordDTO> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(WordDTO.class), searchName, searchName);
        return query;



    }

    public boolean deleteid(String word_id) {
        String sql="DELETE FROM dictionery  WHERE id="+word_id;
        int update = jdbcTemplate.update(sql);
        return update!=0;
    }


    public void searchId(int  searchId) {
        String sql="select uz_name from dictionery where id="+searchId;
        jdbcTemplate.execute(sql);
    }
}
