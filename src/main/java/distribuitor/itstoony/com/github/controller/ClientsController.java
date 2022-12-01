package distribuitor.itstoony.com.github.controller;

import distribuitor.itstoony.com.github.model.Clients;
import distribuitor.itstoony.com.github.model.dto.ClientsDto;
import distribuitor.itstoony.com.github.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientsController {

    @Autowired
    private ClientsService clientsService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertClients(@RequestBody ClientsDto dto) {
        Clients clients = clientsService.fromDto(dto);
        clientsService.insert(clients);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(clients.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Clients> findById(@PathVariable Long id){

        Clients clients = clientsService.findById(id);

        return ResponseEntity.ok().body(clients);
    }


}
