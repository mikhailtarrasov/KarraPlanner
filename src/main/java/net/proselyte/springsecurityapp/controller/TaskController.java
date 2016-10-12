package net.proselyte.springsecurityapp.controller;

import net.proselyte.springsecurityapp.model.Task;
import net.proselyte.springsecurityapp.service.ProjectService;
import net.proselyte.springsecurityapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.swing.*;

/**
 * Created by Михаил on 07.10.2016.
 */

@Controller
public class TaskController {

    private TaskService taskService;

    @Autowired(required = true)
    @Qualifier(value = "taskService")
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    private ProjectService projectService;

    @Autowired(required = true)
    @Qualifier(value = "projectService")
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }



    @RequestMapping(value = "projectdata/{id_proj}", method = RequestMethod.GET)
    public String taskList(@PathVariable("id_proj") Long id_proj, Model model){
        try{
            model.addAttribute("project", this.projectService.getProjectById(id_proj));
            model.addAttribute("listTasks", this.taskService.listTasks(id_proj));
            model.addAttribute("task", new Task());
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при составлении списка задач", JOptionPane.OK_OPTION);
        }

        return "projectdata";
    }

    @RequestMapping(value = "/projectdata/add", method = RequestMethod.POST)
    public String addTask(@ModelAttribute("task") Task task){
        if(task.getID() == null){
            this.taskService.addTask(task);
        }else {
            this.taskService.updateTask(task);
        }

        return "redirect:/projectdata/" + task.getId_project();
    }

    @RequestMapping("projectdata/{id_proj}/remove/{id_task}")
    public String removeTask(@PathVariable("id_task") Long id_task, @PathVariable("id_proj") Long id_proj){
        this.taskService.removeTask(id_task);

        return "redirect:/projectdata/" + id_proj;
    }

    @RequestMapping("/projectdata/{id_proj}/edit/{id_task}")
    public String editTask(@PathVariable("id_proj") Long id_proj, @PathVariable("id_task") Long id_task, Model model){
        //model.addAttribute("project", this.projectService.getProjectById(id_proj));
        model.addAttribute("task", this.taskService.getTaskById(id_task));
        model.addAttribute("listTasks", this.taskService.listTasks(id_proj));

        return "redirect:/projectdata/" + id_proj;
    }
}
