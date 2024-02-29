package org.belotelov.hw05.repository;

import org.belotelov.hw05.model.Status;
import org.belotelov.hw05.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TasksRepository extends JpaRepository<Task, Long> {
    public List<Task> findByStatus(Status status);

}
