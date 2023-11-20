package com.example.eezu.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.eezu.entity.UserTable;


@Service
public interface UserTableService {
	
	public UserTable create(UserTable user);
	
	public List<UserTable> get();
	
	public String update(String id, UserTable user);
	
	public String delete(String id);

	public UserTable deleteAttributes(String id, Map<String, Object> attributes);

}
