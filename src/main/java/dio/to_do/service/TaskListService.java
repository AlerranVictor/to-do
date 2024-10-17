package dio.to_do.service;

import dio.to_do.domain.model.TaskList;

public interface TaskListService {
    TaskList findById(Integer id);
    TaskList create(TaskList tlToCreate);
}
