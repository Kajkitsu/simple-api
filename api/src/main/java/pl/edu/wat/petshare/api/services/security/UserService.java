package pl.edu.wat.repo.api.services.security;

import pl.edu.wat.repo.api.dtos.request.LoginRequest;
import pl.edu.wat.repo.api.dtos.response.JwtResponse;

public interface UserService {
    JwtResponse login(LoginRequest loginRequest);
}
