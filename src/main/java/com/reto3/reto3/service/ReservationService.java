package com.reto3.reto3.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.reto3.reto3.model.Client;
import com.reto3.reto3.model.Reservation;
import com.reto3.reto3.reports.CounterClient;
import com.reto3.reto3.reports.StatusReservation;
import com.reto3.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getReservationAll() {
        return reservationRepository.getReservationAll();
    }

    public Optional<Reservation> getReservationId(Integer reservationId) {
        return reservationRepository.getReservationId(reservationId);
    }

    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> e = reservationRepository.getReservationId(reservation.getIdReservation());
            if (e.isEmpty()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    public StatusReservation ReservationStatus() {

        List<Reservation> completed = reservationRepository.ReservationStatus("completed");
        List<Reservation> cancelled = reservationRepository.ReservationStatus("cancelled");

        return new StatusReservation(completed.size(), cancelled.size());
    }

    public List<Reservation> ReservationTime(String oneDate, String secondDate) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date one = new Date();
        Date second = new Date();

        try {
            one = parser.parse(oneDate);
            second = parser.parse(secondDate);
        } catch (ParseException evt) {
            evt.printStackTrace();

        }
        if (one.before(second)) {
            return reservationRepository.ReservationTime(one, second);
        } else {
            return new ArrayList<>();
        }
    }

    public List<CounterClient> reportClient() {
        List<CounterClient> result = new ArrayList<>();
        List<Object[]> report = reservationRepository.reportClient();
        System.out.println(report);
        for (int i = 0; i < report.size(); i++) {
            result.add(new CounterClient((Long) report.get(i)[1], (Client) report.get(i)[0]));
        }
        return result;
    }
}
