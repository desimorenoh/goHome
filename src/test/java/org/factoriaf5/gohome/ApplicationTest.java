package org.factoriaf5.gohome;

import org.factoriaf5.gohome.models.GoHome;
import org.factoriaf5.gohome.repositories.GoHomeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {
    @BeforeEach
    void setUp() {

        goHomeRepository.deleteAll();

    }

    @Autowired
    MockMvc mockMvc;

    @Test
    @WithMockUser
    void loadsTheHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }

    @Autowired
    GoHomeRepository goHomeRepository;

    @Test
    @WithMockUser
    void returnsTheExistingHomes() throws Exception {

        GoHome goHome = goHomeRepository.save(new GoHome("Napoles", "http://2.bp.blogspot.com/-CPACB1sSmGs/Unvq3fKG4uI/AAAAAAAAHd8/iJoo2HB7dG4/s1600/fachada-de-casa-moderna-de-ladrillo-visto-de-2-pisos.jpg", 700, 670, "Magnífico piso con reforma integral en 2020", 5));

        mockMvc.perform(get("/homes"))
                .andExpect(status().isOk())
                .andExpect(view().name("homes/all"))
                .andExpect(model().attribute("homes", hasItem(goHome)));

    }

    @Test
    @WithMockUser
    void returnsAFormToAddNewHome() throws Exception {
        mockMvc.perform(get("/homes/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("homes/edit"))
                .andExpect(model().attributeExists("goHome"))
                .andExpect(model().attribute("title", "Añadir una nueva Casa"))
                .andExpect(model().attribute("categories", hasItems(
                    hasProperty("bedrooms", is("1")),
                    hasProperty("bedrooms", is("2")),
                    hasProperty("bedrooms", is("3")),
                    hasProperty("bedrooms", is("4")),
                    hasProperty("bedrooms", is("5"))
        )));
    }


    @Test
    @WithMockUser
    void allowsToCreateANewHome() throws Exception {
        mockMvc.perform(post("/homes/new")
                        .with(csrf())
                        .param("title", "Villarrapa")
                        .param("image", "https://www.miamiinmuebles.com/images/mls/A/10723310/1.jpg")
                        .param("price", String.valueOf(300))
                        .param("surface", String.valueOf(350))
                        .param("description", "Magnífico piso con reforma integral en 2020")
                        .param("bedrooms", String.valueOf(2))
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/homes"))
        ;

        List<GoHome> existingHomes = (List<GoHome>) goHomeRepository.findAll();
        assertThat(existingHomes, contains(allOf(
                hasProperty("title", equalTo("Villarrapa")),
                hasProperty("image", equalTo("https://www.miamiinmuebles.com/images/mls/A/10723310/1.jpg")),
                hasProperty("price", equalTo(300)),
                hasProperty("surface", equalTo(350)),
                hasProperty("description", equalTo("Magnífico piso con reforma integral en 2020")),
                hasProperty("bedrooms", equalTo(2))
        )));
    }

    @Test
    @WithMockUser
    void returnsAFormToEditHomes() throws Exception {
        GoHome goHome = goHomeRepository.save(new GoHome("Napoles", "http://2.bp.blogspot.com/-CPACB1sSmGs/Unvq3fKG4uI/AAAAAAAAHd8/iJoo2HB7dG4/s1600/fachada-de-casa-moderna-de-ladrillo-visto-de-2-pisos.jpg", 700, 670, "Magnífico piso con reforma integral en 2020", 5));
        mockMvc.perform(get("/homes/edit/" + goHome.getId()))
                .andExpect(status().isOk())
                .andExpect(view().name("homes/edit"))
                .andExpect(model().attribute("goHome", goHome))
                .andExpect(model().attribute("title", "Editar Casa"))
                .andExpect(model().attribute("categories", hasItems(
                    hasProperty("bedrooms", is("1")),
                    hasProperty("bedrooms", is("2")),
                    hasProperty("bedrooms", is("3")),
                    hasProperty("bedrooms", is("4")),
                    hasProperty("bedrooms", is("5"))
                )));
    }


    @Test
    @WithMockUser
    void allowsToDeleteAHome() throws Exception {
        GoHome goHome = goHomeRepository.save(new GoHome("Napoles", "http://2.bp.blogspot.com/-CPACB1sSmGs/Unvq3fKG4uI/AAAAAAAAHd8/iJoo2HB7dG4/s1600/fachada-de-casa-moderna-de-ladrillo-visto-de-2-pisos.jpg", 700, 670, "Magnífico piso con reforma integral en 2020", 5));
        mockMvc.perform(get("/homes/delete/" + goHome.getId()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/homes"));

        assertThat(goHomeRepository.findById(goHome.getId()), equalTo(Optional.empty()));
    }

    @Test
    @WithMockUser
    void allowsToSearchHomesByWord() throws Exception {

        GoHome goHomeWithWord = goHomeRepository.save(new GoHome("Napoles", "http://2.bp.blogspot.com/-CPACB1sSmGs/Unvq3fKG4uI/AAAAAAAAHd8/iJoo2HB7dG4/s1600/fachada-de-casa-moderna-de-ladrillo-visto-de-2-pisos.jpg", 700, 670, "Magnífico piso con reforma integral en 2020", 5));
        GoHome goHomeWithoutWord = goHomeRepository.save(new GoHome("Villarrapa", "https://www.miamiinmuebles.com/images/mls/A/10723310/1.jpg", 300, 350, "", 2));

        mockMvc.perform(get("/homes/search?word=Napoles"))
                .andExpect(status().isOk())
                .andExpect(view().name("homes/all"))
                .andExpect(model().attribute("title", equalTo("Casas que contienen \"Napoles\"")))
                .andExpect(model().attribute("homes", hasItem(goHomeWithWord)))
                .andExpect(model().attribute("homes", not(hasItem(goHomeWithoutWord))));
    }

    @Test
    @WithMockUser
    void returnsAViewDetails() throws Exception {
        GoHome goHome = goHomeRepository.save(new GoHome("Napoles", "http://2.bp.blogspot.com/-CPACB1sSmGs/Unvq3fKG4uI/AAAAAAAAHd8/iJoo2HB7dG4/s1600/fachada-de-casa-moderna-de-ladrillo-visto-de-2-pisos.jpg", 700, 670, "Magnífico piso con reforma integral en 2020", 5));
        mockMvc.perform(get("/homes/details/" + goHome.getId()))
                .andExpect(status().isOk())
                .andExpect(view().name("homes/details"))
                .andExpect(model().attribute("Detail", goHome))
                .andExpect(model().attribute("title", "Detalles de la Casa"));
    }

}
