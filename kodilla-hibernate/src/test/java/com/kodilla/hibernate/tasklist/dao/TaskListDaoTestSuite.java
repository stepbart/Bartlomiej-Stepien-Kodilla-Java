package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private final String taskListName = "Task to do";

    @Test
    void testTaskListDao() {
        //Given
        TaskList taskList = new TaskList(taskListName,"Tasks to be completed by December");
        taskListDao.save(taskList);


        //When
        List<TaskList> readTask = taskListDao.findByListName(taskListName);

        //Then
        assertEquals(1, readTask.size());

        //CleanUp
        int id = taskList.getId();
        taskListDao.deleteById(id);
    }
}

