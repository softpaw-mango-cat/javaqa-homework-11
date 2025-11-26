package ru.netology.taskmanager;

public class Epic extends Task {

    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    /**
     * Метод, проверяющий подходит ли эта задача поисковому запросу.
     * Эта логика должна быть определена в наследниках, у каждого она будет своя
     *
     * @param query Поисковый запрос
     * @return Ответ на вопрос, подходит ли эта задача под поисковый запрос
     */
    @Override
    public boolean matches(String query) {
        for (String s : subtasks) {
            // добавила toLowerCase() для регистронезависимости
            if (s.toLowerCase().contains(query.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
