package dev.rokasrozga.dts_developer_challenge.repository;

import dev.rokasrozga.dts_developer_challenge.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
