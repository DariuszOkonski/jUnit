package com.javaeasily.demos.mockito.myapp.web;

import com.javaeasily.demos.mockito.myapp.service.AuthenticationService;
import junit.framework.TestCase;
import org.junit.Assert;
import org.mockito.Mockito;

public class LoginControllerTest extends TestCase {

    private AuthenticationService service; //mock
    private LoginController controller; //SUT

    public void setUp() throws Exception {
        this.service = Mockito.mock(AuthenticationService.class);
        this.controller = new LoginController(this.service);
    }

    public void testService_validUsernameAndPassword_logsInUser() {
        // arrange
        String expected = "/home";
        Mockito
                .when(this.service.authenticate(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(true);

        // act
        String actual = this.controller.service("tom", "password123");

        // assert
        Assert.assertEquals(expected, actual);
    }

    public void testService_invalidUsernameAndPassword_logsOutUser() {
        // arrange
        String expected = "/login";
        Mockito
                .when(this.service.authenticate(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(false);

        // act
        String actual = this.controller.service("tom", "password");

        // assert
        Assert.assertEquals(expected, actual);
    }
}