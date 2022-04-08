package pl.edu.wat.repo.api.dtos.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Null;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AllAnnouncementRequest {

    @Null
    Integer limit;

    @Null
    Double maxLatitude;

    @Null
    Double minLatitude;

    @Null
    Double maxLongitude;

    @Null
    Double minLongitude;

    @Null
    Boolean isTakenType;

    @Null
    Boolean isOrganization;

    @Null
    Double maxPrice;

    @Null
    Set<String> categoryId;

    @Null
    Set<String> speciesId;

    public AllAnnouncementRequest(
            @Null Integer limit,
            @Null Double maxLatitude,
            @Null Double minLatitude,
            @Null Double maxLongitude,
            @Null Double minLongitude,
            @Null Boolean isTakenType,
            @Null Boolean isOrganization,
            @Null Set<String> categoryId,
            @Null Set<String> speciesId) {
        if (this.maxLatitude != null || this.minLatitude != null || this.maxLongitude != null || this.minLongitude != null) {
            assert this.maxLatitude != null;
            assert this.minLatitude != null;
            assert this.maxLongitude != null;
            assert this.minLongitude != null;
        }

        this.limit = limit;
        this.maxLatitude = maxLatitude;
        this.minLatitude = minLatitude;
        this.maxLongitude = maxLongitude;
        this.minLongitude = minLongitude;
        this.isTakenType = isTakenType;
        this.isOrganization = isOrganization;
        this.categoryId = categoryId;
        this.speciesId = speciesId;
    }
}
