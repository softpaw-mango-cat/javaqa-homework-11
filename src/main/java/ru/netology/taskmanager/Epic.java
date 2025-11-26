package ru.netology.taskmanager;

public class Epic extends Task {

    protected String[] subtask;

    public Epic(int id, String[] subtask) {
        super(id);
        this.subtask = subtask;
    }

    public String[] getSubtask() {
        return subtask;
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
        for (String s : subtask) {
            // добавила toLowerCase() для регистронезависимости
            if (s.toLowerCase().contains(query.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
