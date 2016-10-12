package net.proselyte.springsecurityapp.controller;

import net.proselyte.springsecurityapp.model.Project;
import net.proselyte.springsecurityapp.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Михаил on 25.09.2016.
 */

@Controller
public class ProjectController {
    private ProjectService projectService;

    @Autowired(required = true)
    @Qualifier(value = "projectService")
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }



    @RequestMapping(value = "projects", method = RequestMethod.GET)
    public String listProjects(Model model){
        model.addAttribute("project", new Project());
        model.addAttribute("listProjects", this.projectService.listProjects());

        return "projects";
    }

    @RequestMapping(value = "/projects/add", method = RequestMethod.POST)
    public String addProject(@ModelAttribute("project") Project project){
        if(project.getID() == null){
            this.projectService.addProject(project);
        }else {
            this.projectService.updateProject(project);
        }

        return "redirect:/projects";
    }

    @RequestMapping("/projects/remove/{id}")
    public String removeProject(@PathVariable("id") Long id){
        this.projectService.removeProject(id);

        return "redirect:/projects";
    }

    @RequestMapping("/projects/edit/{id}")
    public String editProject(@PathVariable("id") Long id, Model model){
        model.addAttribute("project", this.projectService.getProjectById(id));
        // model.addAttribute("task", this.taskService.getTaskById(id));

        model.addAttribute("listProjects", this.projectService.listProjects());

        return "projects";
    }

    /*@RequestMapping("projectdata/{id}")
    public String projectData(@PathVariable("id") Long id, Model model){
        model.addAttribute("project", this.projectService.getProjectById(id));

        return "projectdata";
    }*/
}
