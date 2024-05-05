package gov.transportation.train;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullTrain {
    private String pick_up_location;
    private String destination_location;
    private LocalDateTime departure;
    private Float price;
    private String n_class;
    private Long seats;

    List<Passenger> passengerList;
}
