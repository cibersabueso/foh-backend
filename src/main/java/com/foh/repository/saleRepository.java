package com.foh.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.foh.entity.saleEntity;

public interface saleRepository extends JpaRepository<saleEntity, Integer> {

	@Query(nativeQuery = true, value= "select cliente.cliente_id, cliente.nombres|| ' ' ||cliente.apellidos as cliente, v.fecha, v.total, v.venta_id from cliente inner join (\r\n"
			+ "select venta.cliente_id,venta.fecha, dventa.total, venta.venta_id from venta inner join (select sum(total) as total, venta_id from (\r\n"
			+ "select sum(producto.precio * detalle_venta.cantidad) as total, detalle_venta.venta_id from detalle_venta inner join producto on detalle_venta.producto_id=producto.producto_id group by detalle_venta_id, venta_id\r\n"
			+ ") group by venta_id) dventa on venta.venta_id=dventa.venta_id\r\n"
			+ ") v on v.cliente_id=cliente.cliente_id where TO_CHAR(v.fecha, 'YYYY-MM-DD') = ?1")
	List<Map<String, Object>> GetSales(String fecha);
	
	@Query(nativeQuery = true, value= "select cliente.cliente_id, cliente.nombres|| ' ' ||cliente.apellidos as cliente, v.fecha, v.total, v.venta_id from cliente inner join (\r\n"
			+ "select venta.cliente_id,venta.fecha, dventa.total, venta.venta_id from venta inner join (select sum(total) as total, venta_id from (\r\n"
			+ "select sum(producto.precio * detalle_venta.cantidad) as total, detalle_venta.venta_id from detalle_venta inner join producto on detalle_venta.producto_id=producto.producto_id group by detalle_venta_id, venta_id\r\n"
			+ ") group by venta_id) dventa on venta.venta_id=dventa.venta_id\r\n"
			+ ") v on v.cliente_id=cliente.cliente_id where v.venta_id = ?1")
	Map<String, Object> GetSalesbyID(String ventaID);
}
