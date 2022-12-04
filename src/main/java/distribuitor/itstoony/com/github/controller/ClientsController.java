package distribuitor.itstoony.com.github.controller;

import distribuitor.itstoony.com.github.model.Costumer;
import distribuitor.itstoony.com.github.model.dto.ClientsDto;
import distribuitor.itstoony.com.github.repository.ClientsRepository;
import distribuitor.itstoony.com.github.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientsController {

    @Autowired
    private ClientsService clientsService;

    @Autowired
    private ClientsRepository clientsRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertClients(@RequestBody ClientsDto dto) {
        Costumer costumer = clientsService.fromDto(dto);
        clientsService.insert(costumer);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(costumer.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<Costumer> listClients(@RequestParam(value = "name", defaultValue = "") String name,
                                      @RequestParam(value = "page", defaultValue = "0") Integer page,
                                      @RequestParam(value = "linePerPage", defaultValue = "10") Integer linePerPage,
                                      @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                      @RequestParam(value = "direction", defaultValue = "ASC") String direction) {

        Page<Costumer> clientsPage = clientsService.findByPageableClientsName(name, page, linePerPage, orderBy, direction);
        return clientsPage;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ClientsDto>> listAllCients() {
        List<ClientsDto> listDto = clientsService.findAll();
        return ResponseEntity.ok().body(listDto);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Costumer> findById(@PathVariable Long id) {

        Costumer costumer = clientsService.findById(id);

        return ResponseEntity.ok().body(costumer);
    }


}
