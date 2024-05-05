package gov.transportation.train.client;

import gov.transportation.train.Passenger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


//@Component
@FeignClient(name = "passengerService", url = "${application.config.passengers-url}")
public interface PassengerClient {
    @GetMapping("/train/{trainId}")
    List<Passenger> findAllPassengersByTrain(@PathVariable("trainId") Long trainId);
}
