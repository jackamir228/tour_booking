package services;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import models.Booking;
import models.Agency;
import org.springframework.stereotype.Service;
import repositories.impl.AgencyRepos;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
public class AgencyService {
    AgencyRepos agencyRepos;

    public void add(String name, List<Booking> bookings) {
        this.agencyRepos.add(new Agency(name, bookings));
    }
}
