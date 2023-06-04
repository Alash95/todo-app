package com.alash.todolist.service;

import com.alash.todolist.dto.TodoListRequest;
import com.alash.todolist.entity.TodoList;

import java.util.List;

public interface TodoListService {

    TodoList saveList(TodoList todoList);

    List<TodoList> saveLists(List<TodoList> todoLists);

    List<TodoList> getTodoLists();

    TodoList getListById(int id);

    TodoList getListByName(String name);

    List<TodoList> getListsForUser(String username);

    TodoList updateList(TodoListRequest todoListRequest);

    String deleteList(int id);




}
