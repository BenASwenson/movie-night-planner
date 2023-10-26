package com.sparta.movieplanner;

import com.sparta.movieplanner.controllers.web.RegisterController;
import com.sparta.movieplanner.entities.Role;
import com.sparta.movieplanner.entities.User;
import com.sparta.movieplanner.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class UserTests {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;
    
//    @Autowired
//    private RegisterController registerController;
//    @MockBean
//    private UserRepository mockUserRepository;
//    private MockMvc mockMvc;

    /**
     * COMMENTED TEST IS A WORK IN PROGRESS
     * I tried my hand at a mock test for registering a user, but I'm failing after the save step as it said it's null.
     * Need to do more research on mockito so the test is commented out for now.
     */

//    @BeforeEach
//    void setup() {
//        mockMvc = MockMvcBuilders.standaloneSetup(registerController).build();
//    }
//
//    @Test
//    void testSuccessfulRegistration() throws Exception {
//        String firstName = "tess";
//        String lastName = "ting";
//        String username = "testuser@mail.com";
//        String password = "secretpassword";
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/register/form")
//                        .param("firstName", firstName)
//                        .param("lastName", lastName)
//                        .param("username", username)
//                        .param("password", password))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
//        // Verify that the user details were saved in the repository
//        verify(userRepository).save(any(User.class));
//    }

    @Test
    public void findUserInDatabase() {
        User testUser = new User();
        testUser.setId(1L);
        testUser.setFirstName("Janete");
        testUser.setLastName("Neto");
        testUser.setUsername("janeteneto26@gmail.com");
        testUser.setPassword(encoder.encode("janete"));
        testUser.setRole(Role.USER);

        User user = userRepository.findUserById(1L);

        String expected = testUser.toString();
        String result = user.toString();

        assertEquals(expected, result);
    }
}
