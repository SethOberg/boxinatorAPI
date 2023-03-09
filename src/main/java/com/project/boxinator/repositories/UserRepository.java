package com.project.boxinator.repositories;

import com.project.boxinator.models.BoxinatorUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<BoxinatorUser, Integer> {
}
