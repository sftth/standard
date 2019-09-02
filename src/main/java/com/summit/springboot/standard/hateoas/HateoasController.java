package com.summit.springboot.standard.hateoas;

import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
public class HateoasController {
    @GetMapping("/hateoas")
    public  Resource<Hateoas> hateoas() {
        Hateoas hateoas = new Hateoas();
        hateoas.setPrefix("This is");
        hateoas.setName("Jacob");


        Resource<Hateoas> hateoasResource = new Resource<>(hateoas);
        hateoasResource.add(linkTo(methodOn(HateoasController.class)
                .hateoas()).withSelfRel());
        return hateoasResource;
    }
}
