package tn.project.manage.dto;


import java.util.Collection;

import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;
import tn.project.manage.model.Task;

@Mapper
public interface TaskMapper {

	@Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
	TaskDto asTaskDto(Task task);

	@Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
	Task asTask(TaskDto taskDto);
	
	@Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
	public Collection<TaskDto> asTaskCollectionDTO(Collection<Task> tasks);

}

