package distribuitor.itstoony.com.github.controller;

import distribuitor.itstoony.com.github.model.Costumer;
import distribuitor.itstoony.com.github.model.dto.CostumerDto;
import distribuitor.itstoony.com.github.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/costumer")
public class ClientsController {

    @Autowired
    private CostumerService costumerService;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertClients(@RequestBody CostumerDto dto) {
        Costumer costumer = costumerService.fromDto(dto);
        costumerService.insert(costumer);

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

        return costumerService.findByPageableClientsName(name, page, linePerPage, orderBy, direction);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CostumerDto>> listAllCients() {
        List<CostumerDto> listDto = costumerService.findAll();
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Costumer> findById(@PathVariable Long id) {
        Optional<Costumer> op = costumerService.findByIdOptional(id);

        if (id < 0) {
            throw new IllegalArgumentException();
        }
        if (op.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Costumer costumer = op.get();
        return ResponseEntity.ok().body(costumer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @Transactional
    public ResponseEntity<CostumerDto> update(@PathVariable Long id, @RequestBody CostumerDto updateCostumerDto) {
        Optional<Costumer> op = costumerService.findByIdOptional(id);
        if (op.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Costumer costumer = costumerService.update(id, updateCostumerDto);
        return ResponseEntity.ok(costumerService.toDto(costumer));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Costumer> op = costumerService.findByIdOptional(id);
        if (op.isPresent()) {
            costumerService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
