package com.poscoict.posledger.assets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.poscoict.posledger.assets.model.vo.Page;
import com.poscoict.posledger.assets.model.vo.UserVo;
import com.poscoict.posledger.assets.model.vo.ResourcesWrapper;
import com.poscoict.posledger.assets.service.UserService;

@BasePathAwareController
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping(value="/user/list")
    public ResponseEntity<?> getUserList() {
    	Page<UserVo> list = userService.getAllUsers();
        return ResponseEntity.ok(list);
    }
	
	@GetMapping(value="/users")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(new ResourcesWrapper<UserVo>(userService.getUsers()));
    }

    @GetMapping(value="/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id){
    	return ResponseEntity.ok(userService.getUser(id));
    }
}