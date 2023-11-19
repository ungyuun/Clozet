package com.clozet.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clozet.Mapper.ProductMapper;
import com.clozet.cloud.FileUpload;
import com.clozet.model.dto.CartDto;
import com.clozet.model.dto.ImageDto;
import com.clozet.model.dto.PageInfo;
import com.clozet.model.dto.ProductDto;
import com.clozet.model.entity.Cart;
import com.clozet.model.entity.Product;
import com.clozet.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/product/*")
public class ProductController {


	private final ProductService productService;
	private final FileUpload fileUpload;

	@Autowired
	public ProductController(ProductService productService, FileUpload fileUpload) {
		this.productService = productService;
		this.fileUpload = fileUpload;
	}

    @PostMapping("/img")
	public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		return fileUpload.tempFileUpload(file);
	}

	@PostMapping("/newproduct")
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) throws Exception {
		Product product = productService.addProduct(productDto);
		System.out.println(ProductMapper.INSTANCE.toDto(product).toString());
		return ResponseEntity.ok(ProductMapper.INSTANCE.toDto(product));
	}


	@GetMapping("/{prodNo}")
	public ResponseEntity<Map<String, Object>> getProduct(@PathVariable Long prodNo) throws Exception {
		System.out.println("시작");
		Map<String, Object> map = new HashMap<>();

		map.put("product",productService.getProduct(prodNo));
		map.put("productDetail",productService.getProductDetail(prodNo));
		System.out.println("종료");
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

//	@GetMapping("/main")
//	public ResponseEntity<?> getProductList(@RequestParam("page") int page) throws Exception {
//		try {
//			Page<Product> productPage = productService.getProductList(page, 9);
//			System.out.println(productPage);
//			System.out.println("Total Elements: " + productPage.getTotalElements());
//			System.out.println("Total Pages: " + productPage.getTotalPages());
//			System.out.println("Page Content: " + productPage.getContent());
//			return ResponseEntity.ok(productPage);
//		} catch (Exception e) {
//			// 예외 처리
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
//		}
//	}

	@GetMapping("/main")
	public ResponseEntity<?> getProductList(@RequestParam int page,@RequestParam String keyword) throws Exception {
		try {
			Page<Product> productPage = null;
			if(keyword.isEmpty()){
				productPage = productService.getProductList(page, 9);
			} else {
				productPage = productService.getSearchProduct(page, 9,keyword);
			}
			return ResponseEntity.ok(productPage);
		} catch (Exception e) {
			// 예외 처리
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
		}
	}
}
