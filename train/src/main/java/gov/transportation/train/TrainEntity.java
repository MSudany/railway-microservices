package gov.transportation.train;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "trains")
public class TrainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "train_id_seq")
    private Long id;
    private String pick_up_location;
    private String destination_location;
    private LocalDateTime departure;
    private Float price;
    private String n_class;
    private Long seats;

}
