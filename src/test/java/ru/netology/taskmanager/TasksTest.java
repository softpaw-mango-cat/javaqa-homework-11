package ru.netology.taskmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldFindMatchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean result = simpleTask.matches("позвонить");
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldNotFindMatchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean result = simpleTask.matches("Кошка");
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldFindMatchEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean result = epic.matches("хлеб");
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldNotFindMatchEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean result = epic.matches("кошка");
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldFindMatchMeeting() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean result = meeting.matches("выкатка");
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldNotFindMatchMeeting() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean result = meeting.matches("Кошка");
        Assertions.assertFalse(result);
    }
}
