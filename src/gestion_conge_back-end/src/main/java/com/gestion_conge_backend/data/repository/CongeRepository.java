package com.gestion_conge_backend.data.repository;

import com.gestion_conge_backend.data.entities.CongeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongeRepository extends JpaRepository<CongeEntity,Integer> {
}
