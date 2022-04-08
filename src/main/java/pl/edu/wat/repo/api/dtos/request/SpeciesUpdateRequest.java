package pl.edu.wat.repo.api.dtos.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
@Data
public class SpeciesUpdateRequest {
    @NotNull
    String id;
    @NotNull
    String name;
}
