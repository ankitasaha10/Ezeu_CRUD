package com.example.eezu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eezu.entity.UserTable;

@RestController
@RequestMapping("/v1.0")
public interface UserTableController {
	
	@PostMapping("/create")
	public ResponseEntity<UserTable>  createUser(@RequestBody UserTable user);
	
	@GetMapping("/get")
	public ResponseEntity<List<UserTable>> get ();
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable String id, @RequestBody UserTable updatedDetails);
	
	 @DeleteMapping("/{userId}/attributes")
	    public ResponseEntity<UserTable> deleteAttributes(@PathVariable String id, @RequestBody Map<String, Object> attributes) ;
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable String id );
	
	

}
