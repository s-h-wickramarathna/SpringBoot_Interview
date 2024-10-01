package com.springJwt.repository;

import com.springJwt.model.Task;
import com.springJwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    Optional<Task> findById(Integer id);
    Optional<Task> findByTitle(String title);
    List<Task> findByStatus(String status);

}
