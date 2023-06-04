package com.alash.todolist.repository;

import com.alash.todolist.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Integer> {

    TodoList findByName(String name);

    List<TodoList> findByUsername(String userName);
}
