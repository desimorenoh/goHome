package org.factoriaf5.gohome.repositories;

import org.factoriaf5.gohome.models.GoHome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoHomeRepository extends JpaRepository<GoHome, Long> {
    List<GoHome>findGoHomeByTitleContainingIgnoreCase (String word);

}
