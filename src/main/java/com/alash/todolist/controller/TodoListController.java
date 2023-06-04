package com.alash.todolist.controller;

import com.alash.todolist.dto.TodoListRequest;
import com.alash.todolist.entity.TodoList;
import com.alash.todolist.service.TodoListService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@OpenAPIDefinition(
        info = @Info(
                title = "Spring boot todo_list application",
                description = "Spring boot TodoList Application REST APIs Implementation",
                version = "v1.0",
                contact = @Contact(
                        name = "Oyin",
                        email = "oyinlolaalasho@gmail.com",
                        url = "https://github.com/Alash95"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://github.com/Alash95"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring boot TodoList implementation",
                url = "https://github.com/Alash95"
        )
)
@Tag(
        name = "TodoList service REST APIs/Endpoint",
        description = "Endpoints for manipulating TodoList items"
)

public class TodoListController {

    private final TodoListService todoListService;
    private final Logger logger = LoggerFactory.getLogger(TodoListController.class);

    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    //POST
    @PostMapping("/add_todo")
    public TodoList addTodoItem(@RequestBody TodoList todoList) {
        logger.info("TodoList object {}", todoList.toString());
        return todoListService.saveList(todoList);
    }

    @PostMapping("/add_todoItems")
    public List<TodoList> addTodoItems(@RequestBody List<TodoList> todoLists) {
        return todoListService.saveLists(todoLists);
    }

    //GET
    @GetMapping("/todoItems")
    public List<TodoList> getAllTodoItems() {
        return todoListService.getTodoLists();
    }

    @GetMapping("/todoById/{id}")
    public TodoList findTodoById(@PathVariable int id) {
        return todoListService.getListById(id);
    }

    @GetMapping("/todoByName/{name}")
    public TodoList findTodoByName(@PathVariable String name) {
        return todoListService.getListByName(name);
    }

    @GetMapping("/listTodoByUsername/{username}")
    public List<TodoList> findTodoItemsByUsername(@PathVariable String username) {
        return todoListService.getListsForUser(username);
    }

    //PUT
    @PutMapping("/update")
    public TodoList updateTodo(@RequestBody TodoListRequest todoListRequest) {
        System.out.println("UPDATED");
        return todoListService.updateList(todoListRequest);
    }

    //DELETE
    @DeleteMapping("delete/{id}")
    public String deleteCourse(@PathVariable int id) {
        todoListService.deleteList(id);
        return "DELETED SUCCESSFULLY";
    }
}
