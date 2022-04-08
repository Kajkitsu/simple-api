package pl.edu.wat.repo.api.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserRequest {
    private String username;
    private String email;
    private Set<String> role;
    private String password;
    private String surname;
    private String name;
    private String pesel;
    private String fatherName;

}
