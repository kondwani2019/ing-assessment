package com.ing.security;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.IngUserManagementApplication;
import com.ing.controller.UserManagementController;
import com.ing.model.dto.UserDto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {IngUserManagementApplication.class})
public class IsUserTest {

	@Autowired
	private UserManagementController userController;
	
	@Test
	@WithMockUser(username = "john", roles = { "VIEWER" })
	public void testIsUser() {
		//  Should fail because Role is not "USER"
		List<UserDto> allUsers = userController.getAll();
		
	}
}
