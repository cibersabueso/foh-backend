package com.foh.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.foh.entity.clientEntity;
import com.foh.entity.productEntity;
import com.foh.model.clientModel;
import com.foh.model.filterSaleModel;
import com.foh.model.productModel;
import com.foh.model.productRequestModel;
import com.foh.model.productUpdateModel;
import com.foh.model.responseDetailsProductModel;
import com.foh.model.responseDetailsSaleModel;
import com.foh.model.saleModel;
import com.foh.model.salesModel;

public interface fohService {
	List<clientEntity> getListClients();
	
	void createClient(clientModel client);
	
	List<productEntity> getListProducts();
	
	void productDelete(productRequestModel product);
	
	void productUpdate(productUpdateModel product);
	
	void createProduct(productModel product);
	
	void createSale(saleModel sale);
	
	List<salesModel> getSales(filterSaleModel filterDate);
	
	salesModel GetSalesbyID(String ventaID);
	
	responseDetailsSaleModel getDetailsSale(String ventaID);
	
	List<responseDetailsProductModel> getDetailsProduct(String ventaID);
	
	
	
}
