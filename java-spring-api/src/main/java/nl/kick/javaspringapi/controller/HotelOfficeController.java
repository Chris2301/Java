package nl.kick.javaspringapi.controller;

import nl.kick.javaspringapi.model.Office;
import nl.kick.javaspringapi.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/hoteloffice/")
public class HotelOfficeController {

    @Autowired
    private OfficeService service;

    @GetMapping(path = "office/{id}", produces = "application/json")
    public Office getOffices(@PathVariable Long id) throws Exception {
        return service.getOfficeById(id);
    }
}
