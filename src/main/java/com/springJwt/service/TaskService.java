package com.springJwt.service;

import com.springJwt.dto.TaskDto;
import com.springJwt.model.Task;
import com.springJwt.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    //    Create New Task
    public String createTask(TaskDto taskDto) {
        Optional<Task> optionalTask = repository.findByTitle(taskDto.getTitle());

        if (optionalTask.isPresent()) {
            return "1"; // task already have

        }else{
            Task task = new Task();
            task.setTitle(taskDto.getTitle());
            task.setDescription(taskDto.getDescription());
            task.setStatus(taskDto.getStatus());

            Task savedTask = repository.save(task);

            // Check if task is created by verifying if it has a non-null ID
            if (savedTask != null) {
                return "2"; // task Successfully
            }
        }

        return "3"; // not Functioning
    }

    // Update The Task
    public String updateTask(Long id, TaskDto taskDto) {
        // Check if task with the given ID exists in the database
        Optional<Task> optionalTask = repository.findById(Math.toIntExact(id));

        if (optionalTask.isPresent()) {
            // If task exists, update its details
            Task task = optionalTask.get();
            task.setTitle(taskDto.getTitle());
            task.setDescription(taskDto.getDescription());
            task.setStatus(taskDto.getStatus());

            // Save the updated task
            repository.save(task);

            // Return success response
            return "2"; // task Successfully

        } else {
            // If task does not exist, return failure response
            return "4"; // not found
        }
    }

    // Delete The Task
    public String deleteTask(Long id) {
        // Check if the task with the given ID exists
        Optional<Task> optionalTask = repository.findById(Math.toIntExact(id));

        if (optionalTask.isPresent()) {
            // If task exists, delete it
            repository.deleteById(Math.toIntExact(id));
            return "2"; // task Successfully
        } else {
            // If task does not exist, return failure response
            return "4"; // not found
        }
    }

    // Fetch tasks by status
    public List<Task> getTasksByStatus(String status) {
        return repository.findByStatus(status);
    }

    //Fetch All Tasks
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Optional<Task> getTaskByID(Long id) {
        // Check if the task with the given ID exists in the database
        Optional<Task> optionalTask = repository.findById(Math.toIntExact(id));

        if (optionalTask.isPresent()) {
            // Return the found task
            return optionalTask;
        } else {
            // Return an empty Optional if the task is not found
            return Optional.empty(); // No need to return "4" or a string
        }
    }

}
