package com.bridgelabz.vaccinationcenter.controller;

import com.bridgelabz.vaccinationcenter.entity.VaccinationCenter;
import com.bridgelabz.vaccinationcenter.model.Citizen;
import com.bridgelabz.vaccinationcenter.model.RequiredResponse;
import com.bridgelabz.vaccinationcenter.repository.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {
    @Autowired
    private CenterRepository centerRepository;
    @Autowired
    private RestTemplate restTemplate;

    // To add vaccination center to database
    @PostMapping(path = "/add")
    public ResponseEntity<VaccinationCenter> addVaccinationCenter(@RequestBody VaccinationCenter vaccinationCenter) {
        VaccinationCenter vCenter = centerRepository.save(vaccinationCenter);
        return new ResponseEntity<>(vCenter, HttpStatus.OK);
    }

    // To get the data based on the Vaccination Center Id
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<RequiredResponse> getAllDataBasedOnCenterId(@PathVariable Integer id) {
        RequiredResponse requiredResponse = new RequiredResponse();

        // to get vacination center details
        VaccinationCenter center = centerRepository.findById(id).get();
        requiredResponse.setCenter(center);

        //to get all the citizens registered on theVaccination center
        List<Citizen> listCitizen = restTemplate.getForObject("http://Micro_Service/citizen/id/" + id, List.class);
        requiredResponse.setCitizens(listCitizen);
        return new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);
    }
}