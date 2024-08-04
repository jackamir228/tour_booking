package repositories;

import java.util.List;
import java.util.Optional;

public interface ProtoRepos<E> {

    void add(E e);

    void addAll(List<E> tours);

    Optional<E> findByName(String name);

    void clearAll();

    List<E> findAll();
}
