package repositories.impl;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import models.Agency;
import org.springframework.stereotype.Repository;
import repositories.ProtoRepos;

import java.util.*;

@Getter
@Setter
@Repository
@ToString
public class AgencyRepos implements ProtoRepos<Agency> {

    private Map<String, Agency> agencies = new HashMap<>();

    @Override
    public void add(Agency agency) {
        agencies.put(agency.getName(), agency);
    }

    @Override
    public void addAll(List<Agency> tours) {
        tours.forEach(tour -> agencies.put(tour.getName(), tour));
    }

    @Override
    public Optional<Agency> findByName(String name) {
        return Optional.ofNullable(agencies.get(name));
    }

    @Override
    public void clearAll() {
        agencies.clear();
    }

    @Override
    public List<Agency> findAll() {
        return new ArrayList<>(agencies.values());
    }
}
