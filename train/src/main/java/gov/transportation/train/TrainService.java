package gov.transportation.train;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TrainService {

    TrainEntity save(TrainEntity trainEntity);

    List<TrainEntity> findAll();

    Optional<TrainEntity> findOne(Long id);

    boolean isExist(Long id);

    void delete(Long id);
}