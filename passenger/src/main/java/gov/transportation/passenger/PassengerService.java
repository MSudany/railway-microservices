package gov.transportation.passenger;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PassengerService {

    Passenger save(Passenger passenger);

    List<Passenger> findAll();

    Optional<Passenger> findOne(Long id);

    boolean isExist(Long id);

    void delete(Long id);

    List<Passenger> findAllPassengersByTrain(Long trainId);

//    boolean seatExists(Long seatNumber);
}