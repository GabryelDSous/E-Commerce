package dev.gabryel.ecommerce.service;

import dev.gabryel.ecommerce.config.TokenConfig;
import dev.gabryel.ecommerce.dto.user.request.UserLoginRequest;
import dev.gabryel.ecommerce.dto.user.request.UserRegisterRequest;
import dev.gabryel.ecommerce.mapper.UserMapper;
import dev.gabryel.ecommerce.model.UserModel;
import dev.gabryel.ecommerce.model.enums.UserRoles;
import dev.gabryel.ecommerce.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenConfig tokenConfig;
    private final AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenConfig tokenConfig, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenConfig = tokenConfig;
        this.authenticationManager = authenticationManager;
    }

    @Transactional
    public String userRegister(UserRegisterRequest userRequest, int accountType) {
        UserModel userModel = UserMapper.toUserModel(userRequest);
        userModel.setPassword(passwordEncoder.encode(userRequest.password()));
        switch (accountType) {
            case 1 -> userModel.setRole(UserRoles.ADMIN);
            case 2 -> userModel.setRole(UserRoles.USER);
        }
        userRepository.save(userModel);
        return userModel.getEmail();
    }

    public String userLogin(UserLoginRequest userRequest) {
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(
                userRequest.email(), userRequest.password()
        );
        UserModel userModel = (UserModel) authenticationManager.authenticate(userAndPass).getPrincipal();
        return tokenConfig.generateToken(userModel);
    }
}
