package com.piti.java.hotelbooking.service;

import com.piti.java.hotelbooking.dto.LocationDTO;
import com.piti.java.hotelbooking.model.Location;

public interface LocationService {
    LocationDTO save(LocationDTO locationDTO);
    //LocationDTO getById(Long id);
    
    Location getById(Long id);
}
