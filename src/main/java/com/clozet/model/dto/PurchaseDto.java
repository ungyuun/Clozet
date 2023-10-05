package com.clozet.model.dto;



import java.sql.Date;


public class PurchaseDto {

	private Long rownum;
	private UserDto buyer;
	private String dlvyAddr;
	private Date dlvyDate;
	private String dlvyRequest;
	private Date orderDate;
	private String paymentOption;
	private ProductDto purchaseProd;
	private String receiverName;
	private String receiverPhone;
	private String tranCode;
	private Long tranNo;

	public PurchaseDto(){
	}

	public Long getRownum() {
		return rownum;
	}

	public void setRownum(Long rownum) {
		this.rownum = rownum;
	}

	public UserDto getBuyer() {
		return buyer;
	}
	public void setBuyer(UserDto buyer) {
		this.buyer = buyer;
	}
	public String getDlvyAddr() {
		return dlvyAddr;
	}
	public void setDlvyAddr(String dlvyAddr) {
		this.dlvyAddr = dlvyAddr;
	}
	public Date getDlvyDate() {
		return dlvyDate;
	}
	public void setDlvyDate(Date date) {
		this.dlvyDate = date;
	}
	public void setDlvyDate(java.util.Date date) {

		this.dlvyDate = new Date(date.getTime());
	}
	public String getDlvyRequest() {
		return dlvyRequest;
	}
	public void setDlvyRequest(String dlvyRequest) {
		this.dlvyRequest = dlvyRequest;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getPaymentOption() {
		return paymentOption;
	}
	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}
	public ProductDto getPurchaseProd() {
		return purchaseProd;
	}
	public void setPurchaseProd(ProductDto purchaseProd) {
		this.purchaseProd = purchaseProd;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getTranCode() {
		return tranCode;
	}
	public void setTranCode(String string) {
		this.tranCode = string;
	}
	public Long getTranNo() {
		return tranNo;
	}
	public void setTranNo(Long tranNo) {
		this.tranNo = tranNo;
	}

	@Override
	public String toString() {
		return "rownum : "+rownum+"PurchaseVO [buyer=" + buyer + ", dlvyAddr=" + dlvyAddr
				+ ", dlvyDate=" + dlvyDate + ", dlvyRequest=" + dlvyRequest
				+ ", orderDate=" + orderDate + ", paymentOption="
				+ paymentOption + ", purchaseProd=" + purchaseProd
				+ ", receiverName=" + receiverName + ", receiverPhone="
				+ receiverPhone + ", tranCode=" + tranCode + ", tranNo="
				+ tranNo + "]";
	}


}