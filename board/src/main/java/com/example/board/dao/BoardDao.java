package com.example.board.dao;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
    @Autowired
    JdbcTemplate jt;
    
    public List<Map<String, Object>> listSelect(){
        String sqlStmt = "select seq, title, writer, search_count from board";
        System.out.println(sqlStmt);
        return jt.queryForList(sqlStmt);
    }

    public List<Map<String, Object>> detailSelect(String seq){
        String sqlStmt = String.format("SELECT seq, title, content, search_count FROM board WHERE seq = %s",seq);
        return jt.queryForList(sqlStmt);
    }

    public void insert(String title, String content, String writer){
        String sqlStmt = String.format("INSERT INTO BOARD(title,content,writer) values('%s','%s','%s')",title,content,writer);
        System.out.println(sqlStmt);
        jt.execute(sqlStmt);
    }

    public void delete(String seq) {
        String sqlStmtMain = String.format("DELETE FROM board WHERE seq = '%s'",seq);
        String sqlStmtDetail = String.format("DELETE FROM board_answer WHERE seq = '%s'",seq); // DATABASE 설정이 더 좋음(FOREIGN-KEY CASCADING)
        jt.execute(sqlStmtMain);
        jt.execute(sqlStmtDetail);
    }

    public void update(String title, String content, String seq) {
        String sqlStmt = String.format("UPDATE board SET title ='%s', content='%s' WHERE seq='%s'",title,content,seq);
        jt.execute(sqlStmt);
    }

    public void updateSearchCount(String seq, String searchCount){
        String sqlStmt = String.format("UPDATE board SET search_count = '%s' WHERE seq=%s",searchCount,seq);
        jt.execute(sqlStmt);
    }

    public void insertAnswer(String seq, String answer) {
        String sqlStmt = String.format("INSERT INTO board_answer(seq,answer) values(%s,'%s')",seq,answer);
        jt.execute(sqlStmt);
    }

    public List<Map<String, Object>> getCountAnswer(String seq){
        String sqlStmt = String.format("select answer from board_answer where seq=%s",seq);
        return jt.queryForList(sqlStmt);
    }
}    