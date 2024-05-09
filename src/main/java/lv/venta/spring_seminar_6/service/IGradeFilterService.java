package lv.venta.spring_seminar_6.service;

import lv.venta.spring_seminar_6.model.Grade;

import java.util.ArrayList;

public interface IGradeFilterService {
    public abstract ArrayList<Grade> selectGradesByStudentId(long id) throws Exception;
    public abstract ArrayList<Grade> selectFailingGrades() throws Exception;
    public abstract float calculateAVGGradeInCourseId(long id) throws Exception;

}
