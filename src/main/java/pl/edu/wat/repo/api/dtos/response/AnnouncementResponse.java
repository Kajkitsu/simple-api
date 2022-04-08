package pl.edu.wat.repo.api.dtos.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import pl.edu.wat.repo.api.entities.Announcement;
import pl.edu.wat.repo.api.entities.File;

import java.util.List;


@RequiredArgsConstructor
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AnnouncementResponse {
    String id;
    String title;
    String description;
    List<String> fileIds;
    String categoryIds;
    Boolean isOrganization;
    String ownerID;
    Integer price;
    Boolean isTakeType;


    public static AnnouncementResponse from(Announcement entity){
        return new AnnouncementResponse(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getPhotos().stream().map(File::getId).toList(),
                entity.getCategory().getId(),
                entity.getOwner().getIsOrganization(),
                entity.getOwner().getId(),
                entity.getPrice(),
                entity.getIsTakeType()
        );
    }


}
