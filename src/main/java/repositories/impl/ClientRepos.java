package repositories.impl;

import lombok.Getter;
import lombok.Setter;
import models.Client;
import org.springframework.stereotype.Repository;
import repositories.ProtoRepos;

import java.util.*;

@Repository
@Getter
@Setter
public class ClientRepos implements ProtoRepos<Client> {
    private Map<String, Client> clients = new HashMap<>();


    @Override
    public void add(Client client) {
        clients.put(client.getName(), client);
    }

    @Override
    public void addAll(List<Client> clients) {
        clients.forEach(client -> this.clients.put(client.getName(), client));
    }

    @Override
    public Optional<Client> findByName(String name) {
        return Optional.ofNullable(clients.remove(name));
    }

    @Override
    public void clearAll() {
        this.clients.clear();
    }

    @Override
    public List<Client> findAll() {
        return new ArrayList<>(clients.values());
    }
}
