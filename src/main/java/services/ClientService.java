package services;

import com.example.tour_booking.exceptions.BadPasswordException;
import com.example.tour_booking.exceptions.ClientNotFoundException;
import lombok.Getter;
import lombok.Setter;
import models.Client;
import org.springframework.stereotype.Service;
import repositories.impl.ClientRepos;

@Getter
@Setter
@Service
public class ClientService implements ProtoClientService {

    private final ClientRepos clientRepos;

    public ClientService(ClientRepos clientRepos) {
        this.clientRepos = clientRepos;
    }

    @Override
    public void add(String name, String email, String password) {
        clientRepos.add(new Client(name, email, password));
    }

    @Override
    public Client validatePassword(String password, String name) {
        Client client = clientRepos.findByName(name)
                .orElseThrow(() -> new ClientNotFoundException("Клиент с именем " + name + "не найден\n"));
        if (!client.getPassword().equals(password)) {
            throw new BadPasswordException("Неверный пароль");
        }
        return client;
    }

}
