package ru.wca.swa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.wca.swa.model.Task;
import ru.wca.swa.service.TaskService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {
    public static final int MAX_TASKS_PER_PAGE = 5;
    private TaskService taskService;
    private int currentPage = 1;
    private int maxNumberOfPages;

    @Autowired
    @Qualifier(value = "taskService")
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "tasks", method = RequestMethod.GET)
    public String listTasks(Model model) {
        List<Task> allTasks = taskService.listTasks();
        List<Task> tasksToDisplay = new ArrayList<>();

        if (allTasks.size() % MAX_TASKS_PER_PAGE == 0)
            maxNumberOfPages = allTasks.size() / MAX_TASKS_PER_PAGE;
        else
            maxNumberOfPages = allTasks.size() / MAX_TASKS_PER_PAGE + 1;

        for (int i = (currentPage - 1) * MAX_TASKS_PER_PAGE;
             i < (currentPage - 1) * MAX_TASKS_PER_PAGE + MAX_TASKS_PER_PAGE && i < allTasks.size();
             i++) {
            tasksToDisplay.add(allTasks.get(i));
        }

        model.addAttribute("task", new Task());
        model.addAttribute("pageNumber", currentPage);
        model.addAttribute("listTasks", tasksToDisplay);

        return "tasks";
    }

    @RequestMapping(value = "tasks/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("task") Task task) {
        if (task.getId() == 0) {
            this.taskService.add(task);
        } else {
            this.taskService.update(task);
        }

        return "redirect:/tasks";
    }

    @RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id") int id) {
        this.taskService.remove(id);

        return "redirect:/tasks";
    }

    @RequestMapping("edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("task", this.taskService.get(id));
        model.addAttribute("listTasks", this.taskService.listTasks());

        return "tasks";
    }

    @RequestMapping(value = "taskdata")
    public String taskData(@RequestParam("id") int id, Model model) {
        model.addAttribute("task", this.taskService.get(id));

        return "taskdata";
    }

    @RequestMapping(value = "nextPage", method = RequestMethod.GET)
    public String nextPage(Model model) {
        List<Task> allTasks = taskService.listTasks();
        if (++currentPage > maxNumberOfPages)
            currentPage = maxNumberOfPages;
        List<Task> tasksToDisplay = new ArrayList<>(MAX_TASKS_PER_PAGE);

        for (int i = (currentPage - 1) * MAX_TASKS_PER_PAGE;
             i < (currentPage - 1)*MAX_TASKS_PER_PAGE + MAX_TASKS_PER_PAGE && i < allTasks.size();
             i++) {
            tasksToDisplay.add(allTasks.get(i));
        }

        model.addAttribute("task", new Task());
        model.addAttribute("pageNumber", currentPage);
        model.addAttribute("listTasks", tasksToDisplay);

        return "tasks";
    }

    @RequestMapping(value = "previousPage", method = RequestMethod.GET)
    public String previousPage(Model model) {
        List<Task> allTasks = taskService.listTasks();
        if (--currentPage < 1)
            currentPage = 1;
        List<Task> tasksToDisplay = new ArrayList<>(MAX_TASKS_PER_PAGE);

        for (int i = (currentPage - 1) * MAX_TASKS_PER_PAGE;
             i < (currentPage - 1) * MAX_TASKS_PER_PAGE + MAX_TASKS_PER_PAGE && i < allTasks.size();
             i++) {
            tasksToDisplay.add(allTasks.get(i));
        }

        model.addAttribute("task", new Task());
        model.addAttribute("pageNumber", currentPage);
        model.addAttribute("listTasks", tasksToDisplay);

        return "tasks";
    }
}
