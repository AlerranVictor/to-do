package dio.to_do.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dio.to_do.domain.model.TaskList;

public interface TaskListRepository extends JpaRepository<TaskList, Integer> {
    @Override
    boolean existsById(Integer id);
}
