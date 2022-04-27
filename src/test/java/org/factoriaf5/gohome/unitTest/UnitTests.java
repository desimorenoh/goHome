package org.factoriaf5.gohome.unitTest;


import org.factoriaf5.gohome.models.Category;
import org.factoriaf5.gohome.models.Client;
import org.factoriaf5.gohome.models.GoHome;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/*@SpringBootTest
public class UnitTests {


    @Test
    void goHomeHasATitleAnImageAPriceSurfaceDescriptionAndNumberOfBedrooms() {
        GoHome goHome = new GoHome("Napoles", "http://2.bp.blogspot.com/-CPACB1sSmGs/Unvq3fKG4uI/AAAAAAAAHd8/iJoo2HB7dG4/s1600/fachada-de-casa-moderna-de-ladrillo-visto-de-2-pisos.jpg", 700, 670, "El piso está situado en una zona bien central con muchas tiendas, restaurantes, supermercados y sistemas de transporte cercanos", 5);

        assertThat(goHome.getTitle(), equalTo("Napoles"));
        assertThat(goHome.getImage(), equalTo("http://2.bp.blogspot.com/-CPACB1sSmGs/Unvq3fKG4uI/AAAAAAAAHd8/iJoo2HB7dG4/s1600/fachada-de-casa-moderna-de-ladrillo-visto-de-2-pisos.jpg"));
        assertThat(goHome.getPrice(), equalTo(700));
        assertThat(goHome.getSurface(), equalTo(670));
        assertThat(goHome.getDescription(), equalTo("El piso está situado en una zona bien central con muchas tiendas, restaurantes, supermercados y sistemas de transporte cercanos"));
        assertThat(goHome.getBedrooms(), equalTo(5));
    }

    @Test
    void clientsHasANameEmailPhoneAndMessage() {
        Client client = new Client("Jose Peña",
                "Jose2578@gmail.com",
                123-456-7890,
                "Buenas tardes requiero información de ésta casa. Favor contactar después de las 20");

        assertThat(client.getName(), equalTo("Jose Peña"));
        assertThat(client.getEmail(), equalTo("Jose2578@gmail.com"));
        assertThat(client.getPhone(), equalTo(123-456-7890));
        assertThat(client.getMessage(), equalTo("Buenas tardes requiero información de ésta casa. Favor contactar después de las 20"));
    }

    @Test
    void categoryReturnsNumberOfBedrooms() {
        Category bedrooms = new Category("2");

        assertThat(bedrooms.getBedrooms(), equalTo("2"));
    }


}*/
