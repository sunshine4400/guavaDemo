package com.syswin.guava.collect;

import java.io.Serializable;
import java.util.List;

/**
 * @author suntaojs
 * @version V1.0
 * @ClassName: PackageInfo
 * @Description: 包裹类
 * @date 2016-8-2 14:10:24
 */
public class PackageInfo implements Serializable,Cloneable{
    /**
     * @Fields serialVersionUID: 唯一标示
     */
    private static final long serialVersionUID = 3369858763458155678L;
    private int cartItemCount;//该包裹中商品的数量 by:jiangcheng
    private boolean haveGm;//包裹中是否有百货 by:jiangcheng
    private boolean havePublication;//包裹中是否有图书 by:jiangcheng
    private int packageId;//包裹编号
    private Integer pickWarehouseId;//配货仓编号
    private Integer sendWarehouseId;//发货仓编号
    private int isJitWarehouse;//是否J仓
    private int isJitPutWarehouse;//是否J仓入库
    private int isFdcWarehouse;//是否fdc
    private int isShopPackage;//是否商家包裹
    private int isEbook;//是否电子书
    private int warehouseType;//仓类型
    private int isSinglePackage;//是否拆单商品
    private int isDirectSend;//是否直发
    private int isPresaleOrder;//是否预售订单
    private int isDepositPresaleOrder;//定金预售
    private int isDivisionPackageOrder;//分合包标志
    private int orderItemsType;//订单类型  根据仓库类型确定，0-百货，1-图书, 2-图百混合 by:jiangcheng 合包或者直发移仓的时候进行计算
    private int isTemporaryOrTransport;//是否暂存在途,0-普通包裹 100-暂存包裹  200-在途包裹 by:jiangcheng
    private int isMovePackageOrder;//是否可移仓 0可移 1不可移(在包裹上标注)  移仓时处理
    private int isJoinablePackage;//单独包裹，1不参与合包计算
    private int mediumScope;//介质需要获取根据品的介质来定
    private int preSaleType;//预售标识
    private int maxSingleProductCount;// 最大单品数量
    private List<SendProduct> productList;//包裹里的商品

    public PackageInfo(Integer  sendWarehouseId,Integer pickWarehouseId, int isJitWarehouse, int isJitPutWarehouse) {
        this.pickWarehouseId = pickWarehouseId;
        this.sendWarehouseId = sendWarehouseId;
        this.isJitWarehouse = isJitWarehouse;
        this.isJitPutWarehouse = isJitPutWarehouse;
    }

    public int getMaxSingleProductCount() { return maxSingleProductCount; }

    public void setMaxSingleProductCount(int maxSingleProductCount) { this.maxSingleProductCount = maxSingleProductCount; }

    public int getPreSaleType() {
        return preSaleType;
    }

    public void setPreSaleType(int preSaleType) {
        this.preSaleType = preSaleType;
    }

    public int getIsShopPackage() { return isShopPackage; }

    public void setIsShopPackage(int isShopPackage) { this.isShopPackage = isShopPackage; }

    public Integer getPickWarehouseId() {
        return pickWarehouseId;
    }

    public void setPickWarehouseId(Integer pickWarehouseId) {
        this.pickWarehouseId = pickWarehouseId;
    }

    public Integer getSendWarehouseId() {
        return sendWarehouseId;
    }

    public void setSendWarehouseId(Integer sendWarehouseId) {
        this.sendWarehouseId = sendWarehouseId;
    }

    public int getMediumScope() {
        return mediumScope;
    }

    public void setMediumScope(int mediumScope) {
        this.mediumScope = mediumScope;
    }

    public PackageInfo() {
    }

    public List<SendProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<SendProduct> productList) {
        this.productList = productList;
    }

    public int getIsJoinablePackage() {
        return isJoinablePackage;
    }

    public void setIsJoinablePackage(int isJoinablePackage) {
        this.isJoinablePackage = isJoinablePackage;
    }

    public int getIsMovePackageOrder() {
        return isMovePackageOrder;
    }

    public void setIsMovePackageOrder(int isMovePackageOrder) {
        this.isMovePackageOrder = isMovePackageOrder;
    }


    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }


    public int getIsEbook() {
        return isEbook;
    }

    public void setIsEbook(int isEbook) {
        this.isEbook = isEbook;
    }

    public int getIsJitWarehouse() {
        return isJitWarehouse;
    }

    public void setIsJitWarehouse(int isJitWarehouse) {
        this.isJitWarehouse = isJitWarehouse;
    }

    public int getIsJitPutWarehouse() {
        return isJitPutWarehouse;
    }

    public void setIsJitPutWarehouse(int isJitPutWarehouse) {
        this.isJitPutWarehouse = isJitPutWarehouse;
    }

    public int getIsFdcWarehouse() {
        return isFdcWarehouse;
    }

    public void setIsFdcWarehouse(int isFdcWarehouse) {
        this.isFdcWarehouse = isFdcWarehouse;
    }

    public int getWarehouseType() {
        return warehouseType;
    }

    public void setWarehouseType(int warehouseType) {
        this.warehouseType = warehouseType;
    }

    public int getIsSinglePackage() {
        return isSinglePackage;
    }

    public void setIsSinglePackage(int isSinglePackage) {
        this.isSinglePackage = isSinglePackage;
    }

    public int getIsDirectSend() {
        return isDirectSend;
    }

    public void setIsDirectSend(int isDirectSend) {
        this.isDirectSend = isDirectSend;
    }

    public int getIsPresaleOrder() {
        return isPresaleOrder;
    }

    public void setIsPresaleOrder(int isPresaleOrder) {
        this.isPresaleOrder = isPresaleOrder;
    }

    public int getIsDepositPresaleOrder() {
        return isDepositPresaleOrder;
    }

    public void setIsDepositPresaleOrder(int isDepositPresaleOrder) {
        this.isDepositPresaleOrder = isDepositPresaleOrder;
    }

    public int getIsDivisionPackageOrder() {
        return isDivisionPackageOrder;
    }

    public void setIsDivisionPackageOrder(int isDivisionPackageOrder) {
        this.isDivisionPackageOrder = isDivisionPackageOrder;
    }

	/** 
	 * cartItemCount 
	 * @return  the cartItemCount 
	 * 
	*/
	public int getCartItemCount() {
		return cartItemCount;
	}

	/** 
	 * @param cartItemCount the cartItemCount to set
	*/
	public void setCartItemCount(int cartItemCount) {
		this.cartItemCount = cartItemCount;
	}

	/** 
	 * haveGm 
	 * @return  the haveGm 
	 * 
	*/
	public boolean isHaveGm() {
		return haveGm;
	}

	/** 
	 * @param haveGm the haveGm to set
	*/
	public void setHaveGm(boolean haveGm) {
		this.haveGm = haveGm;
	}

	/** 
	 * havePublication 
	 * @return  the havePublication 
	 * 
	*/
	public boolean isHavePublication() {
		return havePublication;
	}

	/** 
	 * @param havePublication the havePublication to set
	*/
	public void setHavePublication(boolean havePublication) {
		this.havePublication = havePublication;
	}

	/** 
	 * orderItemsType 
	 * @return  the orderItemsType 
	 * 
	*/
	public int getOrderItemsType() {
		return orderItemsType;
	}

	/** 
	 * @param orderItemsType the orderItemsType to set
	*/
	public void setOrderItemsType(int orderItemsType) {
		this.orderItemsType = orderItemsType;
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
    public PackageInfo clone(){
        try {
            return (PackageInfo)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PackageInfo) {
            PackageInfo packageInfo = (PackageInfo) obj;
            return this.sendWarehouseId.equals(packageInfo.sendWarehouseId);
        }
        return super.equals(obj);
     }

    }
