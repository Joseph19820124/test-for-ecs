package com.nike.im.java_service_A.controller;

import com.nike.im.java_service_A.dto.Photo;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Log
@RestController
public class HelloWorldController {

    private List<Photo> db2 = List.of(
            new Photo("1","hello1.jpg"),
            new Photo("2","hello2.jpg"),
            new Photo("3","hello3.jpg")

            );

    private Map<String, Photo> db = new HashMap<>(){
        {
            put("1", new Photo("1", "hello1.jpg"));
            put("2", new Photo("2", "hello2.jpg"));
            put("3", new Photo("3", "hello3.jpg"));
        }
    };

    @GetMapping(path = "/greeting")
    public String greeting(){
        return "Hello World!-----234";
    }

    @GetMapping("hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("photoz")
    public Collection<Photo> get(){
        return db.values();
    }
    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id){
        log.info(id);

        Photo photo = db.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return this.db.get(id);
    }
    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable String id){
        log.info(id);

        Photo photo = db.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        else db.remove(id);
    }

    @PostMapping("/photoz")
    public Photo create(@RequestBody @Validated Photo photo) {
        photo.setId(UUID.randomUUID().toString());
        db.put(photo.getId(), photo);
        return photo;
    }
}
