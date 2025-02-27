package com.abdala.demo.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.abdala.demo.dto.UserDTO;
import com.abdala.demo.user.User;
import com.abdala.demo.repository.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

class UserServiceTest {

    @Mock
    private UserRepo userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserById_Success() {
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setName("abdala");

        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));

        UserDTO userDTO = userService.getUserById(1L);

        assertNotNull(userDTO);
        assertEquals("abdala", userDTO.getName());
    }

    @Test
    void testGetUserById_NotFound() {
        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> userService.getUserById(2L));
    }
}
