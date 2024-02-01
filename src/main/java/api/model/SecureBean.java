package api.model;


import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonFilter("SecureBeanFilter")
public class SecureBean {
    private String name;
    private String email;
    private String password;
    private int passCode;
}
