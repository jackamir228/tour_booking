package services;

import lombok.Getter;
import lombok.Setter;
import models.Tour;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import repositories.impl.TourRepos;

import java.math.BigDecimal;

@Getter
@Setter
        //@Service
public class TourService {
    private final TourRepos tourRepos;
    @Value("${booking.currency}")
    private String currency;

    public TourService(TourRepos tourRepos) {
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
}
