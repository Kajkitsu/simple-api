package pl.edu.wat.repo.api.dtos.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Null;
import java.util.List;

@Data
public class UserUpdateRequest {
    @Null
    List<MultipartFile> photos;

    @Null
    String description;

    @Null
    Boolean isOrganization;
}
