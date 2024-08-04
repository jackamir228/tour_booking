package services;

import lombok.*;
import models.Booking;
import models.Client;
import models.Tour;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import repositories.impl.TourRepos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@Getter
@Setter
public class BookingTourService {
    private final BookingService bookingService;
    private final ClientService clientService;
    private final AgencyService agencyService;
    private TourRepos tourRepos;
    @Value("${booking.currency}")
    private String currency;

    public BookingTourService(BookingService bookingService, ClientService clientService,
                              AgencyService agencyService, TourRepos tourRepos) {
        this.bookingService = bookingService;
        this.clientService = clientService;
        this.agencyService = agencyService;
        this.tourRepos = tourRepos;
    }

    public void createTour(String name, String description, BigDecimal price) {
        tourRepos.add(Tour.builder()
                .name(name)
                .description(description)
                .price(price)
                .currency(this.currency)
                .build());
    }

    public void createClient(String name, String email, String password) {
        clientService.add(name, email, password);
    }

    public Client validatePassword(String password, String name) {
        return clientService.validatePassword(password, name);
    }

    public void createBooking(List<Tour> tours, LocalDate startDate, LocalDate endDate, int countPeople) {
        bookingService.add(tours, startDate, endDate, countPeople);
    }

    public void createAgency(String name, List<Booking> bookings) {
        agencyService.add(name, bookings);
    }
}
