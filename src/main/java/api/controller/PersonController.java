package api.controller;

import api.model.Name;
import api.model.PersonV1;
import api.model.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/v1/person")
    public PersonV1 getPersonV1() {
        return new PersonV1("Parkash", 40);
    }

    @GetMapping("/v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2(new Name("Parkash", "Arjan"), 40);
    }
}
