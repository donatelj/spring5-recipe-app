package guru.springframework.services;

import guru.springframework.domain.Category;

import java.util.Optional;

public interface CategoryService {
    Optional<Category> findByDescription(String description);
}
