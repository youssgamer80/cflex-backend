/*package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import projet.cflex.oda_cflex_smart_city1.Model.Position;
import projet.cflex.oda_cflex_smart_city1.Repository.PositionRepository;

@RestController
@RequestMapping("api/positions")
@Tag(name = "API Position", description = "Api de services de gestions des positions des utilsateurs")
public class PositionController {

    private final static Logger LOGGER = LoggerFactory.getLogger(PositionController.class);
    @Autowired
    private final PositionRepository positionRepository;

    public PositionController(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @PostMapping("/addPosition")
    @ResponseStatus(HttpStatus.CREATED)
    public Position postPosition(@RequestBody Position position) {
        System.out.println(position.getLongitude());
        return positionRepository.save(position);
    }

    @PostMapping("/addMultiplePositions")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Position> postPositions(@RequestBody List<Position> positions) {
        return positionRepository.saveAll(positions);
    }

    @GetMapping("/positions")
    public List<Position> getPositions() {
        return positionRepository.findAll();
    }

    @GetMapping("position/{userId}")
    public ResponseEntity<Position> getPosition(@PathVariable String userId) {
        Position position = positionRepository.findOne(userId);
        if (position == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(position);
    }

    @GetMapping("posiitons/{ids}")
    public List<Position> getPositions(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return positionRepository.findAll(listIds);
    }

    private List<String> asList(String[] split) {
        return null;
    }

    
    @PutMapping("/updatePosition")
    public Position putPerson(@RequestBody Position position) {
        return positionRepository.update(position);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final Exception handleAllExceptions(RuntimeException e) {
        LOGGER.error("Internal server error.", e);
        return e;
    }
}*/