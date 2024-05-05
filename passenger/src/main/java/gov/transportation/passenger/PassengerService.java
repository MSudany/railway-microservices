package gov.transportation.passenger;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PassengerService {

    PassengerEntity save(PassengerEntity passenger);

    List<PassengerEntity> findAll();

    Optional<PassengerEntity> findOne(Long id);

    boolean isExist(Long id);

    void delete(Long id);

    List<PassengerEntity> findAllPassengersByTrain(Long trainId);

//    boolean seatExists(Long seatNumber);
}