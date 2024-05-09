package lv.venta.spring_seminar_6.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.spring_seminar_6.model.Professor;

import java.util.ArrayList;

public interface IProfessorRepo extends CrudRepository<Professor, Long> {
}
