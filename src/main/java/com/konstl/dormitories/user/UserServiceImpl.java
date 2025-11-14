package com.konstl.dormitories.user;

import com.konstl.dormitories.role.RoleRepository;
import com.konstl.dormitories.user.dto.CreateUserRequest;
import com.konstl.dormitories.user.dto.UpdateUserRequest;
import com.konstl.dormitories.user.dto.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private static final String NO_PERM = "You don't have permission to make this operation";

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserResponse findById(Long id) {
        return null;
    }

    @Override
    public Optional<UserResponse> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<UserResponse> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Page<UserResponse> findByRoleId(Long role) {
        return null;
    }

    @Override
    public UserResponse create(CreateUserRequest createRequest) {
        return null;
    }

    @Override
    public UserResponse update(UpdateUserRequest updateRequest) {
        return null;
    }

    @Override
    public UserResponse delete(Long id) {
        return null;
    }
}
