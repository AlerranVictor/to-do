package dio.to_do.service.impl;

import dio.to_do.domain.model.TaskList;
import dio.to_do.domain.repository.TaskListRepository;
import dio.to_do.service.TaskListService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository){
        this.taskListRepository = taskListRepository;
    }

    @Override
    public TaskList findById(Integer id) {
        return taskListRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public TaskList create(TaskList tlToCreate) {
        return taskListRepository.save(tlToCreate);
    }
}
