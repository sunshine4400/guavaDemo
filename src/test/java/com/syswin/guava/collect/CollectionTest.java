package com.syswin.guava.collect;

import com.google.common.collect.*;
import junit.framework.TestCase;

import java.util.*;

public class CollectionTest extends TestCase{

	/**
	 * 集合的初始化
	 */
	public void test2(){
		//jdk
		Set<String> set = new HashSet<String>();
		set.add("one");
		set.add("two");
		set.add("three");

		//guava
		Set<String> set_cp = Sets.newHashSet("one","two","three");
		List<String> list = Lists.newArrayList("one","two","three");
		Map<String, String> map = ImmutableMap.of("ON","TRUE","OFF","FALSE"); //不可变
		//定长
		List<String> lisaat= Lists.newArrayList();
		lisaat.add("aa");
		lisaat.add("aad");
		lisaat.add("saa");
		lisaat.add("aa33");
		lisaat.add("aa34");
		lisaat.add("aa35");
		for (int i = 0; i < lisaat.size(); i++) {
			System.out.println(lisaat.get(i));
		}





	}

	/**
	 * 集合的创建
	 */
	public void test1(){
		//jdk
		Map<String, Map<String, String>> map = new HashMap<String, Map<String,String>>();
		List<List<Map<String, String>>> list = new ArrayList<List<Map<String,String>>>();

		//guava
		Map<String, Map<String, String>> map_cp = Maps.newHashMap();
		List<List<Map<String, String>>> list_cp = Lists.newArrayList();
		Set<String> set = Sets.newHashSet();
		List<String> List= Lists.newLinkedList();
		Map<String,String> personMap= Maps.newHashMap();
		Integer[] intArrays= ObjectArrays.newArray(Integer.class,10);
	}

	public void test7(){
		int aa = Math.round(((float)58 /(float) 203) * 100);
		System.out.println(aa);
	}
}
