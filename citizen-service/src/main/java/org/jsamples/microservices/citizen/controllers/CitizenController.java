package org.jsamples.microservices.citizen.controllers;

import org.jsamples.microservices.citizen.services.CitizenService;
import org.jsamples.microservices.citizen.vo.CitizenVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class CitizenController {
    private @Autowired CitizenService citizenService;

    public CitizenController() {}

    @RequestMapping(value="/citizens/{id}", method=RequestMethod.GET)
    public ResponseEntity<CitizenVO> get(@PathVariable int id) {
        CitizenVO citizen = citizenService.loadCitizen(id);
        return null != citizen ? ResponseEntity.ok(citizen)
                               : ResponseEntity.notFound().build();
    }

    @RequestMapping(value="/citizens", method=RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody CitizenVO citizen, UriComponentsBuilder builder) {
        int id = citizenService.addCitizen(citizen);
        if (0 != id) {
            UriComponents uri = builder.path("/access/roles/{id}").buildAndExpand(id);
            return ResponseEntity.created(uri.toUri()).build();
        }
        return ResponseEntity.badRequest().body("{code=EVDLC508901}");
    }
}
