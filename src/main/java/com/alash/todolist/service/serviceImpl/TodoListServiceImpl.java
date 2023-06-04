package com.alash.todolist.service.serviceImpl;

import com.alash.todolist.dto.TodoListRequest;
import com.alash.todolist.entity.TodoList;
import com.alash.todolist.repository.TodoListRepository;
import com.alash.todolist.service.TodoListService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListServiceImpl implements TodoListService {

    private final TodoListRepository todoListRepository;
    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }
    @Override
    public TodoList saveList(TodoList todoList) {
        System.out.println(todoList.toString());
        return todoListRepository.save(todoList);
    }

    @Override
    public List<TodoList> saveLists(List<TodoList> todoLists) {
        return todoListRepository.saveAll(todoLists);
    }

    @Override
    public List<TodoList> getTodoLists() {
        return todoListRepository.findAll();
    }

    @Override
    public TodoList getListById(int id) {
        return todoListRepository.findById(id).orElse(null);
    }

    @Override
    public TodoList getListByName(String name) {
        return todoListRepository.findByName(name);
    }

    @Override
    public List<TodoList> getListsForUser(String username) {
        return todoListRepository.findByUsername(username);
    }

    @Override
    public TodoList updateList(TodoListRequest todoListRequest) {

        System.out.println("updates");
        TodoList todoList = todoListRepository.findById(todoListRequest.getId()).orElseThrow();
        if (!todoListRepository.existsById(todoListRequest.getId())){
            return null;
        }
        todoList.setName(todoListRequest.getName());
        todoList.setDescription(todoListRequest.getDescription());
        todoList.setStatus(todoListRequest.getStatus());
        return todoListRepository.save(todoList);
    }

    @Override
    public String deleteList(int id) {
        todoListRepository.deleteById(id);
        return id + " id -> course removed/completed";
    }


}
