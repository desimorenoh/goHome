package org.factoriaf5.gohome;

import org.factoriaf5.gohome.models.Client;
import org.factoriaf5.gohome.repositories.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ClientApplicationTests {

    @BeforeEach
    void setUp() {
        clientRepository.deleteAll();
    }

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ClientRepository clientRepository;

    @Test
    @WithMockUser
    void loadsTheClientPage() throws Exception {
        mockMvc.perform(get("/homes/clientlist"))
                .andExpect(status().isOk())
                .andExpect(view().name("homes/clientlist"));

    }

    @Test
    @WithMockUser
    void returnsAFormToAddNewClient() throws Exception {
        mockMvc.perform(get("/homes/info"))
                .andExpect(status().isOk())
                .andExpect(view().name("homes/info"))
                .andExpect(model().attributeExists("client"))
                .andExpect(model().attribute("title", "Solicitar Información"));
    }

    /*@Test
    @WithMockUser
    void allowsToCreateANewClient() throws Exception {
        mockMvc.perform(post("/homes/info")
                        .with(csrf())
                        .param("name", "María Pérez")
                        .param("email", "mariaperez@gmail.com")
                        .param("phone", "623.25.25.12")
                        .param("message", "hola quiero info")
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"))
        ;

        List<Client> existingClients = (List<Client>) clientRepository.findAll();
        assertThat(existingClients, contains(allOf(
                hasProperty("name", equalTo("María Pérez")),
                hasProperty("email", equalTo("mariaperez@gmail.com")),
                hasProperty("phone", equalTo("623.25.25.12")),
                hasProperty("message", equalTo("hola quiero info"))
        )));
    }*/
}