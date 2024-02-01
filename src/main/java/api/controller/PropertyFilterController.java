package api.controller;

import api.model.SecureBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class PropertyFilterController {

    @GetMapping("/secure-bean-filter")
    public MappingJacksonValue getBean() {
        SecureBean secureBean = new SecureBean(
                "Alpha",
                "alpha@beta.com",
                "password",
                123
        );

        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("name", "email");

        FilterProvider filters = new SimpleFilterProvider().addFilter("SecureBeanFilter", filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(secureBean);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }


}
