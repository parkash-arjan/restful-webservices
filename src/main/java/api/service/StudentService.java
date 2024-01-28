package api.service;

import api.error.StudentNotFoundException;
import api.model.Course;
import api.model.Instructor;
import api.model.Student;
import api.model.list.StudentList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    List<Instructor> machineLearningInstructors = List.of(
            new Instructor(1, "ML1-Instructor"),
            new Instructor(2, "ML1-Instructor"));
    List<Instructor> deepLearningInstructors = List.of(
            new Instructor(3, "DL1-Instructor"));


    List<Course> studentOneCourses = List.of(
            new Course(1L, "Machine Learning", machineLearningInstructors));

    List<Course> studentTwoCourses = List.of(
            new Course(1L, "Machine Learning", machineLearningInstructors),
            new Course(2L, "Deep Learning", deepLearningInstructors));


    List<Student> studentList = List.of(
            new Student(1, "StudentOne", "StudentOne@gmail.com", studentOneCourses),
            new Student(2, "StudentTwo", "StudentTwo@gmail.com", studentTwoCourses));

    public Student getStudent(long id) {
        return studentList.stream().filter(student -> student.getId() == id).findFirst().orElseThrow(() ->
                new StudentNotFoundException(String.format("Student not found with id %s", id)));
    }

    public StudentList getStudents() {
        return new StudentList(studentList);
    }

    public Student createStudent(String name, String email) {
        Student student = new Student(0, name, email, new ArrayList<>());
        return student;
    }
}
