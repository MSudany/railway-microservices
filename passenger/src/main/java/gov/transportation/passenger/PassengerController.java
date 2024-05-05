package gov.transportation.passenger;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    private PassengerService passengerService;

    public PassengerController(PassengerService passengerService){
        this.passengerService = passengerService;
    }

    @PostMapping("")
    public ResponseEntity<PassengerEntity> createPassenger(@RequestBody PassengerEntity passengerEntity){
        PassengerEntity savedPassengerEntity = passengerService.save(passengerEntity);
        return new ResponseEntity<>(savedPassengerEntity, HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<PassengerEntity> findAll(){
        List<PassengerEntity> passengers = passengerService.findAll();
        return passengers.stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerEntity> getPassenger(@PathVariable("id") Long id){
        Optional<PassengerEntity> foundPassenger = passengerService.findOne(id);
        return foundPassenger.map(passenger ->
                        ResponseEntity.ok(passenger))
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    ResponseEntity<PassengerEntity> fullUpdatePassenger(@Valid @RequestBody PassengerEntity passengerEntity,
                                               @PathVariable("id") Long id) throws Exception {
        if (!passengerService.isExist(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        passengerEntity.setId(id);
        PassengerEntity savedPassengerEntity = passengerService.save(passengerEntity);
        return ResponseEntity.ok(savedPassengerEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePassenger(@PathVariable("id") Long id){
        passengerService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/train/{trainId}")
    public ResponseEntity<List<PassengerEntity>> findAllPassengers(@PathVariable("trainId") Long trainId){
        return ResponseEntity.ok(passengerService.findAllPassengersByTrain(trainId));
    }
}
