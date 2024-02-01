package api.controller;

import api.model.LinkedBean;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class LinkedBeanController {


    @GetMapping("/linked-bean-list")
    public List<LinkedBean> getSecureBeanList() {

        return List.of(
                new LinkedBean(
                        "Alpha",
                        "alpha@beta.com"
                ),
                new LinkedBean(
                        "gama",
                        "gama@sigma.com"
                ));
    }

    @GetMapping("/linked-bean")
    public EntityModel<LinkedBean> getBeanWithLink() {
        LinkedBean linkedBean = new LinkedBean(
                "Alpha",
                "alpha@beta.com"
        );

        EntityModel<LinkedBean> entityModel = EntityModel.of(linkedBean);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getSecureBeanList());
        entityModel.add(link.withRel("linked-beans"));
        return entityModel;
    }
}
