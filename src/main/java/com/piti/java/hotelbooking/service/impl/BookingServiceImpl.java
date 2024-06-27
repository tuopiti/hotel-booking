package com.piti.java.hotelbooking.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.piti.java.hotelbooking.dto.BookingDTO;
import com.piti.java.hotelbooking.dto.RoomBookingDTO;
import com.piti.java.hotelbooking.mapper.BookingMapper;
import com.piti.java.hotelbooking.model.Booking;
import com.piti.java.hotelbooking.model.BookingDetail;
import com.piti.java.hotelbooking.model.Room;
import com.piti.java.hotelbooking.repository.BookingDetailRepository;
import com.piti.java.hotelbooking.repository.BookingRepository;
import com.piti.java.hotelbooking.repository.RoomRepository;
import com.piti.java.hotelbooking.service.BookingService;
import com.piti.java.hotelbooking.service.RoomService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService{
	private BookingRepository bookingRepository;
	private BookingDetailRepository bookingDetailRepository;
	private RoomRepository roomRepository;
	private BookingMapper bookingMapper;
	private RoomService roomService;

	@Override
	@Transactional
	public void booking(BookingDTO bookingDTO) {
		List<RoomBookingDTO> roomBookingDTOs = bookingDTO.getRooms();
		
		/*
	    if (roomBookingDTOs == null || roomBookingDTOs.isEmpty()) {
	    	 throw new IllegalArgumentException("Rooms list cannot be null or empty");
	    }	
	    */
		
		List<Long> roomIds = roomBookingDTOs.stream()
				.map(RoomBookingDTO::getRoomId)
				.toList();
		
		Map<Long, Room> roomMap = roomRepository.findAllById(roomIds)
				.stream()
				.collect(Collectors.toMap(Room::getId, Function.identity()));

		//save booking
		Booking booking = bookingMapper.toBooking(bookingDTO);
		bookingRepository.save(booking);
		
		
		//save booking details
		for (RoomBookingDTO bookingDTOs : roomBookingDTOs) {
			Room room = roomMap.get(bookingDTOs.getRoomId());
			/*
			Long roomId = bookingDTOs.getRoomId();
			Room room = roomService.getById(roomId);
			*/
			BookingDetail bookingDetail = bookingMapper.toBookingDetail(bookingDTOs, booking, room.getRoomPrice());			
			bookingDetailRepository.save(bookingDetail);
		}
		
	}

}
