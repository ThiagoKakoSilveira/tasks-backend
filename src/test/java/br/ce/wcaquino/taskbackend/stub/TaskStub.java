package br.ce.wcaquino.taskbackend.stub;

import br.ce.wcaquino.taskbackend.model.Task;

import java.time.LocalDate;

public class TaskStub {

    public static Task allright() {
        Task task = new Task();
        task.setDueDate(LocalDate.now());
        task.setTask("Descricao");
        return task;
    }

    public static Task withoutDescription() {
        Task task = new Task();
        task.setDueDate(LocalDate.now());
        return task;
    }

    public static Task datedYesterday() {
        Task task = new Task();
        task.setTask("Descricao");
        task.setDueDate(LocalDate.now().minusDays(1));
        return task;
    }

    public static Task withoutDueDate() {
        Task task = new Task();
        task.setTask("Descricao");
        return task;
    }
}
