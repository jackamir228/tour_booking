package repositories.impl;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import models.Booking;
import org.springframework.stereotype.Repository;
import repositories.ProtoRepos;

import java.util.*;

@Getter
@Setter
@ToString
@Repository
public class BookingRepos implements ProtoRepos<Booking> {
    private Map<String, Booking> bookings = new HashMap<>();

    @Override
    public void add(Booking booking) {
        bookings.put(booking.toString(), booking);
    }

    @Override
    public void addAll(List<Booking> bookings) {
        bookings.stream()
                .forEach(booking -> this.bookings.put(booking.toString(), booking));
    }

    @Override
    public Optional<Booking> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public void clearAll() {
        this.bookings.clear();
    }

    @Override
    public List<Booking> findAll() {
        return new ArrayList<>(bookings.values());
    }
}
