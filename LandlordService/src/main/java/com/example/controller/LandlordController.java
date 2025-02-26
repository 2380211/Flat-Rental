package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.FlatDTO;
import com.example.entity.Landlord;
import com.example.exception.LandlordNotFoundException;
import com.example.service.LandlordService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/landlord")
public class LandlordController {

    @Autowired
    LandlordService service;

    /**
     * Adds a new landlord.
     * 
     * @param landlord the landlord to be added
     * @return a confirmation message
     */
    @PostMapping("/add")
    public String addLandlord(@RequestBody @Valid Landlord landlord) {
        return service.addLandlord(landlord);
    }

    /**
     * Retrieves a landlord by ID.
     * 
     * @param landlordId the ID of the landlord to be retrieved
     * @return the landlord with the specified ID
     * @throws LandlordNotFoundException if the landlord is not found
     */
    @GetMapping("/get/{landlordId}")
    public Landlord getLandlord(@PathVariable int landlordId) throws LandlordNotFoundException {
        return service.getLandlord(landlordId);
    }

    /**
     * Retrieves all landlords.
     * 
     * @return a list of all landlords
     */
    @GetMapping("/getAll")
    public List<Landlord> getAll() {
        return service.getAllLandlord();
    }

    /**
     * Updates an existing landlord.
     * 
     * @param landlord the landlord to be updated
     * @return a confirmation message
     * @throws LandlordNotFoundException if the landlord is not found
     */
    @PutMapping("/update")
    public String updateLandlord(@RequestBody @Valid Landlord landlord) throws LandlordNotFoundException {
        return service.updateLandlord(landlord);
    }

    /**
     * Deletes a landlord by ID.
     * 
     * @param landlordId the ID of the landlord to be deleted
     * @return a confirmation message
     * @throws LandlordNotFoundException if the landlord is not found
     */
    @DeleteMapping("/delete/{landlordId}")
    public String deleteLandlord(@PathVariable int landlordId) throws LandlordNotFoundException {
        return service.deleteLandlord(landlordId);
    }

    // Methods for a specific landlord

    // CRUD for flat

    /**
     * Adds a new flat.
     * 
     * @param flat the flat to be added
     * @return a confirmation message
     */
    @PostMapping("/addFlat")
    public String addFlat(@RequestBody FlatDTO flat) {
        return service.addFlat(flat);
    }

    /**
     * Retrieves a flat by ID.
     * 
     * @param flatId the ID of the flat to be retrieved
     * @return the flat with the specified ID
     */
    @GetMapping("/getFlat/{flatId}")
    public FlatDTO getFlat(@PathVariable int flatId) {
        return service.getFlat(flatId);
    }

    /**
     * Updates an existing flat.
     * 
     * @param flat the flat to be updated
     * @return a confirmation message
     */
    @PutMapping("/updateFlat")
    public String updateFlat(@RequestBody FlatDTO flat) {
        return service.updateFlat(flat);
    }

    /**
     * Deletes a flat by ID.
     * 
     * @param flatId the ID of the flat to be deleted
     * @return a confirmation message
     */
    @DeleteMapping("/deleteFlat/{flatId}")
    public String deleteFlat(@PathVariable int flatId) {
        return service.deleteFlat(flatId);
    }

    // Additional functions of Landlord

    /**
     * Retrieves all flats of a specific landlord.
     * 
     * @param landlordId the ID of the landlord
     * @return a list of all flats of the specified landlord
     */
    @GetMapping("/getAllFlatsOfLandlord/{landlordId}")
    public List<FlatDTO> getAllFlatsOfLandlord(@PathVariable int landlordId) {
        return service.getAllFlatsOfLandlord(landlordId);
    }

    /**
     * Cancels the booking of a flat.
     * 
     * @param flatId the ID of the flat
     * @return a confirmation message
     */
    @DeleteMapping("cancelBookingOfFlat/{flatId}")
    public String cancelBookingOfFlat(@PathVariable int flatId) {
        return service.cancelBookingOfFlat(flatId);
    }
}