package com.syswin.guava.collect;

		import com.google.common.collect.*;
		import junit.framework.TestCase;

		import java.util.*;

public class MutliMapTest extends TestCase {

	public void test1() {
		ListMultimap<String, String> myMultimap = ArrayListMultimap.create();
		//ListMultimap<String, Stock> myMultimap = ArrayListMultimap.create();
		// 添加键值对
		myMultimap.put("Fruits", "Bannana");
		//给Fruits元素添加另一个元素
		myMultimap.put("Fruits", "Apple");
		myMultimap.put("Fruits", "Pear");
		myMultimap.put("Vegetables", "Carrot");

		// 获得multimap的size
		int size = myMultimap.size();
		System.out.println(size);  // 4

		// 获得Fruits对应的所有的值
		List<String> fruits = myMultimap.get("Fruits");
		System.out.println(fruits); // [Bannana, Apple, Pear]

		Collection<String> vegetables = myMultimap.get("Vegetables");
		System.out.println(vegetables); // [Carrot]

		//遍历Mutlimap
		for (String value : myMultimap.values()) {
			System.out.println(value);
		}

		// Removing a single value
		myMultimap.remove("Fruits", "Pear");
		System.out.println(myMultimap.get("Fruits")); // [Bannana, Pear]

		// Remove all values for a key
		myMultimap.removeAll("Fruits");
		System.out.println(myMultimap.get("Fruits")); // [] (Empty Collection!)
	}

	public void test2() {
		ImmutableMap<String, Integer> oneMap = ImmutableMap.of("key1", 1, "key2", 2,"key11", 11);
		ImmutableMap<String, Integer> twoMap = ImmutableMap.of("key11", 11, "key2", 2);
		MapDifference<String, Integer> diffHadle = Maps.difference(oneMap, twoMap);
		//共同的元素：{key2=2, key11=11},若无共同Entry，则返回长度为0的Map
		Map<String, Integer> commonMap = diffHadle.entriesInCommon();
		//返回左边的Map中不同或者特有的元素:{key1=1}
		Map<String, Integer> diffOnLeft = diffHadle.entriesOnlyOnLeft();
		//返回右边的Map中不同或者特有的元素：{}
		Map<String, Integer> diffOnRight = diffHadle.entriesOnlyOnRight();
		System.out.println(commonMap  + "      "+diffOnLeft+"        "+diffOnRight);
		//for (Map.Entry<String, Integer> entry : diffOnRight.entrySet()) {
		//	System.out.println("共同Map中key:" + entry.getKey() + "  value:" + entry.getValue());
		//}
		//找出2个Set的不相同的元素和相同的元素，以Set形式返回
		Set<String> oneSet=Sets.newHashSet("111","222","333");
		Set<String> twoSet=Sets.newHashSet("333","444");
		//是得到左边中不同或者特有的元素，[222, 111],若无，则返回长度为0的集合
		Sets.SetView<String> diffSetHandle= Sets.difference(oneSet, twoSet);
		System.out.println("diffSetHandle   "+diffSetHandle);
		Set<String> diffImmutable=diffSetHandle.immutableCopy();
		//java.lang.UnsupportedOperationException
		//diffSetHandle.add("suntao");
		//返回一个不可变的左边Set中特有元素集合的Set拷贝
		Iterator iter=diffSetHandle.iterator();
		while(iter.hasNext()){
			System.out.println("Set的不同元素："+iter.next().toString());
		}
		Sets.SetView<String> commonSet=Sets.intersection(oneSet, twoSet);
		Set<String> commonImmutable=commonSet.immutableCopy();//返回一个不可变的2个Set中共同元素集合的Set拷贝
	}

	public void test(){
		ListMultimap<String, String> ddMultimap = ArrayListMultimap.create();
		// 添加键值对
		ddMultimap.put("peihuo", "jiangcheng");
		ddMultimap.put("peihuo", "wenya");
		ddMultimap.put("promise", "shichun");
		ddMultimap.put("promise", "shihao");
		//获取配货组数集合：[jiangcheng, wenya]
		List<String> peihuoList = ddMultimap.get("peihuo");
		//转换成jdk：{promise=[shihao, shichun], peihuo=[jiangcheng, wenya]}
		Map<String, Collection<String>> ddMap = ddMultimap.asMap();
		//是否存在实体：true
		boolean existEntry = ddMultimap.containsEntry("peihuo","jiangcheng");
		//是否存在key:true
		boolean existKey = ddMultimap.containsKey("peihuo");
		//是否存在value:false
		boolean existValue = ddMultimap.containsValue("xietingfeng");
		Set set = ddMultimap.keySet();
		List list = new ArrayList(set);
		System.out.println(list.toString());
	}

	public void test3(){
		//ListMultimap<Integer, SendProduct> ddMultimap = ArrayListMultimap.create();
		//ddMultimap.put(15,new SendProduct("aaa",1,1));
		//ddMultimap.put(17,new SendProduct("bbb",2,1));
		//ddMultimap.put(17,new SendProduct("ccc",3,1));
		//SendProduct sendProduct = new SendProduct("aaa",5,1);
		////是否存在实体：true
		//boolean existEntry = ddMultimap.containsEntry(1,sendProduct);
		//System.out.println(existEntry);


		ListMultimap<Integer, PackageInfo> ddMultimap = ArrayListMultimap.create();
		ddMultimap.put(15,new PackageInfo(15,15,3,4));
		ddMultimap.put(15,new PackageInfo(30,30,3,4));
		ddMultimap.put(17,new PackageInfo(30,30,3,4));
		//PackageInfo packageInfo  = new PackageInfo(17,15,3,4);
		//boolean existEntry = ddMultimap.containsEntry(15,packageInfo);
		PackageInfo packageInfo1  = new PackageInfo(30,17,3,4);
		boolean existEntry1 = ddMultimap.containsEntry(15,packageInfo1);

		boolean existValue2 = ddMultimap.containsValue(packageInfo1);
		System.out.println(existValue2);
	}

	public void test4(){
		double aa = 26;
		double bb = 234;
		double dd = aa/bb;
		System.out.println(new Double(Math.round(0.7)).intValue());
	}
}