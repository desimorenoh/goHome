package org.factoriaf5.gohome.repositories;

import org.factoriaf5.gohome.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository <Client, Long> {

}
