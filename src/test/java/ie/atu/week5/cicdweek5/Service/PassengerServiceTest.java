package ie.atu.week5.cicdweek5.Service;

import ie.atu.week5.cicdweek5.model.Passenger;
import ie.atu.week5.cicdweek5.service.PassengerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;



class PassengerServiceTest
{
    private PassengerService service;

    @BeforeEach
    void setUp()
    {
        service = new PassengerService();
    }

    @Test
    void createThenFindById()
    {
        Passenger p = Passenger.builder()
                .passengerId("J7")
                .name("Jim")
                .email("Jim@atu.ie")
                .build();

        service.create(p);

        Optional<Passenger> found = service.findById("7");
        assertTrue(found.isPresent());
        assertEquals("Jim", found.get().getName());
    }

    @Test
    void duplicateIdThrows()
    {
        service.create(Passenger.builder()
                .passengerId("A3")
                .name("Aaron")
                .email("Aaron@powderly.com")
                .build());


        assertThrows(IllegalArgumentException.class, () ->
                service.create(Passenger.builder()
                        .passengerId("A5")
                        .name("Keelan")
                        .email("keelan@murphy.com")
                        .build()));
    }
}
