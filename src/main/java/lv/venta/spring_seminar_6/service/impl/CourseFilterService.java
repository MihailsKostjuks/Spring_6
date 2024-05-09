package lv.venta.spring_seminar_6.service.impl;

import lv.venta.spring_seminar_6.model.Course;
import lv.venta.spring_seminar_6.model.Professor;
import lv.venta.spring_seminar_6.repo.ICourseRepo;
import lv.venta.spring_seminar_6.repo.IProfessorRepo;
import lv.venta.spring_seminar_6.repo.IStudentRepo;
import lv.venta.spring_seminar_6.service.ICourseFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseFilterService implements ICourseFilterService {

    @Autowired
    private ICourseRepo courseRepo;

    @Autowired
    private IStudentRepo studentRepo;

    @Autowired
    private IProfessorRepo profRepo;

    @Override
    public ArrayList<Course> selectCoursesByStudentId(long id) throws Exception {

        if(id <= 0) throw new Exception("Id should be positive");

        if(!studentRepo.existsById(id))
            throw new Exception("There is no student with this id (" + id + ")");


        ArrayList<Course> result =
                courseRepo.findByGradesStudentIds(id);

        if(result.isEmpty())
            throw new Exception("There is no course linked to this student");

        return result;
    }

    @Override
    public ArrayList<Course> selectCoursesByProfessorId(long id) throws Exception {
        if(id <= 0) throw new Exception("Id should be positive");

        if(!profRepo.existsById(id))
            throw new Exception("There is no professor with this id (" + id + ")");


        ArrayList<Course> result =
                courseRepo.findByProfessorsIdp(id);

        if(result.isEmpty())
            throw new Exception("There is no course linked to this professor");

        return result;
    }

    @Override
    public ArrayList<Course> selectCoursesByCP(int cp) throws Exception {
        if(cp < 0 || cp > 20) throw new Exception("Cp should be positive and less than 21");

        ArrayList<Course> result =
                courseRepo.findByCp(cp);

        if(result.isEmpty())
            throw new Exception("There is no course with this CP");

        return result;
    }

}
