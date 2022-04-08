package pl.edu.wat.repo.api.dtos.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Collections;
import java.util.List;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
public class AnnouncementRequest {
    @Null
    List<MultipartFile> photos;

    @NotNull
    Double latitude;

    @NotNull
    Double longitude;

    @NotNull
    String title;

    @NotNull
    String description;

    @NotNull
    Boolean isTakeType;

    @Null
    Integer price;

    @NotNull
    String categoryId;

    @NotNull
    String speciesId;

    public List<MultipartFile> getPhotos() {
        if (photos == null) {
            return Collections.emptyList();
        }
        return photos;
    }
}
