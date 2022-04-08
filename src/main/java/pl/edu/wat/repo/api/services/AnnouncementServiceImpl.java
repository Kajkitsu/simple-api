package pl.edu.wat.repo.api.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.repo.api.dtos.request.AllAnnouncementRequest;
import pl.edu.wat.repo.api.dtos.request.AnnouncementRequest;
import pl.edu.wat.repo.api.dtos.request.AnnouncementUpdateRequest;
import pl.edu.wat.repo.api.dtos.response.AnnouncementResponse;
import pl.edu.wat.repo.api.entities.Announcement;
import pl.edu.wat.repo.api.entities.Category;
import pl.edu.wat.repo.api.entities.User;
import pl.edu.wat.repo.api.exceptions.EntityNotFoundException;
import pl.edu.wat.repo.api.exceptions.NotOwnerOfEntityException;
import pl.edu.wat.repo.api.repositories.AnnouncementRepository;
import pl.edu.wat.repo.api.repositories.AnnouncementSpecialRepository;
import pl.edu.wat.repo.api.repositories.CategoryRepository;
import pl.edu.wat.repo.api.repositories.UserRepository;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import pl.edu.wat.repo.api.utils.UserUtils;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AnnouncementServiceImpl implements AnnouncementService {

    AnnouncementRepository announcementRepository;
    AnnouncementSpecialRepository announcementSpecialRepository;
    UserRepository userRepository;
    CategoryRepository categoryRepository;
    FileService fileService;

    @Override
    public AnnouncementResponse add(AnnouncementRequest request, String userId) throws EntityNotFoundException {

        Announcement announcement = Announcement.builder()
                .description(request.getDescription())
                .owner(userRepository.findById(userId)
                        .orElseThrow(() -> new EntityNotFoundException(User.class)))
                .photos(request.getPhotos().stream().map(fileService::storeFile).toList())
                .title(request.getTitle())
                .price(request.getPrice() != null ? request.getPrice() : 0)
                .isTakeType(request.getIsTakeType())
                .category(
                        categoryRepository.findById(request.getCategoryId())
                                .orElseThrow(() -> new EntityNotFoundException(Category.class)))
                .build();

        return AnnouncementResponse.from(
                announcementRepository
                        .save(announcement));
    }

    @Override
    public AnnouncementResponse update(AnnouncementUpdateRequest request, String userId) throws EntityNotFoundException, NotOwnerOfEntityException {

        Announcement announcement = announcementRepository
                .findById(request.getId())
                .orElseThrow(() -> new EntityNotFoundException(Announcement.class));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(org.apache.catalina.User.class));

        if (!user.equals(announcement.getOwner()) && UserUtils.isModOrAdmin(user)) {
            throw new NotOwnerOfEntityException();
        }

        if (request.getDescription() != null) {
            announcement.setDescription(request.getDescription());
        }
        if (request.getPhotos() != null) {
            announcement.setPhotos(request.getPhotos().stream().map(fileService::storeFile).toList());
        }
        if (request.getTitle() != null) {
            announcement.setTitle(request.getTitle());
        }
        if (request.getPrice() != null) {
            announcement.setPrice(request.getPrice());
        }
        if (request.getIsTakeType() != null) {
            announcement.setIsTakeType(request.getIsTakeType());
        }
        if (request.getCategoryId() != null) {
            announcement.setCategory(
                    categoryRepository.findById(request.getCategoryId())
                            .orElseThrow(() -> new EntityNotFoundException(Category.class)));
        }

        if (StringUtils.isNotBlank(request.getNewOwnerId())) {
            announcement
                    .setOwner(userRepository
                            .findById(userId)
                            .orElseThrow(() -> new EntityNotFoundException("New owner not found")));
        }

        return AnnouncementResponse.from(
                announcementRepository
                        .save(announcement));
    }

    @Override
    public AnnouncementResponse get(String id) throws EntityNotFoundException {

        return AnnouncementResponse.from(
                announcementRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException(Announcement.class)));
    }

    @Override
    public List<AnnouncementResponse> getAll(AllAnnouncementRequest request) {
        Stream<Announcement> stream = announcementSpecialRepository.findByNullableArgs(
                request.getMinLongitude(),
                request.getMaxLongitude(),
                request.getMinLatitude(),
                request.getMaxLatitude(),
                request.getIsTakenType(),
                request.getMaxPrice(),
                request.getCategoryId(),
                request.getSpeciesId(),
                request.getIsOrganization()
        );
        if (request.getLimit() != null) {
            return stream
                    .limit(request.getLimit())
                    .map(AnnouncementResponse::from)
                    .toList();
        }

        return stream
                .map(AnnouncementResponse::from)
                .toList();
    }

    @Override
    public List<AnnouncementResponse> getAll() {
        Stream<Announcement> stream = StreamSupport.stream(announcementRepository
                .findAll().spliterator(), false);

        return stream
                .map(AnnouncementResponse::from)
                .toList();
    }

    @Override
    public void delete(String announcementId, String userId) throws EntityNotFoundException, NotOwnerOfEntityException {
        Announcement announcement = announcementRepository
                .findById(announcementId)
                .orElseThrow(() -> new EntityNotFoundException("Announcement not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        if (!user.equals(announcement.getOwner()) && UserUtils.isModOrAdmin(user)) {
            throw new NotOwnerOfEntityException();
        }
        announcementRepository.deleteById(announcementId);
    }


}
