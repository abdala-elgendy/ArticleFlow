package com.abdala.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.abdala.demo.entity.User;
import com.abdala.demo.repository.UserRepo;
import com.abdala.demo.service.UserServiceImplem;
import com.abdala.demo.service.dto.CreateUserDTO;
import com.abdala.demo.service.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceImplTest {

    @Mock
    private UserRepo userRepository;

    @InjectMocks
    private UserServiceImplem userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
        UserDTO user = new UserDTO();
        user.setId(1);
        user.setName("John Doe");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userService.createUser(user);

        assertThat(createdUser.getId()).isEqualTo(1L);
        assertThat(createdUser.getName()).isEqualTo("John Doe");
        verify(userRepository, times(1)).save(any(User.class));
    }
}
