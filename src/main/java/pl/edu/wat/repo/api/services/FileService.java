package pl.edu.wat.repo.api.services;

import org.springframework.web.multipart.MultipartFile;
import pl.edu.wat.repo.api.entities.File;

public interface FileService {

    File storeFile(MultipartFile file);

    File getFile(String fileId);

}
