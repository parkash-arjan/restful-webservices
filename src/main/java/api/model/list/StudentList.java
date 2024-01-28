package api.model.list;

import api.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class StudentList {
    private List<Student> students = new ArrayList<>();
}
