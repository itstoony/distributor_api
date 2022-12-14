package distribuitor.itstoony.com.github.controller;

import distribuitor.itstoony.com.github.model.Costumer;
import distribuitor.itstoony.com.github.model.dto.CostumerDto;
import distribuitor.itstoony.com.github.model.dto.CostumerRecord;
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
public class CostumerController {

    @Autowired
    private CostumerService costumerService;


    @RequestMapping(method = RequestMethod.POST)
    @Transactional
    public ResponseEntity<Void> insertClients(@RequestBody CostumerRecord record) {

        Costumer costumer = costumerService.fromRecord(record);

        costumerService.insert(costumer);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(costumer.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<Costumer> listCostumer(@RequestParam(value = "name", defaultValue = "") String name,
                                       @RequestParam(value = "page", defaultValue = "0") Integer page,
                                       @RequestParam(value = "linePerPage", defaultValue = "10") Integer linePerPage,
                                       @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                       @RequestParam(value = "direction", defaultValue = "ASC") String direction) {

        return costumerService.findByPageableClientsName(name, page, linePerPage, orderBy, direction);
    }

    @Transactional
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CostumerDto> update(@PathVariable Long id, @RequestBody CostumerDto updateCostumerDto) {
        Optional<Costumer> op = costumerService.findByIdOptional(id);

        if (op.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Costumer costumer = costumerService.update(id, updateCostumerDto);

        return ResponseEntity.ok(costumerService.toDto(costumer));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CostumerDto>> listAllCostumer() {
        List<CostumerDto> listDto = costumerService.findAllDto();
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

    @Transactional
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Costumer> op = costumerService.findByIdOptional(id);

        if (op.isPresent()) {
            costumerService.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
