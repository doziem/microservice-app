package com.doziem.product.product.service;

import com.doziem.product.product.dto.ProductPurchaseRequest;
import com.doziem.product.product.dto.ProductPurchaseResponse;
import com.doziem.product.product.dto.ProductRequest;
import com.doziem.product.product.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    String  createProduct(ProductRequest request);

    ProductResponse findById(String productId);

    List<ProductResponse> findAll();

    List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request );


}
