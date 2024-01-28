package api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Student {
    private long id;
    private String name;
    private String email;
    private List<Course> courses;
}
