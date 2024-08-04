package services;

import models.Client;

import java.util.Optional;

public interface ProtoClientService {

    void add(String name, String email, String password);

    Client validatePassword(String password, String name);
}
