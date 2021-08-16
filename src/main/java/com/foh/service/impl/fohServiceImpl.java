package com.foh.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foh.entity.clientEntity;
import com.foh.entity.productEntity;
import com.foh.entity.saleDetailsEntity;
import com.foh.entity.saleEntity;
import com.foh.model.clientModel;
import com.foh.model.filterSaleModel;
import com.foh.model.productModel;
import com.foh.model.productRequestModel;
import com.foh.model.productUpdateModel;
import com.foh.model.responseDetailsProductModel;
import com.foh.model.responseDetailsSaleModel;
import com.foh.model.saleDetailsModel;
import com.foh.model.saleModel;
import com.foh.model.salesModel;
import com.foh.repository.clientRepository;
import com.foh.repository.productRepository;
import com.foh.repository.saleDetailsRepository;
import com.foh.repository.saleRepository;
import com.foh.service.fohService;

@Service
public class fohServiceImpl implements fohService{

	@Autowired clientRepository clientRepo;
	
	@Autowired productRepository productRepo;
	
	@Autowired saleRepository saleRepo;
	
	@Autowired saleDetailsRepository saleDetailsRepo;
	
	@Override
	public List<clientEntity> getListClients() {
		return clientRepo.findAll();
	}

	@Override
	public void createClient(clientModel client) {
		
		clientEntity newClient = new clientEntity();
		newClient.setName(client.getName());
		newClient.setLastName(client.getLastName());
		newClient.setDni(client.getDni());
		newClient.setCellphone(client.getCellphone());
		newClient.setEmail(client.getEmail());
			
		clientRepo.save(newClient);
		
	}

	@Override
	public List<productEntity> getListProducts() {
		return productRepo.findAll();
	}

	@Override
	public void createProduct(productModel product) {
		
		productEntity newProduct = new productEntity();
		
		newProduct.setName(product.getName());
		newProduct.setPrice(product.getPrice());
		
		productRepo.save(newProduct);
		
	}

	@Override
	public void createSale(saleModel sale) {
		saleEntity newSale = new saleEntity();
		newSale.setClientID(sale.getClientID());
		newSale.setDate(sale.getDate());
		
		saleRepo.save(newSale);
	
		List<saleDetailsModel> products = new ArrayList<>();
		
		List<saleDetailsEntity> newDetailsSaleList = new ArrayList<>();
		
		products = sale.getProducts();
		
		
		for (saleDetailsModel product : products) {
			
			saleDetailsEntity saleDetails = new saleDetailsEntity();
			
			saleDetails.setVentaID(newSale.getId());
			saleDetails.setProductID(product.getProductID());
			saleDetails.setAmount(product.getAmount());
			
			newDetailsSaleList.add(saleDetails);
		}
		
		saleDetailsRepo.saveAll(newDetailsSaleList);

	
	}

	@Override
	public List<salesModel> getSales(filterSaleModel filterDate) {

		List<salesModel> listSales = new ArrayList<>();
		
		List<Map<String, Object>> list = saleRepo.GetSales(filterDate.getDateFilter());
		
	    for (Map<String, Object> map : list) {
	    	
	    	salesModel sales = new salesModel();
	        for (Map.Entry<String, Object> entry : map.entrySet()) {
	       	
	            String key = entry.getKey();
	            Object value = entry.getValue();
	            
	            if(key.toString().equals("VENTA_ID")) 
	            {
	            	sales.setSaleID( (Integer) ((BigDecimal) value).intValue() );
	            }

	            if(key.toString().equals("FECHA")) sales.setDate((Date) value);
	            if(key.toString().equals("CLIENTE_ID")) sales.setClientID( (Integer) ((BigDecimal) value).intValue());
	            if(key.toString().equals("CLIENTE")) sales.setClient((String) value);
	            if(key.toString().equals("TOTAL")) sales.setTotal((BigDecimal) value );
	            
                        
	        }
	        listSales.add(sales);
	        
	    }
		  
		return listSales;
	}

	@Override
	public responseDetailsSaleModel getDetailsSale(String ventaID) {
		

		responseDetailsSaleModel response = new responseDetailsSaleModel();
		
		Map<String, Object> saleDetails = saleDetailsRepo.getDetailsSale(ventaID);
		
        for (Map.Entry<String, Object> entry : saleDetails.entrySet()) {
       	
            String key = entry.getKey();
            Object value = entry.getValue();
            
            if(key.toString().equals("VENTA_ID")) response.setSaleID( (Integer) ((BigDecimal) value).intValue() );
            if(key.toString().equals("CLIENTE_ID")) response.setClientID( (Integer) ((BigDecimal) value).intValue());         
            if(key.toString().equals("NOMBRES")) response.setName((String)value);
            if(key.toString().equals("TELEFONO")) response.setCellPhone((String)value);
            if(key.toString().equals("DNI")) response.setDni((String)value);
            if(key.toString().equals("APELLIDOS")) response.setLastName((String)value);
            if(key.toString().equals("EMAIL")) response.setEmail((String)value);
            if(key.toString().equals("FECHA")) response.setDate((Date) value);
            if(key.toString().equals("TOTAL")) response.setTotal((BigDecimal) value );
            
                    
        }
		
		return response;
	}

	@Override
	public List<responseDetailsProductModel> getDetailsProduct(String ventaID) {
		
		List<responseDetailsProductModel> listDetailsProduct = new ArrayList<>();
		
		List<Map<String, Object>> list = saleDetailsRepo.getDetailsProducts(ventaID);
		
	    for (Map<String, Object> map : list) {
	    	
	    	responseDetailsProductModel detailsProduct = new responseDetailsProductModel();
	        for (Map.Entry<String, Object> entry : map.entrySet()) {
	       	
	            String key = entry.getKey();
	            Object value = entry.getValue();
	            
	            if(key.toString().equals("VENTA_ID")) detailsProduct.setSaleID((Integer) ((BigDecimal) value).intValue());
	            if(key.toString().equals("CANTIDAD")) detailsProduct.setAmount((Integer) ((BigDecimal) value).intValue());
	            if(key.toString().equals("TOTAL")) detailsProduct.setTotal((BigDecimal) value);	            
	            if(key.toString().equals("PRECIO")) detailsProduct.setPrice((BigDecimal) value);
	            if(key.toString().equals("NOMBRE")) detailsProduct.setName((String) value);
                       
	        }
	        listDetailsProduct.add(detailsProduct);
	        
	    }
		  
		return listDetailsProduct;
		
	}

	@Override
	public salesModel GetSalesbyID(String ventaID) {

		Map<String, Object> sale = saleRepo.GetSalesbyID(ventaID);
		
			salesModel sales = new salesModel();
	        for (Map.Entry<String, Object> entry : sale.entrySet()) {
	       	
	            String key = entry.getKey();
	            Object value = entry.getValue();
	            
	            if(key.toString().equals("VENTA_ID")) sales.setSaleID( (Integer) ((BigDecimal) value).intValue() );
	            if(key.toString().equals("FECHA")) sales.setDate((Date) value);
	            if(key.toString().equals("CLIENTE_ID")) sales.setClientID( (Integer) ((BigDecimal) value).intValue());
	            if(key.toString().equals("CLIENTE")) sales.setClient((String) value);
	            if(key.toString().equals("TOTAL")) sales.setTotal((BigDecimal) value );
	            
                        
	        }

		return sales;
	}

	@Override
	public void productDelete(productRequestModel product) {
		productRepo.deleteById(product.getProductID());
		
	}

	@Override
	public void productUpdate(productUpdateModel product) {
		productRepo.updateProduct(product.getPrice(), product.getName(), product.getProductID());
	}

}
