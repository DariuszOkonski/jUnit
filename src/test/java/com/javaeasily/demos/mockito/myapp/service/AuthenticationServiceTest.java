package com.javaeasily.demos.mockito.myapp.service;

import com.javaeasily.demos.mockito.myapp.data.UserRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito;

public class AuthenticationServiceTest extends TestCase {

    private UserRepository repository; // mock
    private AuthenticationService service; // SUT

    public void setUp() throws Exception {
        this.repository = Mockito.mock(UserRepository.class);
        this.service = new AuthenticationService(this.repository);
    }

    @Test
    public void testAuthenticate() {
        // arrange
        Mockito
                .when(this.repository.findByUsername(Mockito.anyString()))
                .thenThrow(new IllegalArgumentException());

        // act
        this.service.authenticate("harry", "harry1234");

        // assert
    }
}