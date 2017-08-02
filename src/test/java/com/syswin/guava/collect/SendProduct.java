/**  
 * @Title: SendProduct.java
 * @Package com.dangdang.pdl.api.business.model
 * @Description: 临时商品对象
 * @author sunshine4400
 * @date 2016-8-8 16:52:22
 * @version V1.0
*/
package com.syswin.guava.collect;

import java.io.Serializable;

/**
 * @ClassName: SendProduct
 * @Description: 临时的产品对象
 * @author suntaojs
 * @date 2016-8-8 16:45:42
 * @version V1.0   
 */
public class SendProduct implements Serializable,Cloneable{
	private static final long serialVersionUID = -6532103853970607288L;
	private String uniqueId;//唯一标识
	private long productId;
	private int isGiftProduct;
	private int isExchangeProduct;
	private int preSale;//预售
	private int pickingWarehouseId;//配货仓编号
	private int presaleType;//预售类型
	private int isBindProduct;//绑定商品
	private int isSinglepackage;//不可拆单
	private int isDirectSend;//不可移仓
	private int mediumScope;//介质
	private int productType;//商品类型
	private int preSaleProductCount;//预售品的数量
	private int notPreSaleProductCount;//不是预售品的数量（实物+暂存+在途)
	private int productCount;//商品数量
	private long parentProductId;//父商品Id,如有请赋值,如没有请置为0 by:jiangcheng 从请求中的复制
	private String promotionType;//商品的促销类型，该值从商品上直接拿来赋值就可以by:jiangcheng
	//private List<GiftProduct> giftProductList;//赠品列表by:jiangcheng 从请求中的复制
	//private List<BindProduct> bindProductList;//虚拟捆绑列表by:jiangcheng  从请求中的复制
	//private List<MoveFromInfo> moveFromWarehouseList;//移仓信息by:jiangcheng
	private int isTemporaryOrTransport;//是否暂存在途  0-普通  100-暂存  200-在途  by:jiangcheng
	

	public SendProduct() {
	}

    public SendProduct( String uniqueId, int pickingWarehouseId, int productCount) {
        this.uniqueId = uniqueId;
        this.pickingWarehouseId = pickingWarehouseId;
        this.productCount = productCount;
    }

    public int getProductCount() { return productCount; }

	public void setProductCount(int productCount) { this.productCount = productCount; }

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public int getPickingWarehouseId() {
		return pickingWarehouseId;
	}

	public void setPickingWarehouseId(int pickingWarehouseId) {
		this.pickingWarehouseId = pickingWarehouseId;
	}


	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getIsGiftProduct() {
		return isGiftProduct;
	}

	public void setIsGiftProduct(int isGiftProduct) {
		this.isGiftProduct = isGiftProduct;
	}

	public int getIsExchangeProduct() {
		return isExchangeProduct;
	}

	public void setIsExchangeProduct(int isExchangeProduct) {
		this.isExchangeProduct = isExchangeProduct;
	}

	public int getPreSale() {
		return preSale;
	}

	public void setPreSale(int preSale) {
		this.preSale = preSale;
	}

	public int getPresaleType() {
		return presaleType;
	}

	public void setPresaleType(int presaleType) {
		this.presaleType = presaleType;
	}

	public int getIsBindProduct() {
		return isBindProduct;
	}

	public void setIsBindProduct(int isBindProduct) {
		this.isBindProduct = isBindProduct;
	}

	public int getIsSinglepackage() {
		return isSinglepackage;
	}

	public void setIsSinglepackage(int isSinglepackage) {
		this.isSinglepackage = isSinglepackage;
	}

	public int getIsDirectSend() {
		return isDirectSend;
	}

	public void setIsDirectSend(int isDirectSend) {
		this.isDirectSend = isDirectSend;
	}

	public int getMediumScope() {
		return mediumScope;
	}

	public void setMediumScope(int mediumScope) {
		this.mediumScope = mediumScope;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public int getPreSaleProductCount() {
		return preSaleProductCount;
	}

	public void setPreSaleProductCount(int preSaleProductCount) {
		this.preSaleProductCount = preSaleProductCount;
	}

	public int getNotPreSaleProductCount() {
		return notPreSaleProductCount;
	}

	public void setNotPreSaleProductCount(int notPreSaleProductCount) {
		this.notPreSaleProductCount = notPreSaleProductCount;
	}

	///**
	// * bindProductList
	// * @return  the bindProductList
	// *
	//*/
	//public List<BindProduct> getBindProductList() {
	//	return bindProductList;
	//}
    //
	///**
	// * @param bindProductList the bindProductList to set
	//*/
	//public void setBindProductList(List<BindProduct> bindProductList) {
	//	this.bindProductList = bindProductList;
	//}
    //
	///**
	// * giftProductList
	// * @return  the giftProductList
	// *
	//*/
	//public List<GiftProduct> getGiftProductList() {
	//	return giftProductList;
	//}
    //
	///**
	// * @param giftProductList the giftProductList to set
	//*/
	//public void setGiftProductList(List<GiftProduct> giftProductList) {
	//	this.giftProductList = giftProductList;
	//}
    //
	///**
	// * moveFromWarehouseList
	// * @return  the moveFromWarehouseList
	// *
	//*/
	//public List<MoveFromInfo> getMoveFromWarehouseList() {
	//	return moveFromWarehouseList;
	//}
    //
	///**
	// * @param moveFromWarehouseList the moveFromWarehouseList to set
	//*/
	//public void setMoveFromWarehouseList(List<MoveFromInfo> moveFromWarehouseList) {
	//	this.moveFromWarehouseList = moveFromWarehouseList;
	//}

	/** 
	 * parentProductId 
	 * @return  the parentProductId 
	 * 
	*/
	public long getParentProductId() {
		return parentProductId;
	}

	/** 
	 * @param parentProductId the parentProductId to set
	*/
	public void setParentProductId(long parentProductId) {
		this.parentProductId = parentProductId;
	}

	/** 
	 * promotionType 
	 * @return  the promotionType 
	 * 
	*/
	public String getPromotionType() {
		return promotionType;
	}

	/** 
	 * @param promotionType the promotionType to set
	*/
	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}

	/** 
	 * isTemporaryOrTransport 
	 * @return  the isTemporaryOrTransport 
	 * 
	*/
	public int getIsTemporaryOrTransport() {
		return isTemporaryOrTransport;
	}

	/** 
	 * @param isTemporaryOrTransport the isTemporaryOrTransport to set
	*/
	public void setIsTemporaryOrTransport(int isTemporaryOrTransport) {
		this.isTemporaryOrTransport = isTemporaryOrTransport;
	}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof SendProduct) {
				SendProduct sendProduct = (SendProduct) obj;
				return this.uniqueId == sendProduct.uniqueId;
			}
			return super.equals(obj);
		}

		@Override
		public SendProduct clone(){
			try {
				return (SendProduct)super.clone();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
}
