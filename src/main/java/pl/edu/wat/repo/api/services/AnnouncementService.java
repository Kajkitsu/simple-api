package pl.edu.wat.repo.api.services;

import java.util.List;
import pl.edu.wat.repo.api.dtos.request.AllAnnouncementRequest;
import pl.edu.wat.repo.api.dtos.request.AnnouncementRequest;
import pl.edu.wat.repo.api.dtos.request.AnnouncementUpdateRequest;
import pl.edu.wat.repo.api.dtos.response.AnnouncementResponse;
import pl.edu.wat.repo.api.exceptions.EntityNotFoundException;
import pl.edu.wat.repo.api.exceptions.NotOwnerOfEntityException;

public interface AnnouncementService {

    AnnouncementResponse add(AnnouncementRequest announcementRequest, String userId) throws EntityNotFoundException;

    AnnouncementResponse update(AnnouncementUpdateRequest request, String userId) throws NotOwnerOfEntityException, EntityNotFoundException;

    AnnouncementResponse get(String id) throws EntityNotFoundException;

    List<AnnouncementResponse> getAll(AllAnnouncementRequest request);

    List<AnnouncementResponse> getAll();

    void delete(String announcementId, String userId) throws EntityNotFoundException, NotOwnerOfEntityException;
}
