package lv.venta.spring_seminar_6;

import lv.venta.spring_seminar_6.model.*;
import lv.venta.spring_seminar_6.repo.ICourseRepo;
import lv.venta.spring_seminar_6.repo.IGradeRepo;
import lv.venta.spring_seminar_6.repo.IProfessorRepo;
import lv.venta.spring_seminar_6.repo.IStudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSeminar6Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSeminar6Application.class, args);
	}

	@Bean
	public CommandLineRunner testDatabaseLayer(
			IStudentRepo studRepo,
			IGradeRepo gradeRepo,
			IProfessorRepo professorRepo,
			ICourseRepo courseRepo
	) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				Professor pr1 = new Professor("Marcis", "Naktins", Degree.mg);
				Professor pr2 = new Professor("Karina", "Skirmante", Degree.mg);
				professorRepo.save(pr1);
				professorRepo.save(pr2);

				Student st1 = new Student("Janis", "Berzins");
				Student st2 = new Student("Liga", "Jauka");
				studRepo.save(st1);
				studRepo.save(st2);

				Course c1 = new Course("Programesana timekli JAVA", 4, pr2);
				Course c2 = new Course("LAN sistemas", 2, pr1);
				courseRepo.save(c1);
				courseRepo.save(c2);

				gradeRepo.save(new Grade(st1, c1, 8));//Janis nopelnīja 8 JAVA
				gradeRepo.save(new Grade(st1, c2, 3));//Janis nopelnīja 3 LAN
				gradeRepo.save(new Grade(st2, c1, 9));//Liga nopelnīja 9 JAVA
				gradeRepo.save(new Grade(st2, c2, 4));//Liga nopelnīja 4 LAN

				//TODO uztaisīt servisu ar sekojošu funkcionalitāti
				//selectGradesByStudent() - return all grades of specific student;
				//selectCoursesByStudent() - return all courses where specific student is
				//involved;
				//selectCoursesByProfessor() - return all courses of specific professor;
				//calculateAVGGradeInCourse() - return average grade in specific course;

			}
		};
	}


}
