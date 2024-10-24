package com.piti.java.hotelbooking.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.piti.java.hotelbooking.model.Booking;
import com.piti.java.hotelbooking.projection.BookingByDate;

public interface BookingRepository extends JpaRepository<Booking, Long>{
	 // Query to get all bookings by date
	@Query(value = "SELECT date(b.booking_date) AS bookingDate, \r\n"
			+ "       h.name AS hotelName, \r\n"
			+ "       COUNT(b.id) AS totalBooking, \r\n"
			+ "       SUM(bd.total_Price) AS amount\r\n"
			+ "FROM bookings b \r\n"
			+ "JOIN booking_details bd ON b.id = bd.booking_id \r\n"
			+ "JOIN rooms r ON bd.room_id = r.id \r\n"
			+ "JOIN hotels h ON r.hotel_id = h.id \r\n"
			+ "WHERE b.booking_date = '2024-10-24'\r\n"
			+ "GROUP BY b.booking_date, h.name",nativeQuery = true)
    List<BookingByDate> findBookingsByDate(@Param("bookingDate") LocalDate bookingDate);

	 // Query to get bookings by date and owner
	@Query(value = "SELECT date(b.booking_date) AS bookingDate, \r\n"
            + "       h.name AS hotelName, \r\n"
            + "       COUNT(b.id) AS totalBooking, \r\n"
            + "       SUM(bd.total_Price) AS amount\r\n"
            + "FROM bookings b \r\n"
            + "JOIN booking_details bd ON b.id = bd.booking_id \r\n"
            + "JOIN rooms r ON bd.room_id = r.id \r\n"
            + "JOIN hotels h ON r.hotel_id = h.id \r\n"
            + "JOIN users u ON h.owner_id = u.id \r\n"  
            + "WHERE b.booking_date = :bookingDate \r\n"
            + "AND u.id = :ownerId \r\n" 
            + "GROUP BY b.booking_date, h.name", nativeQuery = true)
    List<BookingByDate> findBookingsByDateAndOwner(@Param("bookingDate") LocalDate bookingDate,@Param("ownerId") Long ownerId);
}
