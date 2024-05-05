package gov.transportation.passenger;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    @SequenceGenerator(name="seq",sequenceName="passenger_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passenger_seq")
    private Long id;

    @Column(unique = true)
    private Long seat_number;

    private String name;

    private Long trainId;

}
