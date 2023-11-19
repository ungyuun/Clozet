package com.clozet.service.impl;

import com.clozet.Mapper.PurchaseMapper;
import com.clozet.model.dto.PurchaseDto;
import com.clozet.model.entity.Product;
import com.clozet.model.entity.Purchase;
import com.clozet.model.entity.PurchaseList;
import com.clozet.model.entity.PurchaseType;
import com.clozet.repository.PurchaseRepository;
import com.clozet.service.PurchaseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;


@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    @Value("${spring.security.import.impKey}")
    private String impKey;

    @Value("${spring.security.import.impSecretKey}")
    private String impSecret;

    @Override
    public PurchaseDto addPurchase(PurchaseDto purchaseDto) {
//        purchaseDto = purchaseDto.builder().purchaseType(PurchaseType.PURCHASE).build();
        Purchase purchase = purchaseRepository.save(PurchaseMapper.INSTANCE.toEntity(purchaseDto));
        System.out.println("28 : "+purchase.toString());
        return PurchaseMapper.INSTANCE.toDto(purchase);
    }
    @Override
    public Page<Purchase> getPurchaseList(String email, Pageable pageable) {
        Page<Purchase> purchasePage = purchaseRepository.findAllByUserKakaoEmail(email, pageable);

        // 가져온 Purchase 엔티티들에 대해 purchaseList를 로드합니다
        purchasePage.getContent().forEach(purchase -> {
            purchase.getPurchaseList().size(); // purchaseList를 로드
        });

        return purchasePage;
    }
//
//    public String getToken() throws Exception {
//
//        HttpsURLConnection conn = null;
//        URL url = new URL("https://api.iamport.kr/users/getToken");
//
//        conn = (HttpsURLConnection) url.openConnection();
//
//        conn.setRequestMethod("POST");
//        conn.setRequestProperty("Content-type", "application/json");
//        conn.setRequestProperty("Accept", "application/json");
//        conn.setDoOutput(true);
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonObject json = new JsonObject();
//
//        objectMapper.addProperty("imp_key", impKey);
//        objectMapper.addProperty("imp_secret", impSecret);
//
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
//
//        bw.write(json.toString());
//        bw.flush();
//        bw.close();
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
//
//        Gson gson = new Gson();
//
//        String response = gson.fromJson(br.readLine(), Map.class).get("response").toString();
//
//
//        String token = gson.fromJson(response, Map.class).get("access_token").toString();
//
//        br.close();
//        conn.disconnect();
//
//        return token;
//    }
//
//
//    @Override
//    public String paymentInfo(String imp_uid, String access_token) throws IOException, ParseException {
//        return null;
//    }
}
