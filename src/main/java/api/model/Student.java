package api.model;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Student {
    private long id;

    @Size(min = 5, message = "Student name must be at least 5 characters long.")
    private String name;

    private String email;
    private List<Course> courses;
}
