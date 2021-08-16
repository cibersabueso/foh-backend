package com.foh.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.foh.service.fohService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1")
public class FohController {

	
    @Autowired
    private fohService fohServ;
    
    @GetMapping("/listClient" )
    @ApiOperation(value = "All list client")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Resuelto correctamente"),
            @ApiResponse(code = 404, message = "No encontrado")
    })
    public List<clientEntity> listClients(){
    	
        return fohServ.getListClients();
        
    }
    
    @PostMapping("/createClient" )
    @ApiOperation(value = "Create client")   
    @ApiResponses({
            @ApiResponse(code = 200, message = "Resuelto correctamente"),
            @ApiResponse(code = 404, message = "No encontrado")
    })
    public void createClient(@RequestBody clientModel client){
    	
        fohServ.createClient(client);
        
    }   
    
    @GetMapping("/listProduct" )
    @ApiOperation(value = "All list product")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Resuelto correctamente"),
            @ApiResponse(code = 404, message = "No encontrado")
    })
    public List<productEntity> listProducts(){
    	
        return fohServ.getListProducts();
        
    }
    
    @PostMapping("/createProduct" )
    @ApiOperation(value = "Create product")   
    @ApiResponses({
            @ApiResponse(code = 200, message = "Resuelto correctamente"),
            @ApiResponse(code = 404, message = "No encontrado")
    })
    public void createProduct(@RequestBody productModel product){
    	
        fohServ.createProduct(product);
        
    }   
    
    @PostMapping("/productDelete" )
    @ApiOperation(value = "Delete product")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Resuelto correctamente"),
            @ApiResponse(code = 404, message = "No encontrado")
    })
    public void productDelete(@RequestBody productRequestModel product){
    	
        fohServ.productDelete(product);
        
    }
    
    @PostMapping("/productUpdate" )
    @ApiOperation(value = "Update product")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Resuelto correctamente"),
            @ApiResponse(code = 404, message = "No encontrado")
    })
    public void productUpdate(@RequestBody productUpdateModel product){
    	
        fohServ.productUpdate(product);
        
    }
    @PostMapping("/createSale" )
    @ApiOperation(value = "Create Sale")   
    @ApiResponses({
            @ApiResponse(code = 200, message = "Resuelto correctamente"),
            @ApiResponse(code = 404, message = "No encontrado")
    })
    public void createSale(@RequestBody saleModel sale){
    	
        fohServ.createSale(sale);
        
    } 
    
    @PostMapping("/listSales" )
    @ApiOperation(value = "All list Sales")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Resuelto correctamente"),
            @ApiResponse(code = 404, message = "No encontrado")
    })
    public List<salesModel> listSales(@RequestBody filterSaleModel filterDate){
    	
        return fohServ.getSales(filterDate);
        
    }
    
    @GetMapping("/saleByID/{ventaID}" )
    @ApiOperation(value = "Details sale")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Resuelto correctamente"),
            @ApiResponse(code = 404, message = "No encontrado")
    })
    public salesModel GetSalesbyID(@PathVariable String ventaID){
    	
        return fohServ.GetSalesbyID(ventaID);
        
    }
    
    @GetMapping("/detailSale/{ventaID}" )
    @ApiOperation(value = "Details sale")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Resuelto correctamente"),
            @ApiResponse(code = 404, message = "No encontrado")
    })
    public responseDetailsSaleModel getDetailsSale(@PathVariable String ventaID){
    	
        return fohServ.getDetailsSale(ventaID);
        
    }
    
    @GetMapping("/DetailProducts/{ventaID}" )
    @ApiOperation(value = "Details product sale")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Resuelto correctamente"),
            @ApiResponse(code = 404, message = "No encontrado")
    })
    public List<responseDetailsProductModel> getDetailsProduct(@PathVariable String ventaID){
    	
        return fohServ.getDetailsProduct(ventaID);
        
    }
    
    
}
