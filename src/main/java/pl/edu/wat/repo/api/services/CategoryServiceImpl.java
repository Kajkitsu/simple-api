package pl.edu.wat.repo.api.services;

import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.repo.api.dtos.request.CategoryRequest;
import pl.edu.wat.repo.api.dtos.request.CategoryUpdateRequest;
import pl.edu.wat.repo.api.dtos.response.CategoryResponse;
import pl.edu.wat.repo.api.entities.Category;
import pl.edu.wat.repo.api.exceptions.EntityNotFoundException;
import pl.edu.wat.repo.api.repositories.CategoryRepository;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;

    @Override
    public Optional<CategoryResponse> add(CategoryRequest request) {
        return Optional.of(
                        categoryRepository.save(
                                Category.builder().name(request.getName()).build()))
                .map(
                        it -> new CategoryResponse(it.getId(), it.getName()));
    }

    @Override
    public Optional<CategoryResponse> update(CategoryUpdateRequest request) throws EntityNotFoundException {
        return Optional.of(
                        categoryRepository.save(
                                categoryRepository.findById(request.getId())
                                        .orElseThrow(() -> new EntityNotFoundException("Category not found"))
                                        .toBuilder()
                                        .name(request.getName())
                                        .build()))
                .map(
                        it -> new CategoryResponse(it.getId(), it.getName()));
    }

    @Override
    public void delete(String id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryResponse> getAll() {
        return categoryRepository.findAll().stream()
                .map(it -> new CategoryResponse(it.getId(), it.getName()))
                .toList();
    }

    @Override
    public CategoryResponse get(String id) throws EntityNotFoundException {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        return new CategoryResponse(category.getId(), category.getName());
    }
}
