package org.factoriaf5.gohome.repositories;

import org.factoriaf5.gohome.models.GoHome;
import org.factoriaf5.gohome.repositories.GoHomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class SampleDataLoader {

    private GoHomeRepository goHomeRepository;

    @Autowired
    public SampleDataLoader(GoHomeRepository goHomeRepository) {

        this.goHomeRepository = goHomeRepository;
    }

    @PostConstruct
    public void loadSampleData() {
        goHomeRepository.saveAll(List.of(

                new GoHome("Napoles",
                           "http://2.bp.blogspot.com/-CPACB1sSmGs/Unvq3fKG4uI/AAAAAAAAHd8/iJoo2HB7dG4/s1600/fachada-de-casa-moderna-de-ladrillo-visto-de-2-pisos.jpg",
                           700,
                           670,
                           "El piso está situado en una zona bien central con muchas tiendas, restaurantes, supermercados y sistemas de transporte cercanos",
                           5),
                new GoHome("Los Rosales",
                           "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fdecoraideas.com%2Fwp-content%2Fuploads%2F2019%2F08%2F05-2.jpg&f=1&nofb=1",
                           400,
                           500,
                           "Piso totalmente reformado cuenta con entrada principal y entrada de servicio, un salón doble a la entrada, y un segundo salón más privado",
                           3),
                new GoHome("Los Alpes",
                           "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.hmNI18nmTg65R0gTJ5fZsAHaGm%26pid%3DApi&f=1",
                           350,
                           300,
                           "piso recién reformado y amueblado, listo para entrar a vivir, cuenta con una superficie de 300m2 construidos, situado en una cuarta planta exterior.",
                           2),
                new GoHome("Bella Vista",
                           "http://verfachadasdecasas.com/wp-content/uploads/2018/09/Fachadas-de-casas-blancas-de-dos-pisos.jpg",
                           630,
                           520,
                           "La vivienda de 520m² se encuentra en la segunda planta de un edificio de fachada clásica, ubicado en una de las zonas residenciales",
                           4),
                new GoHome("Calera",
                           "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.casapost.ro%2Fwp-content%2Fuploads%2F2017%2F08%2FCasa-doar-parter-cu-geamuri-mari-1024x768.jpg&f=1&nofb=1",
                           250,
                           280,
                           "stupendo piso reformado y amueblado a estrenar con vistas al Parque del Retiro.",
                           3),
                new GoHome("Colina",
                           "https://e00-expansion.uecdn.es/assets/multimedia/imagenes/2017/03/22/14902185122356.jpg",
                           450,
                           300,
                           "Magnifico piso en rentabilidad de 300m2 en Bellas Vistas, con ascensor, completamente amueblado y reforma integral.",
                           4),
                new GoHome("Peñaflor",
                           "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.XxNZZ8R89WWt-t7lEuB2FAHaE8%26pid%3DApi&f=1",
                           320,
                           600,
                           "Magnífico piso con reforma integral en 2020.",
                           5),
                new GoHome("Villarrapa",
                           "https://www.miamiinmuebles.com/images/mls/A/10723310/1.jpg",
                           300,
                           350,
                           "Estupendo Loft reformado y amueblado a pocos minutos del parque de Atenas y del Palacio Real.",
                           1)
        ));
    }
}


