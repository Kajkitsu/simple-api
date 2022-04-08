package pl.edu.wat.repo.api.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.repo.api.dtos.request.AllAnnouncementRequest;
import pl.edu.wat.repo.api.dtos.request.AnnouncementRequest;
import pl.edu.wat.repo.api.dtos.request.AnnouncementUpdateRequest;
import pl.edu.wat.repo.api.exceptions.EntityNotFoundException;
import pl.edu.wat.repo.api.exceptions.NotOwnerOfEntityException;
import pl.edu.wat.repo.api.security.AuthenticationFacade;
import pl.edu.wat.repo.api.services.AnnouncementService;
import pl.edu.wat.repo.api.services.UserDetailsImpl;

@RestController
@CrossOrigin
@RequestMapping("/api/announcement")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@SecurityRequirement(name = "bearerAuth")
public class AnnouncementController {

    AnnouncementService announcementService;
    AuthenticationFacade authenticationFacade;

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public ResponseEntity<?> add(@RequestBody AnnouncementRequest announcementRequest) {
        UserDetailsImpl userDetails = authenticationFacade.getUserDetails();
        try {
            return ResponseEntity.ok(announcementService.add(announcementRequest, userDetails.getId()));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('USER')")
    @PatchMapping
    public ResponseEntity<?> update(@RequestBody AnnouncementUpdateRequest announcementRequest) {
        UserDetailsImpl userDetails = authenticationFacade.getUserDetails();
        try {
            return ResponseEntity.ok(announcementService.update(announcementRequest, userDetails.getId()));
        } catch (NotOwnerOfEntityException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        try {
            return ResponseEntity.ok(announcementService.get(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("all")
    public ResponseEntity<?> getAll(@RequestBody(required = false) AllAnnouncementRequest request) {
        if (request == null) {
            return ResponseEntity.ok(announcementService.getAll());
        }
        return ResponseEntity.ok(announcementService.getAll(request));
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        UserDetailsImpl userDetails = authenticationFacade.getUserDetails();
        try {
            announcementService.delete(id, userDetails.getId());
            return new ResponseEntity<>("Deleted", HttpStatus.GONE);
        } catch (NotOwnerOfEntityException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
