package lv.venta.spring_seminar_6.controller;

import lv.venta.spring_seminar_6.service.IGradeFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/grade/filter")
public class GradeFilterController {
    @Autowired
    private IGradeFilterService gradeFilterService;

    @GetMapping("/student")  // localhost:8080/grade/filter/student?id=2
    public String getGradeFilterStudentById(
            @RequestParam("id") int id,
            Model model
    ){
        try {
            model.addAttribute("grades", gradeFilterService.selectGradesByStudentId(id));
            return "show-all-grade-page";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/failing")  // localhost:8080/grade/filter/failing
    public String getGradeFilterByFailing(
            Model model
    ){
        try {
            model.addAttribute("grades", gradeFilterService.selectFailingGrades());
            return "show-all-grade-page";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "error-page";
        }
    }

    @GetMapping("/avg_in_course")  // localhost:8080/grade/filter/avg_in_course?id=2
    public String getGradeAvgByCourseId(
            @RequestParam("id") int id,
            Model model
    ) {
        try {
            model.addAttribute("gr_value", gradeFilterService.calculateAVGGradeInCourseId(id));
            return "show-grade-value-page";
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
            return "error-page";
        }
    }
}
