package com.piti.java.hotelbooking.spec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.piti.java.hotelbooking.model.Hotel;
import com.piti.java.hotelbooking.model.Location;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

@SuppressWarnings("serial")
@AllArgsConstructor
public class HotelSpec implements Specification<Hotel>{
	private final HotelFilter hotelFilter;
	
	@Override
	public Predicate toPredicate(Root<Hotel> hotel, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> list = new ArrayList<>();
		Join<Hotel, Location> location = hotel.join("location");
		
        if(hotelFilter.getHotelId() != null) {
        	Predicate hotelId = hotel.get("id").in(hotelFilter.getHotelId());
        	list.add(hotelId);
        }
        
        if(hotelFilter.getHotelName() != null) {
        	Predicate hotelName = cb.like(hotel.get("name"), "%" + hotelFilter.getHotelName() + "%");
        	list.add(hotelName);
        }
        
        if(hotelFilter.getLocationId() != null) {
        	Predicate locationId = location.get("id").in(hotelFilter.getLocationId());
        	list.add(locationId);
        }
        
        if(hotelFilter.getLocationName() != null) {
        	Predicate locationName = cb.like(location.get("name"), "%" + hotelFilter.getLocationName() + "%");
        	list.add(locationName);
        }
        
        Predicate[] predicates = list.toArray(Predicate[]::new);
		return cb.and(predicates);
	}

}
