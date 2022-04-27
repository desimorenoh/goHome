package org.factoriaf5.gohome.repositories;

import org.factoriaf5.gohome.models.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository {

    public CategoryRepository() {
    }

    public List<Category> findAll() {
        return List.of(
                new Category("1"),
                new Category("2"),
                new Category("3"),
                new Category("4"),
                new Category("5")

        );
    }
}