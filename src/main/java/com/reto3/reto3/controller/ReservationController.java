package com.reto3.reto3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.reto3.reto3.model.Reservation;
import com.reto3.reto3.reports.CounterClient;
import com.reto3.reto3.reports.StatusReservation;
import com.reto3.reto3.service.ReservationService;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservationAll() {
        return reservationService.getReservationAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservationId(@PathVariable("id") Integer identificador) {
        return reservationService.getReservationId(identificador);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @GetMapping("/report-status")
    public StatusReservation getStatus() {
        return reservationService.ReservationStatus();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservasTiempo(@PathVariable("dateOne") String oneDate, @PathVariable("dateTwo") String secondDate) {
        return reservationService.ReservationTime(oneDate, secondDate);
    }

    @GetMapping("/report-clients")
    public List<CounterClient> getClient() {
        return reservationService.reportClient();
    }
}
