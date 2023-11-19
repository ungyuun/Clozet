//실행방법 : cd client 후 npm start

npm run build
serve -s build





localhost 경로 위치 -> 클라우드 배포시 경로 변경필요

Editor 21 line

<u>productDetail에 파일 선택해서 이미지 추가하면 되는데, 하나씩 상품 상세추가 한뒤에 이미지 추가하면 추가됨 </u>
<u>근데 index가 두개 이상일때 파일이 업로드 안됨. 문제 해결하고, 클라우드로 axios 통신을 통해 파일 저장해야함</u>

CartList UI 개선 필요 -> CartList check 개선
```
client
├─ .dockerignore
├─ .gitignore
├─ Dockerfile
├─ nginx.conf
├─ package-lock.json
├─ package.json
├─ public
│  ├─ favicon.ico
│  ├─ images
│  ├─ index.html
│  └─ robots.txt
├─ README.md
├─ src
│  ├─ App.js
│  ├─ components
│  │  ├─ layout
│  │  │  ├─ Header.js
│  │  │  └─ Layout.js
│  │  └─ StockModal.jsx
│  ├─ index.js
│  ├─ pages
│  │  ├─ cart
│  │  │  ├─ CartList.jsx
│  │  │  ├─ CartModal.jsx
│  │  │  └─ CartSpan.jsx
│  │  ├─ common
│  │  │  ├─ About.js
│  │  │  ├─ AxiosInstance.js
│  │  │  ├─ Home.jsx
│  │  │  └─ ImageUpload.js
│  │  ├─ product
│  │  │  ├─ addProduct
│  │  │  │  ├─ AdditionalImage.jsx
│  │  │  │  ├─ DeleteImage.jsx
│  │  │  │  ├─ Editor.js
│  │  │  │  ├─ ProductDetail.js
│  │  │  │  ├─ ProductForm.js
│  │  │  │  ├─ Thumbnail.jsx
│  │  │  │  └─ Title.js
│  │  │  ├─ Banner.jsx
│  │  │  ├─ getProduct
│  │  │  │  ├─ Comment.jsx
│  │  │  │  ├─ Content.jsx
│  │  │  │  ├─ Product.jsx
│  │  │  │  ├─ ProductHeader.jsx
│  │  │  │  └─ ProductOrder.jsx
│  │  │  ├─ main
│  │  │  │  ├─ Card.jsx
│  │  │  │  ├─ End.jsx
│  │  │  │  └─ Main.jsx
│  │  │  └─ ProductRouter.jsx
│  │  ├─ purchase
│  │  │  ├─ addPurchase
│  │  │  │  ├─ PurchaseSpan.jsx
│  │  │  │  ├─ Reciept.jsx
│  │  │  │  └─ Success.jsx
│  │  │  ├─ getPurchase
│  │  │  │  ├─ MyPurchase.jsx
│  │  │  │  └─ PurchaseList.jsx
│  │  │  └─ PurchaseRouter.jsx
│  │  └─ user
│  │     ├─ info
│  │     │  ├─ EditInfo.jsx
│  │     │  ├─ MyInfo.jsx
│  │     │  └─ UserInfo.jsx
│  │     ├─ login
│  │     │  └─ LoginPage.jsx
│  │     └─ UserRouter.jsx
│  ├─ services
│  │  ├─ Certification.js
│  │  ├─ CheckStock.js
│  │  ├─ FormatDateTo.js
│  │  ├─ GeneratePaymentID.js
│  │  ├─ Import.js
│  │  ├─ LoginHandler.js
│  │  ├─ LogoutHandler.js
│  │  ├─ Payment.js
│  │  └─ SeperaterMoney.js
│  ├─ setProxy.js
│  └─ styles
│     ├─ cart.css
│     ├─ header.css
│     ├─ product.css
│     ├─ purchase.css
│     └─ user.css
└─ yarn.lock

```