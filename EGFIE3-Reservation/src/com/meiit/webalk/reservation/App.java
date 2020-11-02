package com.meiit.webalk.reservation;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;
import com.meiit.webalk.reservation.service.ReservationService;
import com.meiit.webalk.reservation.service.View;

public final class App {
    private ReservationService reservationService;
    private View view;

    private App(ReservationService reservationService, View view) {
        this.reservationService = reservationService;
        this.view = view;
    }

    public static void main(String[] args) {
        App app = new App(new ReservationService(), new View());
        app.createBookingPerson();
        app.book();
        app.reservationService.checkIn(app.view);
        System.out.println("Few days passed...");
        app.reservationService.checkOut(app.view);
    }

    public void createBookingPerson() {
        reservationService.saveBookingPerson(view.readBookingPerson());
    }

    public void book() {
        Room room;
        do {
            room = view.selectRoom(reservationService.findAllHotels());
            if (room == null)
                break;
            if (room.getPrice() <= reservationService.findBookingPerson().getBalance().intValue()) {
                reservationService.findBookingPerson().setBalance(reservationService.findBookingPerson().getBalance()
                        .subtract(BigDecimal.valueOf(room.getPrice())));
                Reservation reservation = new Reservation();
                reservation.setAmount(BigDecimal.valueOf(room.getPrice()));
                reservation.setFrom(LocalDate.now());
                reservation.setTo(LocalDate.now().plusDays(6));
                reservation.setRoom(room);
                reservationService.saveReservation(reservation);
                view.printReservationSaved(reservation);
            } else
                view.printNotEnoughBalance(reservationService.findBookingPerson());
        } while (room != null);
    }
}