package com.example.tour_booking;

import models.Tour;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import services.BookingTourService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication(scanBasePackages = {"repositories", "services"})
public class TourBookingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TourBookingApplication.class, args);
        BookingTourService tourService = context.getBean(BookingTourService.class);

        tourService.createTour("Анапа", "Путешествие в Анапу",
                (BigDecimal.valueOf(20_000)));

        tourService.createTour("Сочи", "Путешествие в Сочи",
                (BigDecimal.valueOf(100_000)));

        tourService.createClient("petr", "petrgmail.com", "yebok123#");
        tourService.createClient("anton", "antongmail.com", "yebok123#");
        tourService.createClient("fydor", "fydorgmail.com", "yebok123#");
        tourService.createClient("ivan", "ivangmail.com", "yebok123#");


        List<Tour> tours = tourService.getTourRepos().findAll();
        tourService.createBooking(
                tours, LocalDate.of(2024, Month.JUNE, 4),
                LocalDate.of(2024, Month.JULY, 4), 100);

        tourService.createAgency(
                "Параход", tourService
                        .getBookingService()
                        .getBookingRepos()
                        .findAll()
                        .stream()
                        .toList());


    }
}
