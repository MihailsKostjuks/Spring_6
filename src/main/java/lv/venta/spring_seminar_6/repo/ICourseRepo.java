package lv.venta.spring_seminar_6.repo;
import lv.venta.spring_seminar_6.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ICourseRepo extends CrudRepository<Course, Long>{

    //pēc noklusējuma ir public abstract
    ArrayList<Course> findByGradesStudentIds(long id);

    ArrayList<Course> findByProfessorsIdp(long id);

    ArrayList<Course> findByCp(int cp);

}
