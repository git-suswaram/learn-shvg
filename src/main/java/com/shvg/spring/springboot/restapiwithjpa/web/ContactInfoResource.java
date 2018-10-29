package com.shvg.spring.springboot.restapiwithjpa.web;

import com.shvg.spring.springboot.restapiwithjpa.entity.JContactInfo;
import com.shvg.spring.springboot.restapiwithjpa.exception.ContactInfoNotFoundException;
import com.shvg.spring.springboot.restapiwithjpa.jpa.repository.JContactInfoRepository;
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

    private final JContactInfoRepository jContactInfoRepository;

    @Autowired
    public ContactInfoResource(JContactInfoRepository jContactInfoRepository) {
        this.jContactInfoRepository = jContactInfoRepository;
    }

    @GetMapping(path = "/contactInfo")
    public List<JContactInfo> get() {

        return jContactInfoRepository.findAll();
    }

    @GetMapping(path = "/contactInfo/{contactInfoID}")
    public Resource<JContactInfo> get(@PathVariable int contactInfoID) {

        Optional<JContactInfo> contactInfoByID = jContactInfoRepository.findById(contactInfoID);
        if (!contactInfoByID.isPresent()) {
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
    @PostMapping(path = "/contactInfo")
    public ResponseEntity<Object> post(@Valid @RequestBody JContactInfo contactInfo) {

        JContactInfo newContactInfo = jContactInfoRepository.save(contactInfo);

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

        jContactInfoRepository.deleteById(contactInfoID);
        
        return ResponseEntity.noContent().build();

    }

}
