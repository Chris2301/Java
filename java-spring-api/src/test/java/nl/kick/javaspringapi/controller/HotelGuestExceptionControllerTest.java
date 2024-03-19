package nl.kick.javaspringapi.controller;

import nl.kick.javaspringapi.exception.GlobalExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HotelGuestExceptionsController.class)
public class HotelGuestExceptionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetGuestName() throws Exception {
        int id = 5;

        mockMvc.perform(MockMvcRequestBuilders.get("/rest/hotelguest/{id}", id))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("The name for id:" + id + " is Henk"));
    }

    /**
     * This only works with {@link GlobalExceptionHandler} or
     * the {@link org.springframework.web.bind.annotation.ExceptionHandler} inside the controller
     */
    @Test
    public void testGetGuestNameWithInvalidId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rest/hotelguest/100"))
                .andExpect(status().isInternalServerError())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof Exception))
                .andExpect(result -> assertEquals("Not so many guests possible....sorry!", result.getResolvedException().getMessage()));
    }

}
