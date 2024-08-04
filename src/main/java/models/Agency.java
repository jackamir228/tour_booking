package models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class Agency {
    private String name;
    private List<Booking> bookings;
}
