package gov.transportation.train;

import gov.transportation.train.client.PassengerClient;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainServiceImplementation {
    private final TrainRepository trainRepository;
    private final PassengerClient passengerClient;

    public void saveTrain(Train train){
        trainRepository.save(train);
    }

    public Iterable<Train> findAllPassengers(){
        return trainRepository.findAll();
    }

    public FullTrain findTrainWithPassengers(Long trainId) {
        Train train = trainRepository.findById(trainId)
                .orElse(Train.builder()
                        .pick_up_location("NOT_FOUND")
                        .destination_location("NOT_FOUND")
                        .build());
        List<Passenger> passengers = passengerClient.findAllPassengersByTrain(trainId);
        return FullTrain.builder()
                .pick_up_location(train.getPick_up_location())
                .destination_location(train.getDestination_location())
                .departure(train.getDeparture())
                .price(train.getPrice())
                .n_class(train.getN_class())
                .seats(train.getSeats())
                .passengerList(passengers)
                .build();
    }
}