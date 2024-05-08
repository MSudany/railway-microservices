package gov.transportation.train;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TrainService {

    Train save(Train train);

    List<Train> findAll();

    Optional<Train> findOne(Long id);

    boolean isExist(Long id);

    void delete(Long id);
}