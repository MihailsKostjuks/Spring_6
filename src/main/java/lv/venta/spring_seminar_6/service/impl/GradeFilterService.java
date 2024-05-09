package lv.venta.spring_seminar_6.service.impl;

import lv.venta.spring_seminar_6.model.Course;
import lv.venta.spring_seminar_6.model.Grade;
import lv.venta.spring_seminar_6.repo.ICourseRepo;
import lv.venta.spring_seminar_6.repo.IGradeRepo;
import lv.venta.spring_seminar_6.repo.IProfessorRepo;
import lv.venta.spring_seminar_6.repo.IStudentRepo;
import lv.venta.spring_seminar_6.service.IGradeFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GradeFilterService implements IGradeFilterService {

    @Autowired
    private ICourseRepo courseRepo;

    @Autowired
    private IStudentRepo studentRepo;

    @Autowired
    private IProfessorRepo professorRepo;

    @Autowired
    private IGradeRepo gradeRepo;

    @Override
    public ArrayList<Grade> selectGradesByStudentId(long id) throws Exception {
        if (id <= 0) throw new Exception("ID cannot be <= 0.");
        if (!studentRepo.existsById(id)) throw new Exception("Student with " + id + " does not exist.");
        ArrayList<Grade> result = gradeRepo.findByStudentIds(id);
        if (result.isEmpty()) throw new Exception("Student with " + id + " has no grades yet.");
        return result;
    }

    @Override
    public ArrayList<Grade> selectFailingGrades() throws Exception {
        if (gradeRepo.count() == 0) throw new Exception("No grades yet");
        ArrayList<Grade> result = gradeRepo.findByGrvalueLessThan(4);
        if (result.isEmpty()) throw new Exception("No failing grades yet.");
        return result;
    }

    @Override
    public float calculateAVGGradeInCourseId(long id) throws Exception {
        if(id <= 0) throw new Exception("Id should be positive");


        if(!courseRepo.existsById(id))
            throw new Exception("There is no course with this id (" + id + ")");

        float result = gradeRepo.calculateAVGForCourse(id);

        return result;
    }
}
