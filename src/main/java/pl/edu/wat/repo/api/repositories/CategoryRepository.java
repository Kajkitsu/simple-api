package pl.edu.wat.repo.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.repo.api.entities.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

}
