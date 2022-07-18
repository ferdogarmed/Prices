package com.ecommerce.demo.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.demo.entity.Prices;

@Repository
public interface DemoRepository extends JpaRepository<Prices, Integer>{

//	@Query("SELECT p FROM Prices p WHERE p.startDate >= ?1 and p.endDate <= ?2 and p.productId = ?3 and p.brandId = ?4")
	@Query("SELECT p FROM Prices p WHERE p.startDate >= ?1 and (?2 is null or p.endDate <= ?2) and p.productId = ?3 and p.brandId = ?4")
	Optional<List<Prices>> findByStartDateAndEndDateAndProductIdandBrandId(LocalDateTime startDate, LocalDateTime endDate, Integer productId, Integer brandId);
}
