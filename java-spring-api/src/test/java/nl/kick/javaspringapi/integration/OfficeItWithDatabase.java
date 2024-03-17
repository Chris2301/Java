package nl.kick.javaspringapi.integration;

import nl.kick.javaspringapi.model.Office;
import nl.kick.javaspringapi.service.OfficeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//@WebMvcTest(HotelOfficeController.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class OfficeItWithDatabase {


    //TODO implement liquibase and test without testdatabase

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OfficeRepository officeRepository;

    @Test
    public void testGetOffices() throws Exception {
        // Arrange
        Long officeId = 1L;
        Office expectedOffice = new Office.Builder()
                .id(officeId)
                .name("Test Office")
                .employeeAmount(10)
                .build();

        officeRepository.save(expectedOffice);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/rest/hoteloffice/office/{id}", officeId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(officeId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Test Office"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeAmount").value(10));
    }
}
