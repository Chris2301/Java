package nl.kick.javaspringapi.controller;

import nl.kick.javaspringapi.model.Office;
import nl.kick.javaspringapi.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest API to showcase a full integration test
 *
 * More and more in microservice architecture apis are simple and straightforward.
 * Still we often make a test class for each class (controller, service, repository etc.)
 * seeing every method as a unit to test. Developers tend think in small units first and about the business logic
 * integrations tests second (or never).
 *
 * It feels like a small nuance, but developers that think first and mostly about business logic tend to write better code.
 * Integration tests first and unit tests where needed feels more logical.
 * The same code coverage, less cumbersome code to write, test driven development is still possible and no mockito.
 * An idea to ponder.
 *
 */
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
