package lv.venta.spring_seminar_6.controller;

import lv.venta.spring_seminar_6.repo.ICourseRepo;
import lv.venta.spring_seminar_6.service.ICourseFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/course/filter")
public class CourseFilterController {

    @Autowired
    private ICourseFilterService courseFilterService;

    @GetMapping("/student")  // localhost:8080/course/filter/student?id=2
    public String getCourseFilterStudentById(
            @RequestParam("id") int id,
            Model model
    ){
        try {
            model.addAttribute("courses", courseFilterService.selectCoursesByStudentId(id));
            return "show-all-course-page";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/professor")  // localhost:8080/course/filter/student?id=2
    public String getCourseFilterProfessorById(
            @RequestParam("id") int id,
            Model model
    ){
        try {
            model.addAttribute("courses", courseFilterService.selectCoursesByProfessorId(id));
            return "show-all-course-page";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/cp")  // localhost:8080/course/filter/student?id=2
    public String getCourseFilterByCp(
            @RequestParam("cp") int cp,
            Model model
    ){
        try {
            model.addAttribute("courses", courseFilterService.selectCoursesByCP(cp));
            return "show-all-course-page";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "error-page";
        }
    }
}
