package com.reto3.reto3.repository;

//import java.util.ArrayList;
import java.util.Date;
//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto3.reto3.model.Reservation;
//import reports.com.reto3.reto3.CounterClient;
import com.reto3.reto3.repository.crud.ReservationCrudRepository;

@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getReservationAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservationId(Integer id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    public List<Reservation> ReservationStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Reservation> ReservationTime(Date one, Date second){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(one, second);
    }

       
    public List<Object[]> reportClient() {
        return reservationCrudRepository.reportClient();

    }


    /* 
// RETO 5
    public  List<CounterClient> getTopClient(){
        List<CounterClient>res=new ArrayList<>();
        List<Object[]>report=reservationCrudRepository.countTotalReservationsBySkate();
        for(int i=0;i<report.size();i++){
            res.add(new CounterClient((Long)report.get(i)[1],(Skate) report.get(i)[0]));
        }
        return res;
    }


    public  List<CounterClient> getTopClients(){
        List<CounterClient>res=new ArrayList<>();
        List<Object[]>report=reservationCrudRepository.countTotalReservationsByClient();
        for(int i=0;i<report.size();i++){
            res.add(new CounterClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    }

    public List<Reservation> getReservationPeriod(Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a,b);
    }

    public List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    */

}
