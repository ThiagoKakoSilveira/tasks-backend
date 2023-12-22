package br.ce.wcaquino.taskbackend.controller;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.stub.TaskStub;
import br.ce.wcaquino.taskbackend.utils.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;

public class TaskControllerTest {

    @Mock
    private TaskRepo taskRepo;
    @InjectMocks
    private TaskController taskController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void naoDeveSalvarTarefaSemDescricao() {
        Task withoutDescription = TaskStub.withoutDescription();
        try {
            taskController.save(withoutDescription);
            Assert.fail("Exception not thrown");
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the task description",e.getMessage());
            Mockito.verify(taskRepo, never())
                    .save(withoutDescription);
        }
    }

    @Test
    public void naoDeveSalvarTarefaSemData() {
        Task taskWithoutDueDate = TaskStub.withoutDueDate();
        try {
            taskController.save(taskWithoutDueDate);
            Assert.fail("Exception not thrown");
        } catch (ValidationException e) {
            Assert.assertEquals("Fill the due date",e.getMessage());
            Mockito.verify(taskRepo, never())
                    .save(taskWithoutDueDate);
        }
    }

    @Test
    public void naoDeveSalvarTarefaComDataAntiga() {
        Task taskYesterday = TaskStub.datedYesterday();
        try {
            taskController.save(taskYesterday);
            Assert.fail("Exception not thrown");
        } catch (ValidationException e) {
            Assert.assertEquals("Due date must not be in past",e.getMessage());
            Mockito.verify(taskRepo, never())
                    .save(taskYesterday);
        }
    }

    @Test
    public void deveSalvarTarefa() throws ValidationException {
        Task allrightTask = TaskStub.allright();
        taskController.save(allrightTask);
        Mockito.verify(taskRepo, only())
                .save(allrightTask);
    }
}