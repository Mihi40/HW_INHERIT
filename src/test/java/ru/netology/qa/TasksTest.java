package ru.netology.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldFindQuerySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Задача");

        Boolean expected = true;
        Boolean actual = simpleTask.matches("Задача");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryEpic() {

        String[] subtasks = {"Яйца", "Хлеб", "Молоко"};
        Epic epic = new Epic(55, subtasks);


        Boolean expected = true;
        Boolean actual = epic.matches("Мол");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryMeeting() {

        Meeting meeting = new Meeting(
                555,
                "Приложение",
                "Философия",
                "Во вторник после обеда"
        );
        Boolean expected = true;
        Boolean actual = meeting.matches("Фил");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldFindQueryMeetingTopic() {

        Meeting meeting = new Meeting(
                555,
                "Приложение",
                "Философия",
                "Во вторник после обеда"
        );
        Boolean expected = true;
        Boolean actual = meeting.matches("лож");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldNotFindQuerySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Задача");

        Boolean expected = false;
        Boolean actual = simpleTask.matches("Молоко");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindQueryEpic() {

        String[] subtasks = {"Яйца", "Хлеб", "Молоко"};
        Epic epic = new Epic(55, subtasks);


        Boolean expected = false;
        Boolean actual = epic.matches("Шоколад");
        Assertions.assertEquals(expected, actual);
    }
}
