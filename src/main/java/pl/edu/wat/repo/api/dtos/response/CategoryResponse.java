package pl.edu.wat.repo.api.dtos.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CategoryResponse {
    String id;
    String name;

}
