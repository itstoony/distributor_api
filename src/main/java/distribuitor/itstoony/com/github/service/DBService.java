package distribuitor.itstoony.com.github.service;

import distribuitor.itstoony.com.github.model.Adress;
import distribuitor.itstoony.com.github.model.Clients;
import distribuitor.itstoony.com.github.repository.AdressRepository;
import distribuitor.itstoony.com.github.repository.ClientsRepository;
import distribuitor.itstoony.com.github.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private ClientsRepository clientsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AdressRepository adress;

    public DBService(){

    }

    public void populateDatabase() {

        Clients c1 = new Clients(null, "Tony", "895.428.810-37", LocalDate.now(), null );
        Clients c2 = new Clients(null, "Tony", "895.428.810-37", LocalDate.now(), null );
        Clients c3 = new Clients(null, "Tony", "895.428.810-37", LocalDate.now(), null );
        clientsRepository.saveAll(Arrays.asList(c1,c2,c3));

        Adress ad1 = new Adress();


    }
}
