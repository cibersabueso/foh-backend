package com.foh.repository;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.foh.entity.productEntity;

public interface productRepository extends JpaRepository<productEntity, Integer> {
	
	@Transactional
    @Modifying
	@Query(nativeQuery = true, value="update producto\r\n"
			+ "set precio=?1,\r\n"
			+ "nombre=?2 \r\n"
			+ "where producto_id=?3")
	void updateProduct(BigDecimal precio, String nombre, Integer id);
}
