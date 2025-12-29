package com.example.mybatiscrudprac.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.mybatiscrudprac.domain.UserDto;
import com.example.mybatiscrudprac.domain.pageItem.PageResponse;
import com.example.mybatiscrudprac.domain.resultset.UserListItem;
import com.example.mybatiscrudprac.service.MainService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;

    @PostMapping("/adduser")
    public ResponseEntity<?> getMethodName(@RequestBody UserDto user) {
        mainService.addUser(user);
        return ResponseEntity.ok().body("useradd성공");
    }

    @GetMapping("/getuser")
    public ResponseEntity<UserDto> getMethodName(@RequestParam String userName) {
        UserDto user = mainService.getUser(userName);

        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    @GetMapping("/getuserlist")
    public ResponseEntity<PageResponse<UserListItem>> getuserlist(
         @RequestParam(defaultValue = "2") int page, 
         @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(mainService.getuserlist(page, size));
    }
    
    
}
