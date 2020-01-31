package tn.project.manage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.project.manage.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task,Long> {

}
