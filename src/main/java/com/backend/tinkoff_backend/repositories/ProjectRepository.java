package com.backend.tinkoff_backend.repositories;

import com.backend.tinkoff_backend.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByEmployerId(long employerId);

    Optional<Project> findByEmployerIdAndName(long employerId, String name);
}
