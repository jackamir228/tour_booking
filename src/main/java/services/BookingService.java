package services;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import models.Booking;
import models.Tour;
import org.springframework.stereotype.Service;
import repositories.impl.BookingRepos;

import java.time.LocalDate;
import java.util.List;

@Service
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class BookingService {
    BookingRepos bookingRepos;

    public void add(List<Tour> tours, LocalDate startDate, LocalDate endDate, int countPeople) {
        bookingRepos.add(new Booking(tours, startDate, endDate, countPeople));
    }


}
