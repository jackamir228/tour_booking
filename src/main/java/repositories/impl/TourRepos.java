package repositories.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import models.Tour;
import org.springframework.stereotype.Repository;
import repositories.ProtoRepos;

import java.util.*;

@Getter
@Setter
@Repository
public class TourRepos implements ProtoRepos<Tour> {
    private Map<String, Tour> toursStorage = new HashMap<>();

    @Override
    public void add(Tour tour) {
        toursStorage.put(tour.getName(), tour);
    }

    @Override
    public void addAll(List<Tour> tours) {
        tours.forEach(tour -> toursStorage.put(tour.getName(), tour));
    }

    @Override
    public Optional<Tour> findByName(String name) {
        return Optional.ofNullable(toursStorage.remove(name));
    }

    @Override
    public void clearAll() {
        toursStorage.clear();
    }

    @Override
    public List<Tour> findAll() {
        return new ArrayList<>(toursStorage.values());
    }


}
