package pl.edu.wat.repo.api.dtos.request;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(callSuper = true)
public class AnnouncementUpdateRequest extends AnnouncementRequest {
    @NotNull
    String id;

    @Null
    String newOwnerId;

    public AnnouncementUpdateRequest(
            @Null List<MultipartFile> photos,
            @NotNull Double latitude,
            @NotNull Double longitude,
            @NotNull String title,
            @NotNull String description,
            @NotNull String id,
            @NotNull Boolean isTakeType,
            @Null Integer price,
            @Null String newOwnerId,
            @NotNull String categoryIds,
            @NotNull String speciesIds) {
        super(photos, latitude, longitude, title, description, isTakeType, price, categoryIds, speciesIds);
        this.id = id;
        this.newOwnerId = newOwnerId;
    }
}
