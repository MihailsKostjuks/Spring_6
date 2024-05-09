package lv.venta.spring_seminar_6.repo;

import lv.venta.spring_seminar_6.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface IStudentRepo extends CrudRepository<Student, Long>{
}
