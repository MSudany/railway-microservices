package gov.transportation.train;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Passenger {
    private Long seat_number;

    private String name;

    private TrainEntity train;
}
