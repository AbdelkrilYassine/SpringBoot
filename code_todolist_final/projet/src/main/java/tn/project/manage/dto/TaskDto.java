package tn.project.manage.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
	
	private Long id;

	private String title;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dueDate;

	private String description;

	private PriorityDto priority;
	
}
