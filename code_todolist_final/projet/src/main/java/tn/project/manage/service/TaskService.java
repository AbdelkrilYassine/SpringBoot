package tn.project.manage.service;

import tn.project.manage.dto.TaskDto;

public interface TaskService {

	public TaskDto createTask(TaskDto taskDto);

	public void updateTask(TaskDto taskDto);

	public TaskDto findTaskById(long taskId);

	public Iterable<TaskDto> findAllTasks();

	public void deleteTaskDtoById(long taskId);
}
