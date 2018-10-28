package com.shvg.spring.springboot.restapi.web;

import com.shvg.spring.springboot.restapi.beans.ContactInfo;
import com.shvg.spring.springboot.restapi.exception.ContactInfoNotFoundException;
import com.shvg.spring.springboot.restapi.service.ContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class ContactInfoResource {

    private final ContactInfoService contactInfoService;

    @Autowired
    public ContactInfoResource(ContactInfoService contactInfoService) {
        this.contactInfoService = contactInfoService;
    }

    @GetMapping(path = "/contactInfo")
    public List<ContactInfo> get() {

        return contactInfoService.get();
    }

    @GetMapping(path = "/contactInfo/{contactInfoID}")
    public Resource<ContactInfo> get(@PathVariable int contactInfoID) {

        ContactInfo contactInfoByID = contactInfoService.get(contactInfoID);
        if (contactInfoByID == null) {
            throw new ContactInfoNotFoundException("Failed to retrieve. ContactInfo Not Found, ID = " + contactInfoID);
        }

        //HATEOAS
        Resource<ContactInfo> resource = new Resource<>(contactInfoByID);
        ControllerLinkBuilder linkToRetrieveAllContactInfo = linkTo(methodOn(this.getClass()).get());
        resource.add(linkToRetrieveAllContactInfo.withRel("all-contacts"));

        return resource;
    }

    /**
     * input - details of contactInfo
     * output - HTTPStatus of CREATED & Return URI for the contactInfo created
     */
    @PostMapping(path = "/contactInfo")
    public ResponseEntity<Object> post(@Valid @RequestBody ContactInfo contactInfo) {

        ContactInfo newContactInfo = contactInfoService.post(contactInfo);

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

    @DeleteMapping(path = "/contactInfo/{contactInfoID}")
    public ResponseEntity<Object> delete(@PathVariable int contactInfoID) {

        ContactInfo deleteContactInfoByID = contactInfoService.delete(contactInfoID);

        if (deleteContactInfoByID == null) {
            throw new ContactInfoNotFoundException("Failed to Delete. ContactInfo Not Found, ID = " + contactInfoID);
        }

        return ResponseEntity.noContent().build();

    }

}
