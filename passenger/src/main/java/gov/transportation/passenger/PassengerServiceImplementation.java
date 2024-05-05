package gov.transportation.passenger;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PassengerServiceImplementation implements PassengerService {

    private PassengerRepository passengerRepository;

    PassengerServiceImplementation(PassengerRepository passengerRepository){
        this.passengerRepository = passengerRepository;
    }

    @Override
    public PassengerEntity save(PassengerEntity passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public List<PassengerEntity> findAll() {
        return StreamSupport
                .stream(passengerRepository
                        .findAll()
                        .spliterator(),false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PassengerEntity> findOne(Long id) {
        return passengerRepository.findById(id);
    }

    @Override
    public boolean isExist(Long id) {
        return passengerRepository.existsById(id);
    }

    @Override
    public void delete(Long id) {
        passengerRepository.deleteById(id);
    }

    @Override
    public List<PassengerEntity> findAllPassengersByTrain(Long trainId) {
        return passengerRepository.findAllPassengersByTrainId(trainId);
    }

//    @Override
//    public boolean seatExists(Long seatNumber) {
//        return passengerRepository.seatNumberExists(seatNumber);
//    }
}