package com.clozet.controller;


import com.clozet.model.dto.CartDto;
import com.clozet.model.dto.ProductDto;
import com.clozet.model.dto.PurchaseDto;
import com.clozet.model.entity.Product;
import com.clozet.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchase/*")
public class PurchaseController {

	private final PurchaseService purchaseService;

//	@PostMapping("/check")
//	public ResponseEntity<?> checkStock(@RequestBody List<ProductDto> productListDto) throws Exception {
//
//
//		try {
//			return new ResponseEntity<>(, HttpStatus.OK);
//		} catch (Exception e) {
//			// 예외 처리
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
//		}
//	}
	@PostMapping("/")
	public ResponseEntity<?> addPurchase(@RequestBody PurchaseDto purchaseDto) throws Exception{

        purchaseDto = purchaseService.addPurchase(purchaseDto);
		return new ResponseEntity<>(purchaseDto,HttpStatus.OK);
	}

}