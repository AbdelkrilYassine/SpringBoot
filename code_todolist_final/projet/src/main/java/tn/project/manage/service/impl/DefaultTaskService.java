package tn.project.manage.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.project.manage.dto.TaskDto;
import tn.project.manage.dto.TaskMapper;
import tn.project.manage.dto.Util;
import tn.project.manage.model.Priority;
import tn.project.manage.model.Task;
import tn.project.manage.repository.TaskRepository;
import tn.project.manage.service.TaskService;

@Service
public class DefaultTaskService implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private TaskMapper taskMapper;

	@Override
	public TaskDto createTask(TaskDto taskDto) {
		Task task = taskMapper.asTask(taskDto);
		taskRepository.save(task);
		return taskMapper.asTaskDto(task);
	}

	@Override
	public void updateTask(TaskDto taskDto) {
		Optional<Task> optional = taskRepository.findById(taskDto.getId());
		if (optional.isPresent()) {
			Task task = optional.get();
			task.setDescription(taskDto.getDescription());
			task.setDueDate(taskDto.getDueDate());
			task.setPriority(Priority.valueOf(taskDto.getPriority().name()));
			task.setTitle(taskDto.getTitle());
			taskRepository.save(task);
		}
	}

	@Override
	public TaskDto findTaskById(long taskId) {
		Optional<Task> optional = taskRepository.findById(taskId);
		if (optional.isPresent()) {
			return taskMapper.asTaskDto(optional.get());
		}
		return null;
	}

	@Override
	public Iterable<TaskDto> findAllTasks() {
		Iterable<Task> tasks = taskRepository.findAll();
		return taskMapper.asTaskCollectionDTO(Util.toList(tasks));
	}

	@Override
	public void deleteTaskDtoById(long taskId) {
		taskRepository.deleteById(taskId);
	}

}
