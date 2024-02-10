package tests;

import Model.User;
import Utils.TestUtils;

public class UserTests {
    
    public static void main(String[] args) {
        testUserConstructor();
    }
    
    public static void testUserConstructor() {
        String test_username = "mike";
        String test_password = "my_passwd";
        String test_first_name = "Mike";
        String test_last_name = "Smith";
        String test_mobile_number = "0771234567";
        
        // Create user
        User testUser = new User(test_username, test_password, test_first_name, test_last_name, test_mobile_number);
        
        // Test username
        assert testUser.getUsername().equals(test_username) : "Username test failed";
        System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getUsername-Passed" + TestUtils.TEXT_COLOR_RESET);
        
        // Test password
        assert testUser.getPassword() != null && testUser.getPassword().equals(test_password) : "Password test failed";
        System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getPassword-Passed" + TestUtils.TEXT_COLOR_RESET);
        
        // Test first name
        assert testUser.getFirst_name().equals(test_first_name) : "First name test failed";
        System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getFirst_name-Passed" + TestUtils.TEXT_COLOR_RESET);
        
        // Test last name
        assert testUser.getLast_name().equals(test_last_name) : "Last name test failed";
        System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-getLast_name-Passed" + TestUtils.TEXT_COLOR_RESET);
        
        // Test mobile number
        assert testUser.getMobile_number().equals(test_mobile_number) : "Mobile number test failed";
        System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC5-getMobile_number-Passed" + TestUtils.TEXT_COLOR_RESET);

       
        System.out.println("All TC'S passed. All Java assertions in the test suite passed (none failed).");
    }
}

