# Clozet

### 쇼핑몰 프로젝트 클로젯



사용자들이 원하는 제품을 찾아보고 주문하며 결제할 수 있는 쇼핑몰 프로그램

스프링 부트와 리액트를 기반으로 구축하여 서버 사이드 기능과 RESTful한 싱글 페이지 어플리케이션 구현





### 시스템 요구사항

- 소셜 로그인

- 로그아웃
- 사용자의 정보는 카카오에 저장된 정보를 가져옴
- 상품 리스트 조회시 페이징 기법으로 무한스크롤 적용
- 상품 상세 조회하여 상품의 썸네일, 하위 이미지, 가격, 옵션, 상품 정보를 조회
- 키워드를 입력하여 상품을 검색할 수 있어야 함
- 상품을 선택하여 장바구니에 넣을 수 있어야 함
- 상품을 구매할 수 있어야 함
- 상품 구매 시 결제사를 선택할 수 있어야 함
- 상품 결제 완료 페이지를 조회할 수 있어야 함
- 상품 장바구니 담기와 구매시, 재고를 판단하여 부족하면 수행 불가해야 함
- 관리자는 상품을 등록할 때, 상품의 수량과 사이즈, 이미지를 업로드 해야 함
- [상세 분석설계서](https://drive.google.com/file/d/12XzF4ZF-jzupZFS3t7lF6mGL3Gth6ICI/view?usp=drive_link)





### 기능구현

`서버 호스팅 비용이 부담되어 배포중지`



![main](https://github.com/ungyuun/Clozet/assets/95204319/2eb706b4-c952-44b2-a499-518706213ecd)



- 상품 리스트 조회  URL : http://www.clozet.shop:3000/

  - 상품 상세조회 페이지로 이동
  - 상품 검색
  - 장바구니 이동
  - 내 정보 조회
  - 카카오 로그인
  - 상품 등록

  

---



![detail](https://github.com/ungyuun/Clozet/assets/95204319/b26c409c-dab7-4162-8003-4c6358472f1c)

![addcart](https://github.com/ungyuun/Clozet/assets/95204319/21aac364-dfb7-42ff-9f23-cd3fd9e51230)

![left](https://github.com/ungyuun/Clozet/assets/95204319/2d08edbb-6dea-44f3-a5e4-e9776b8ccbd1)



- 상품 상세 조회  URL : http://www.clozet.shop:3000/product/2

  상품 리스트에서 상품을 클릭하여 상품 상세조회 페이지 이동. 해당 페이지에서 상품 옵션과 수량을 선택하여 장바구니에 담거나, 결제할 수 있음.

  상품 재고보다 더 많은 물품 구매, 장바구니 담기를 수행하면 수행 불가 알림창이 나옴.



---



![cart](https://github.com/ungyuun/Clozet/assets/95204319/19da2f32-f7df-4290-9ae1-f2e59f2ca56b)

- 이름 : 장바구니 리스트 조회  URL : http://www.clozet.shop:3000/cart

  회원 본인의 장바구니를 조회, 장바구니에 담았던 옵션과 수량을 수정가능하고, 삭제 가능하다.

  장바구니의 상품을 선택하여 결제 페이지로 이동가능. 상품 재고보다 더 많은 물품 구매, 장바구니 담기를 수행하면 수행 불가 알림창이 나옴.

  

---



![purchasepage](https://github.com/ungyuun/Clozet/assets/95204319/b896b8f7-d07d-447b-924f-af09369c369d)

![payment](https://github.com/ungyuun/Clozet/assets/95204319/845e7a77-c18c-4e09-aa20-196ce64b9a11)
![tosspay](https://github.com/ungyuun/Clozet/assets/95204319/492683ca-99a5-4018-9db4-633c6be98f98)



- 이름 : 상품 결제 페이지  URL: http://www.clozet.shop:3000/purchase/reciept

  장바구니에서 물품을 구매하거나, 상품 상세 조회 페이지에서 상품 결제를 진행했을 때 랜더링 되는 페이지. 
  배송지를 선택하고, 결제 옵션을 선택하여 결제를 할 수 있음. PortOne API를 사용하여 카카오페이와 토스페이 테스트 결제가 가능하다.



---



![purchasedone](https://github.com/ungyuun/Clozet/assets/95204319/e12ed958-ca38-4cde-9e29-1853040b94ca)



- 이름 : 상품 영수증  URL: http://www.clozet.shop:3000/purchase/success 

  물품 구매 성공시 랜더링 되는 페이지. 상품 거래 코드와 거래 일시, 상품의 정보가 표시된다.



---



![userPage](https://github.com/ungyuun/Clozet/assets/95204319/31a87683-df2f-4630-a183-ec1c6ab45e62)
![uerpageupdate](https://github.com/ungyuun/Clozet/assets/95204319/4f329a6c-52b6-44d0-8b7a-363728e0c008)



- 이름 : 내 정보 수정  URL: http://www.clozet.shop:3000/user/info/my

  소셜로그인을 통해 카카오에 저장된 정보를 가져와 정보를 조회할 수있다. 해당 페이지에서 배송지를 설정하여 배송정보를 수정할 수있다.



---



![post](https://github.com/ungyuun/Clozet/assets/95204319/a3d946b2-151e-44f6-b8bb-8bc6a871c62f)



- 이름 : 내 정보 수정_우편 주소 설정  URL: http://www.clozet.shop:3000/user/info/my

  다음 우편주소 API를 사용하여 배송지를 설정할 수 있음.

  

---



![search](https://github.com/ungyuun/Clozet/assets/95204319/2f6545d4-602d-4a9e-814d-17500b528a95)



- 이름 : 상품 검색  URL: http://www.clozet.shop:3000/purchase/reciept

  상품 리스트 조회 페이지에서 키워드를 검색하여 해당 키워드가 포함된 상품을 검색할 수 있다.

  

---



![add1](https://github.com/ungyuun/Clozet/assets/95204319/499a52d5-6577-4513-be71-44736aa41f1d)
![add2](https://github.com/ungyuun/Clozet/assets/95204319/f4b5bc7d-ff1d-4fb2-ba32-6c45822a4436)



- 이름 : 상품 등록  URL: http://www.clozet.shop:3000/product/form

  관리자는 상품 등록을 할 수 있다. 상품의 이름, 가격, 카테고리와 상품 설명을 입력한다.

  하단에 상품의 썸네일과 하위 이미지, 옵션과 가격 수량을 적어 상품을 등록한다.



---





### Web Architecture

![architecture](https://github.com/ungyuun/Clozet/assets/95204319/a1b42512-a64f-4a46-ae0d-ee7625eb9ace)





