package com.syswin.guava.collect;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TableTest extends TestCase{

    /**
     * Table是Guava提供的一个接口 Interface Table<R,C,V>，由rowKey+columnKey+value组成
     * HashBasedTable：基于HashMap<R, HashMap<C, V>>的实现。
     *TreeBasedTable：基于TreeMap<R, TreeMap<C, V>>的实现。
     *ImmutableTable：基于ImmutableMap<R, ImmutableMap<C, V>>的实现。（注意，ImmutableTable已对稀疏和密集集合做了优化）
     *ArrayTable：ArrayTable是一个需要在构建的时候就需要定下行列的表格。这种表格由二维数组实现，这样可以在密集数据的表格的场合，提高时间和空间的效率。
     */
	public void test(){
        //商品对应的库存信息 key为商品的productId
        Map<Long,Map<Integer,List<Stock>>> prodcutStockMap = new HashMap<Long,Map<Integer,List<Stock>>>();
        //商品对应的库存信息 key为商品的productId,warehouseId
        Table<Integer, Integer, Stock> productWarehouseStockListTable = HashBasedTable.create();
        //商品Id,仓库Id,库存数
		Table<Integer, Integer, Integer> productWarehouseStockTable = HashBasedTable.create();
        productWarehouseStockTable.put(111,15,20);
        productWarehouseStockTable.put(222,15,2);
        productWarehouseStockTable.put(222,17,3);
        productWarehouseStockTable.put(333,15,1);
        productWarehouseStockTable.put(333,30,10);
        productWarehouseStockTable.put(333,30,45);
        //获取ID为22的商品，在17仓的数量：3
        Integer stockCount = productWarehouseStockTable.get(222,17);
        //获取ID为888的商品，在17仓的数量：null
        Integer stockCount1 = productWarehouseStockTable.get(888,17);
        //转换为jdk的数据结构:{222={17=3, 15=2}, 111={15=20}, 333={30=10, 15=1}}
        Map<Integer, Map<Integer, Integer>> productWarehouseStockMap = productWarehouseStockTable.rowMap();
        //获取所有的商品Id:[222, 111, 333]
        Set<Integer> productIdsSet =  productWarehouseStockTable.rowKeySet();
        //商品ID为333中的仓库和库存数:{30=45, 15=1}
        Map<Integer,Integer> warehouseStockMap = productWarehouseStockTable.row(333);
	}




    //System.out.println(stockCount);
    //System.out.println(stockCount1);
    //System.out.println(productWarehouseStockMap);
    //System.out.println(productIdsSet);
    //System.out.println(warehouseStockMap);


    //Table<Integer, Integer, Stock> productWarehouseStockListTable = HashBasedTable.create();
    //Stock stock = new Stock(1,1,1,1);
    //productWarehouseStockListTable.put(777,15,stock);
    //   for (int row = 0; row < 10; row++) {
    //       for (int column = 0; column < 5; column++) {
    //           table.put(row, column, "value of cell (" + row + "," + column + ")");
    //       }
    //   }
    //   for (int row=0;row<table.rowMap().size();row++) {
    //       Map<Integer,String> rowData = table.row(row);
    //       for (int column =0;column < rowData.size(); column ++) {
    //           System.out.println("cell(" + row + "," + column + ") value is:" + rowData.get(column));
    //       }
    //   }
    //Stock sotck = productWarehouseStockListTable.get()
}
