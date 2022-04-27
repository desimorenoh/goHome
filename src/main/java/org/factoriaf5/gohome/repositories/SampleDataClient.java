package org.factoriaf5.gohome.repositories;

import org.factoriaf5.gohome.models.Client;
import org.factoriaf5.gohome.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class SampleDataClient {

    private ClientRepository clientRepository;

    @Autowired
    public SampleDataClient(ClientRepository clientRepository) {

        this.clientRepository = clientRepository;
    }

    @PostConstruct
    public void loadSampleData() {
        clientRepository.saveAll(List.of(

                new Client("Maria Trello",
                        "mariatrello@gmail.com",
                        652355487,
                        "Buen día necesito información de ésta casa. Favor contactar después de las 17"),
                new Client("Jose Peña",
                        "Jose2578@gmail.com",
                        875252547,
                        "Buenas tardes requiero información de ésta casa. Favor contactar después de las 20"),
                new Client("Roger",
                        "adevintaspain@adevinta.com",
                        548542525,
                        "Buen día :)")

        ));
    }
}