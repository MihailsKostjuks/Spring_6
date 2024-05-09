package lv.venta.spring_seminar_6.service;

import lv.venta.spring_seminar_6.model.Course;

import java.util.ArrayList;

public interface ICourseFilterService {
    public abstract ArrayList<Course> selectCoursesByStudentId(long id) throws Exception;
    public abstract ArrayList<Course> selectCoursesByProfessorId(long id) throws Exception;
    public abstract ArrayList<Course> selectCoursesByCP(int cp) throws Exception;
}
