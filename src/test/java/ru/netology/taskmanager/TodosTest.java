package ru.netology.taskmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TodosTest {
    private static SimpleTask simpleTask;
    private static Epic epic;
    private static Meeting meeting;
    private static Todos todos;

    @BeforeAll
    public static void setupManager() {
        simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        epic = new Epic(55, subtasks);
        meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }


    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMatch() {
        Task[] expected = {};
        Task[] actual = todos.search("Кот");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchSimpleTask() {
        Task[] expected = {simpleTask};
        Task[] actual = todos.search("позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchEpic() {
        Task[] expected = {epic};
        Task[] actual = todos.search("молоко");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchMeeting() {
        Task[] expected = {meeting};
        Task[] actual = todos.search("банка");
        Assertions.assertArrayEquals(expected, actual);
    }
}
