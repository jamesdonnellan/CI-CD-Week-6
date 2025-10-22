package ie.atu.week5.cicdweek5.service;

import ie.atu.week5.cicdweek5.errorHandling.DuplicateException;
import ie.atu.week5.cicdweek5.model.Passenger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerService
{
    private final List<Passenger> store = new ArrayList<>();

    public List<Passenger> findAll()
    {
        return new ArrayList<>(store);
    }

    public Optional<Passenger> findById(String id)
    {
        for(Passenger p : store)
        {
            if (p.getPassengerId().equals(id))
            {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public Passenger create(Passenger p)
    {
        if (findById(p.getPassengerId()).isPresent())
        {
            throw new DuplicateException("Passenger with id " + p.getPassengerId() + " already exists");
        }
        store.add(p);
        return p;
    }

    public Optional<Passenger> update(String id, Passenger updated)
    {
        for (Passenger p : store)
        {
            if (p.getPassengerId().equals(id))
            {
                p.setName(updated.getName());
                p.setEmail(updated.getEmail());
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public boolean deleteById(String id)
    {
        return store.removeIf(p -> p.getPassengerId().equals(id));
    }
}
