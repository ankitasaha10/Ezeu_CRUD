package com.example.eezu.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.example.eezu.entity.UserTable;
import com.example.eezu.exception.UserNotFoundException;
import com.example.eezu.repository.UserTableRepository;
import com.example.eezu.service.UserTableService;


@Component
public class UserTableServiceImpl implements UserTableService {

	@Autowired
	private UserTableRepository userTableRepository;

	@Override
	public UserTable create(UserTable user) {
		UserTable newUser = new UserTable();
		newUser = user.builder().address(user.getAddress()).name(user.getName()).phoneNo(user.getPhoneNo()).build();
		userTableRepository.save(newUser);
		return newUser;
	}

	@Override
	public List<UserTable> get() {
		List<UserTable> list = new ArrayList<>();
		for (UserTable u : userTableRepository.findAll()) {
			list.add(u);
		}
		return list;
	}

	@Override
	public String update(String id, UserTable user) {
		UserTable u = userTableRepository.findById(id).get();
		if (ObjectUtils.isEmpty(u)) {
			throw new RuntimeException("User not found");
		}
		u.setName(user.getName());
		userTableRepository.save(u);
		return "Successfully updated";
	}

	@Override
	public String delete(String id) {
		UserTable u = userTableRepository.findById(id).get();
		if (ObjectUtils.isEmpty(u)) {
			throw new RuntimeException("User not found");
		}

		userTableRepository.deleteById(id);

		return "Succesfully deleted";

	}
	
	@Override
    public UserTable deleteAttributes(String id, Map<String, Object> attributes) {
        UserTable user = userTableRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        // Remove specified attributes
        for (Map.Entry<String, Object> entry : attributes.entrySet()) {
            String attributeName = entry.getKey();
            if (userContainsAttribute(user, attributeName)) {
                user.removeAttribute(attributeName);
            } else {
                throw new IllegalArgumentException("Attribute not found: " + attributeName);
            }
        }

        // Save the updated user
        return userTableRepository.save(user);
    }

	private boolean userContainsAttribute(UserTable user, String attributeName) {
	    // Check if the UserTable class has a field with the given attribute name
	    try {
	        Field field = user.getClass().getDeclaredField(attributeName);
	        field.setAccessible(true); // Set the field to accessible
	        return true;
	    } catch (NoSuchFieldException e) {
	        return false;
	    }
	}


}
