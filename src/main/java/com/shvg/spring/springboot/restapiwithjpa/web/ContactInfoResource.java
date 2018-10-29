package com.shvg.spring.springboot.restapiwithjpa.web;

import com.shvg.spring.springboot.restapiwithjpa.entity.JContactInfo;
import com.shvg.spring.springboot.restapiwithjpa.exception.ContactInfoNotFoundException;
import com.shvg.spring.springboot.restapiwithjpa.service.JContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class ContactInfoResource {

    @Autowired
    private final JContactInfoService jContactInfoService;

    public ContactInfoResource(JContactInfoService jContactInfoService) {
        this.jContactInfoService = jContactInfoService;
    }

    @GetMapping(path = "/jpa/contactInfo")
    public List<JContactInfo> get() {

        return jContactInfoService.get();
    }

    @GetMapping(path = "/jpa/contactInfo/{contactInfoID}")
    public Resource<JContactInfo> get(@PathVariable int contactInfoID) {

        Optional<JContactInfo> contactInfoByID = jContactInfoService.get(contactInfoID);
        if (contactInfoByID==null || !contactInfoByID.isPresent()) {
            throw new ContactInfoNotFoundException("Failed to retrieve. ContactInfo Not Found, ID = " + contactInfoID);
        }

        //HATEOAS
        Resource<JContactInfo> resource = new Resource(contactInfoByID);
        ControllerLinkBuilder linkToRetrieveAllContactInfo = linkTo(methodOn(this.getClass()).get());
        resource.add(linkToRetrieveAllContactInfo.withRel("all-contacts"));

        return resource;
    }

    /**
     * input - details of contactInfo
     * output - HTTPStatus of CREATED & Return URI for the contactInfo created
     */
    @PostMapping(path = "/jpa/contactInfo")
    public ResponseEntity<Object> post(@Valid @RequestBody JContactInfo contactInfo) {

        JContactInfo newContactInfo = jContactInfoService.post(contactInfo);

        /*
         * Set Response status to Created
         * Send URI for newly created contact
         */

        URI newContactInfoURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newContactInfo.getId()).toUri();

        return ResponseEntity.created(newContactInfoURI).build();
    }

    @DeleteMapping(path = "/jpa/contactInfo/{contactInfoID}")
    public ResponseEntity<Object> delete(@PathVariable int contactInfoID) {

        jContactInfoService.delete(contactInfoID);
        return ResponseEntity.noContent().build();
    }
}
