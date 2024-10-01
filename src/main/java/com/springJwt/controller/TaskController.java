package com.springJwt.controller;

import com.springJwt.ExceptionHandler.TaskException;
import com.springJwt.dto.TaskDto;
import com.springJwt.model.Task;
import com.springJwt.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Create the Task
    @PostMapping(value = "/create")
    public ResponseEntity<String> createTask(@RequestBody @Valid TaskDto taskDto) {
        try {
            // Call service layer to save the task
            // If task is saved successfully, return 201 Created status with the response
            return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(taskDto));

        } catch (TaskException e) {
            // Handle specific custom exception (e.g., validation failure, task creation issue)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Task creation failed: " + e.getMessage());

        } catch (Exception e) {
            // Handle any unexpected errors, return 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

    // update the Task
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateTask(@RequestBody @Valid TaskDto taskDto,@PathVariable(name = "id")Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(taskService.updateTask(id,taskDto));

        } catch (TaskException e) {
            // Handle specific custom exception (e.g., validation failure, task creation issue)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Task Update failed: " + e.getMessage());

        } catch (Exception e) {
            // Handle any unexpected errors, return 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

    // Delete The Task
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable(name = "id")Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(taskService.deleteTask(id));

        } catch (TaskException e) {
            // Handle specific custom exception (e.g., validation failure, task creation issue)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Task Update failed: " + e.getMessage());

        } catch (Exception e) {
            // Handle any unexpected errors, return 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

    // Fetch Task By Status
    @GetMapping("/search/{status}")
    public ResponseEntity<?> getTasksByStatus(@PathVariable String status) {
        try {
            // Get tasks by status
            List<Task> tasks = taskService.getTasksByStatus(status);
            if (tasks.isEmpty()) {
                return ResponseEntity.noContent().build();  // Return 204 No Content if no tasks found
            }
            return ResponseEntity.ok(tasks);  // Return 200 OK with the list of tasks

        } catch (TaskException e) {
            // Handle specific custom exception (e.g., validation failure, task creation issue)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Task Search failed: " + e.getMessage());

        } catch (Exception e) {
            // Handle any unexpected errors, return 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

}
