package lv.venta.spring_seminar_6.repo;

import lv.venta.spring_seminar_6.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.spring_seminar_6.model.Grade;

import java.util.ArrayList;

public interface IGradeRepo extends CrudRepository<Grade, Long>{
    ArrayList<Grade> findByStudentIds(long id);

    ArrayList<Grade> findByGrvalueLessThan(int i);

    @Query(nativeQuery = true, value="SELECT AVG(Grvalue) FROM grade_table WHERE idc=?")
    float calculateAVGForCourse(long idc);
}
