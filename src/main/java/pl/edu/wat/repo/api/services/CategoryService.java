package pl.edu.wat.repo.api.services;

import pl.edu.wat.repo.api.dtos.request.CategoryRequest;
import pl.edu.wat.repo.api.dtos.request.CategoryUpdateRequest;
import pl.edu.wat.repo.api.dtos.response.CategoryResponse;
import pl.edu.wat.repo.api.exceptions.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<CategoryResponse> add(CategoryRequest request);

    Optional<CategoryResponse> update(CategoryUpdateRequest request) throws EntityNotFoundException;

    void delete(String id) throws EntityNotFoundException;

    List<CategoryResponse> getAll();

    CategoryResponse get(String id) throws EntityNotFoundException;
}
