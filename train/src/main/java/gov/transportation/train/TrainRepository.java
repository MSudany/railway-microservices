package gov.transportation.train;

import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

@Repository
public interface TrainRepository extends CrudRepository<Train, Long> {
    Iterable<Train> departureIsAfter(LocalDateTime departure);
}