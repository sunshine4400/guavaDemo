/**  
 * @Title: Stock.java 
 * @Package com.dangdang.pdl.api.data.proxy.model 
 * @Description: 库存信息  
 * @author jiangcheng 
 * @date 2016年6月7日 下午2:51:47  
 * @Copyright 当当信息技术有限公司 
 * @version V1.0 
*/
package com.syswin.guava.collect;

import java.io.Serializable;

/**
 * @ClassName: Stock 
 * @Description: 库存信息  
 * @author jiangcheng 
 * @date 2016年6月7日 下午2:51:47
 * @version V1.0   
 */
public class Stock implements Serializable,Cloneable{
	private static final long serialVersionUID = 5284315763056594542L;
	private int storeId;//仓库编号
	private int stock;//实物
	private int isPresaleStock;//是否预售库存
	private int stockType;//无用，库存类型
	private int reserveQuantity;//网仓保留库存数
	private int saleQuantityTs;//暂存
	private int saleQuantityAllot;//在途
	//**************以下为配货系统自定义字段************************
	private int storeType;//自定义的仓库类型，实物、预售。暂存、在途
	private int localWarehouseId;//自定义 本地仓Id
	private int pickCount; //实际配货数量
	
	public Stock() {
		
	}
	public Stock(Integer storeId, Integer stockType, Integer stock, Integer isPresaleStock) {
		this.storeId = storeId;
		this.stockType = stockType;
		this.stock = stock;
		this.isPresaleStock = isPresaleStock;
	}
	/** 
	 * storeId 
	 * @return  the storeId 
	 * 
	 */
	public int getStoreId() {
		return storeId;
	}
	/** 
	 * @param storeId the storeId to set
	 */
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	/** 
	 * stock 
	 * @return  the stock 
	 * 
	 */
	public int getStock() {
		return stock;
	}
	/** 
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
	/** 
	 * isPresaleStock 
	 * @return  the isPresaleStock 
	 * 
	 */
	public int getIsPresaleStock() {
		return isPresaleStock;
	}
	/** 
	 * @param isPresaleStock the isPresaleStock to set
	 */
	public void setIsPresaleStock(int isPresaleStock) {
		this.isPresaleStock = isPresaleStock;
	}
	/** 
	 * stockType 
	 * @return  the stockType 
	 * 
	 */
	public int getStockType() {
		return stockType;
	}
	/** 
	 * @param stockType the stockType to set
	 */
	public void setStockType(int stockType) {
		this.stockType = stockType;
	}
	/** 
	 * reserveQuantity 
	 * @return  the reserveQuantity 
	 * 
	 */
	public int getReserveQuantity() {
		return reserveQuantity;
	}
	/** 
	 * @param reserveQuantity the reserveQuantity to set
	 */
	public void setReserveQuantity(int reserveQuantity) {
		this.reserveQuantity = reserveQuantity;
	}
	/** 
	 * saleQuantityTs 
	 * @return  the saleQuantityTs 
	 * 
	*/
	public int getSaleQuantityTs() {
		return saleQuantityTs;
	}
	/** 
	 * @param saleQuantityTs the saleQuantityTs to set
	*/
	public void setSaleQuantityTs(int saleQuantityTs) {
		this.saleQuantityTs = saleQuantityTs;
	}
	/** 
	 * saleQuantityAllot 
	 * @return  the saleQuantityAllot 
	 * 
	*/
	public int getSaleQuantityAllot() {
		return saleQuantityAllot;
	}
	/** 
	 * @param saleQuantityAllot the saleQuantityAllot to set
	*/
	public void setSaleQuantityAllot(int saleQuantityAllot) {
		this.saleQuantityAllot = saleQuantityAllot;
	}
	/** 
	 * storeType 
	 * @return  the storeType 
	 * 
	*/
	public Integer getStoreType() {
		return storeType;
	}
	/** 
	 * @param storeType the storeType to set
	*/
	public void setStoreType(int storeType) {
		this.storeType = storeType;
	}
	/** 
	 * localWarehouseId 
	 * @return  the localWarehouseId 
	 * 
	*/
	public int getLocalWarehouseId() {
		return localWarehouseId;
	}
	/** 
	 * @param localWarehouseId the localWarehouseId to set
	*/
	public void setLocalWarehouseId(int localWarehouseId) {
		this.localWarehouseId = localWarehouseId;
	}
	/** 
	 * 配货数量
	*/
	public int getPickCount() {
		return pickCount;
	}
	/** 
	 * @param pickCount the pickCount to set
	*/
	public void setPickCount(int pickCount) {
		this.pickCount = pickCount;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Stock) {
			Stock st = (Stock) obj;
			String key = this.storeId + "_" + this.storeType;
			String eqKey = st.getStoreId() + "_" + st.getStoreType();
			if (key.equals(eqKey)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Stock clone() throws CloneNotSupportedException {
		return (Stock)super.clone();
	}
}
