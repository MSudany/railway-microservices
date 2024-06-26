package gov.transportation.train;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    private final TrainServiceImplementation trainService;

    public TrainController(TrainServiceImplementation trainService) {
        this.trainService = trainService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Train train) {
        trainService.saveTrain(train);
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Train>> findAllTrains(){
        return ResponseEntity.ok(trainService.findAllPassengers());
    }

    @GetMapping("/with-passengers/{trainId}")
    public ResponseEntity<FullTrain> findTrainWithPassengers(@PathVariable("trainId") Long trainId) {
        return ResponseEntity.ok(trainService.findTrainWithPassengers(trainId));
    }
}
