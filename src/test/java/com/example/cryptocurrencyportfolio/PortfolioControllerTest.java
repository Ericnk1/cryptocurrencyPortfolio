package com.example.cryptocurrencyportfolio;


import com.example.cryptocurrencyportfolio.controllers.PortfolioController;

import com.example.cryptocurrencyportfolio.models.Portfolio;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PortfolioController.class)
public class PortfolioControllerTest {


    @MockBean
    PortfolioController portfolioController;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    @Test
    public void getAllEntries() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/portfolio")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findEntryById() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/portfolio/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void createNewEntry() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/portfolio")
                .content(asJsonString(new Portfolio(1L, "Ethereum", 90, "22/04/2021", "Bitfinex", new BigDecimal("0.0"), new BigDecimal("0.0"), new BigDecimal("0.0"))))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void updateEntry() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .put("/portfolio/{id}", 1L)
                .content(asJsonString(new Portfolio(1L, "Ethereum", 90, "22/04/2021", "Bitfinex", new BigDecimal("0.0"), new BigDecimal("0.0"), new BigDecimal("0.0"))))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteEntry() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders.delete("/portfolio/{id}", 1) )
                .andExpect(status().isOk());
    }


}
