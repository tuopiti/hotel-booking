package com.piti.java.hotelbooking.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.piti.java.hotelbooking.model.Role;
import com.piti.java.hotelbooking.model.User;
import com.piti.java.hotelbooking.projection.BookingByDate;
import com.piti.java.hotelbooking.repository.BookingRepository;
import com.piti.java.hotelbooking.repository.UserRepository;
import com.piti.java.hotelbooking.service.ReportingService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ReportingServiceImpl implements ReportingService{
	private final BookingRepository bookingRepository;
	private final UserRepository userRepository;
	

	@Override
	public List<BookingByDate> getBookingByDate(LocalDate bookingDate, Authentication authentication) {
		// Fetch the current authenticated user
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                      .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    
        boolean isAdmin = user.getRoles().stream()
                             .anyMatch(role -> role.getName().equalsIgnoreCase("SUPER_ADMIN"));
        
        System.out.println(isAdmin);
        if (isAdmin) {
            return bookingRepository.findBookingsByDate(bookingDate);
        } else {
            return bookingRepository.findBookingsByDateAndOwner(bookingDate, user.getId());
        }
	}

}
