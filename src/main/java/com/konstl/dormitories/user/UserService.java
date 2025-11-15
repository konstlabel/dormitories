package com.konstl.dormitories.user;

import com.konstl.dormitories.security.dto.SignUpRequest;
import com.konstl.dormitories.user.dto.CreateUserRequest;
import com.konstl.dormitories.user.dto.UpdateUserRequest;
import com.konstl.dormitories.user.dto.UserResponse;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface UserService {

    UserResponse findById(Long id);

    Optional<UserResponse> findByUsername(String username);

    Optional<UserResponse> findByEmail(String email);

    Page<UserResponse> findByRoleId(Long role);

    UserResponse create(CreateUserRequest createRequest);

    UserResponse create(SignUpRequest signUpRequest);

    UserResponse update(UpdateUserRequest updateRequest);

    UserResponse delete(Long id);
}
