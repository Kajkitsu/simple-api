package pl.edu.wat.repo.api.entities;

import com.mongodb.lang.NonNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Document
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class File extends Entity {
    @NonNull
    String fileName;
    @NonNull
    String fileType;
    @NonNull
    private Binary binary; //if <16MB else GridFs
}
