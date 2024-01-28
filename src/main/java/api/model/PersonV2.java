package api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PersonV2 extends PersonV1 {

    private Name fullName;

    public PersonV2(Name fullName, int age) {
        super(fullName.getFirstName(), age);
        this.fullName = fullName;
    }


    @JsonIgnore
    @Override
    public String getName() {
        return super.getName();
    }
}
