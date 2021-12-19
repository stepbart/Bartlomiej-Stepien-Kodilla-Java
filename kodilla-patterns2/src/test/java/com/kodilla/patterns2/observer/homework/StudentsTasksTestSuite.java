package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.forum.ForumTopic;
import com.kodilla.patterns2.observer.forum.ForumUser;
import com.kodilla.patterns2.observer.forum.JavaHelpForumTopic;
import com.kodilla.patterns2.observer.forum.JavaToolsForumTopic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentsTasksTestSuite {

    @Test
    public void testUpdate() {
        // Given
        Mentor mentor1 = new Mentor("Jan Tomaszewski");
        Mentor mentor2 = new Mentor("Karol Kowalski");

        Task task1 = new Task("Budujemy fasadę");
        Task task2 = new Task("Dekorujemy pizzę");
        Task task3 = new Task("Dodajemy logowanie");
        Task task4 = new Task("Kolejki z zadaniami");

        StudentsTasks studentsTasks1 = new StudentsTasks(mentor1);
        StudentsTasks studentsTasks2 = new StudentsTasks(mentor2);

        // When
        studentsTasks1.addTask(task1);
        studentsTasks1.addTask(task2);
        studentsTasks1.addTask(task3);
        studentsTasks1.addTask(task4);

        studentsTasks2.addTask(task1);

        // Then
        assertEquals(4, studentsTasks1.getTasks().size());
        assertEquals(1, studentsTasks2.getTasks().size());
    }
}
