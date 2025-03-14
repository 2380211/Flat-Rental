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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.BookingDTO;
import com.example.dto.FlatDTO;
import com.example.entity.Tenant;
import com.example.exception.TenantNotFoundException;
import com.example.service.TenantService;

import jakarta.validation.Valid;

@RestController // Marks this class as a RESTful web service controller
@RequestMapping("/tenant") // Base URL for all endpoints in this controller
public class TenantController {

    @Autowired // Injects the TenantService bean into this controller
    TenantService service;

    /**
     * Adds a new tenant.
     * @param tenant The tenant to be added.
     * @return A success message.
     */
    @PostMapping("/add")
    public String addTenant(@RequestBody @Valid Tenant tenant) {
        return service.addTenant(tenant);
    }

    /**
     * Retrieves a tenant by ID.
     * @param tenantId The ID of the tenant to be retrieved.
     * @return The tenant with the specified ID.
     * @throws TenantNotFoundException If the tenant with the specified ID is not found.
     */
    @GetMapping("/get/{tenantId}")
    public Tenant getTenant(@PathVariable int tenantId) throws TenantNotFoundException {
        return service.getTenant(tenantId);
    }

    /**
     * Retrieves all tenants.
     * @return A list of all tenants.
     */
    @GetMapping("/getAll")
    public List<Tenant> getAll() {
        return service.getAllTenant();
    }

    /**
     * Updates an existing tenant.
     * @param tenant The tenant with updated information.
     * @return A success message.
     * @throws TenantNotFoundException If the tenant is not found.
     */
    @PutMapping("/update")
    public String updateTenant(@RequestBody @Valid Tenant tenant) throws TenantNotFoundException {
        return service.updateTenant(tenant);
    }

    /**
     * Deletes a tenant by ID.
     * @param tenantId The ID of the tenant to be deleted.
     * @return A success message.
     * @throws TenantNotFoundException If the tenant with the specified ID is not found.
     */
    @DeleteMapping("/delete/{tenantId}")
    public String deleteTenant(@PathVariable int tenantId) throws TenantNotFoundException {
        return service.deleteTenant(tenantId);
    }

    // Additional methods

    /**
     * Books a flat for a tenant.
     * @param tenantId The ID of the tenant.
     * @param flatId The ID of the flat.
     * @return A success message.
     */
    @PostMapping("/bookFlat")
    public String bookFlat(@RequestParam("tenantId") int tenantId, @RequestParam("flatId") int flatId) {
        return service.bookFlat(tenantId, flatId);
    }

    /**
     * Retrieves all available flats.
     * @return A list of available flats.
     */
    @GetMapping("/viewAllAvailableFlats")
    public List<FlatDTO> getAllAvailableFlats() {
        return service.getAllAvailableFlats();
    }

    /**
     * Retrieves all bookings of a tenant by tenant ID.
     * @param tenantId The ID of the tenant.
     * @return A list of bookings for the tenant.
     */
    @GetMapping("/getAllTenantBookings/{tenantId}")
    public List<BookingDTO> getAllTenantBookings(@PathVariable int tenantId) {
        return service.getAllTenantBookings(tenantId);
    }
}
