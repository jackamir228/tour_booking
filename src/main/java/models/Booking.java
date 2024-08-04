package models;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor

public class Booking {
    private List<Tour> tour;
    private LocalDate startDate;
    private LocalDate endDate;
    private int countPeople;


}
