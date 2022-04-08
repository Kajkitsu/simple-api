package pl.edu.wat.repo.api.entities;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;


@EqualsAndHashCode(callSuper = true)
@Data
@Document
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Announcement extends Entity {
    @NonNull
    String title;

    @Nullable
    String description;

    @NonNull
    Integer price;

    @NonNull
    Boolean isTakeType;

    Category category;

    User owner;

    List<File> photos = new ArrayList<>();

}
