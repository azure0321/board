package com.example.mybatis.board.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.mybatis.board.mapper.DemoMapper;
import com.example.mybatis.board.mapper.DemoMapperById;

@RestController
public class DBController {

@Autowired
DemoMapper demoMapper;
@Autowired
DemoMapperById DemoMapperById;
    @GetMapping("/mybatis/demo")
    public List<Map<String, Object>> mybatisDemo(){
        return demoMapper.select();
    }

    @GetMapping("/mybatis/demoid")
    public List<Map<String, Object>> mybatisDemoById(){
        return DemoMapperById.selectById("1");
    }
}