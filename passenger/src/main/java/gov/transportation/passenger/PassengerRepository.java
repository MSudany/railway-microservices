package gov.transportation.passenger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends CrudRepository<PassengerEntity, Long> {
    List<PassengerEntity> findAllPassengersByTrainId(Long trainId);
//    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN TRUE ELSE FALSE END FROM PassengerEntity t WHERE t.seatNumber = :seatNumber")
//    boolean seatNumberExists(@Param("seatNumber") Long seatNumber);
}