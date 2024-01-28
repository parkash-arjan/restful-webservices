package api.model;

public class PersonV2 {


    private final PersonV1 personV1;
    private Name fullName;

    public PersonV2(Name fullName, int age) {
        this.fullName = fullName;
        this.personV1 = new PersonV1(fullName.getFirstName(), age);
    }

    public Name getFullName() {
        return fullName;
    }

    public void setFullName(Name fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return personV1.getAge();
    }
}
