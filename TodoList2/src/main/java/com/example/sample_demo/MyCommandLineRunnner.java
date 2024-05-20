package com.example.sample_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunnner implements CommandLineRunner {

    @Autowired
    TodoRepository todoRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("コマンドラインランナー実行開始");
        
        Todo todo = new Todo("タスク1","タスク1です","道長",3.5);
        todoRepository.save(todo);
        
        System.out.println("コマンドラインランナー実行終了");
    }
}

