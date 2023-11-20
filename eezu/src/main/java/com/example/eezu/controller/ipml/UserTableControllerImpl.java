package com.example.eezu.controller.ipml;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.eezu.controller.UserTableController;
import com.example.eezu.entity.UserTable;
import com.example.eezu.exception.UserNotFoundException;
import com.example.eezu.service.UserTableService;


@Component
public class UserTableControllerImpl implements UserTableController{
	
	@Autowired
	private UserTableService userTableService;

	@Override
	public ResponseEntity<UserTable> createUser(UserTable user) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userTableService.create(user));
	}

	@Override
	public ResponseEntity<List<UserTable>> get() {
		return ResponseEntity.status(HttpStatus.OK).body(userTableService.get());
	}

	@Override
	public ResponseEntity<String> update(String id, UserTable updatedDetails) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userTableService.update(id,updatedDetails));
	}

	@Override
	public ResponseEntity<String> delete(String id) {
		// TODO Auto-generated method stub
		return ResponseEntity.status(HttpStatus.OK).body(userTableService.delete(id));
	}

	@Override
	 @Override
	    public ResponseEntity<UserTable> deleteAttributes(String id, Map<String, Object> attributes) {
	        try {
	            UserTable updatedUser = userTableService.deleteAttributes(id, attributes);
	            return ResponseEntity.ok(updatedUser);
	        } catch (UserNotFoundException e) {
	            return ResponseEntity.notFound().build();
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }

}
