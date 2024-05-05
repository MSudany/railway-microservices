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
    public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger){
        Passenger savedPassenger = passengerService.save(passenger);
        return new ResponseEntity<>(savedPassenger, HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<Passenger> findAll(){
        List<Passenger> passengers = passengerService.findAll();
        return passengers.stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassenger(@PathVariable("id") Long id){
        Optional<Passenger> foundPassenger = passengerService.findOne(id);
        return foundPassenger.map(passenger ->
                        ResponseEntity.ok(passenger))
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    ResponseEntity<Passenger> fullUpdatePassenger(@Valid @RequestBody Passenger passenger,
                                               @PathVariable("id") Long id) throws Exception {
        if (!passengerService.isExist(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        passenger.setId(id);
        Passenger savedPassenger = passengerService.save(passenger);
        return ResponseEntity.ok(savedPassenger);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePassenger(@PathVariable("id") Long id){
        passengerService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/train/{trainId}")
    public ResponseEntity<List<Passenger>> findAllPassengers(@PathVariable("trainId") Long trainId){
        return ResponseEntity.ok(passengerService.findAllPassengersByTrain(trainId));
    }
}
