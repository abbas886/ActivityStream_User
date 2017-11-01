package com.stackroute.activitystream.ActivityStreamBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.stackroute.activitystream.ActivityStreamBackend.DAO.UserDAO;
import com.stackroute.activitystream.ActivityStreamBackend.Model.UserModel;

public class ActivityStreamTestCases {
	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	static UserDAO userDAO;
	@Autowired
	static UserModel user;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.stackroute.*");
		
		context.refresh();
		System.out.println("Hi ");
		userDAO = (UserDAO) context.getBean("userDAO");
		
	}

	@Test
	public void testInsertUser() {
user=new UserModel();
		user.setUserName("Amarnath");
		user.setPassword("Amarnath");
		user.setUserId(101);

		assertEquals(true, userDAO.insert(user));
	}

	//
	// @Test
	// public void testValidateUser() {
	// UserDAO userDAO = (UserDAO) context.getBean("userDAO");
	// boolean validatedUser = userDAO.validateUser("Amar", "Amar");
	// assertNotNull(validatedUser);
	// }
	//
	// @Test
	// public void testDeleteUser() {
	// UserDAO userDAO = (UserDAO) context.getBean("userDAO");
	// UserModel userToDelete = userDAO.getuserById(1);
	// userDAO.deleteUser(userToDelete);
	// UserModel afterUserDelete=userDAO.getuserById(1);
	// assertNotNull(afterUserDelete);
	// }
	//
	// @Test
	// public void testUpdateUser() {
	// UserDAO userDAO = (UserDAO) context.getBean("userDAO");
	// UserModel updatedUser = userDAO.getuserById(1);
	// assertNotNull(updatedUser);
	// assertEquals(true, userDAO.updateUser(updatedUser));
	// }
	//
	//
	// @Test
	// public void testForGetAllUsers() {
	// UserDAO userDAO = (UserDAO) context.getBean("userDAO");
	// List<UserModel> userList = userDAO.getAllusers();
	// assertNotNull(userList);
	// for (UserModel userDataBasaData : userList) {
	// System.out.println(userDataBasaData.getUserId());
	// }
	// }
}
