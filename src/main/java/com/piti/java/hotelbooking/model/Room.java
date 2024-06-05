package com.piti.java.hotelbooking.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name ="rooms")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Room extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer roomNumber;
	private String roomType;
	private BigDecimal roomPrice;
	private boolean availability;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="hotel_id", referencedColumnName = "id")
	private Hotel hotel;
	
}
