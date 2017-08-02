package com.syswin.guava.base;

import com.google.common.base.Joiner;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JoinerTest extends TestCase{

	/**
	 * 通过空格将hello和world合并起来
	 */
	public void test1(){
		//
		String joinResult = Joiner.on("#").join(new String[]{"hello","guava"});


        System.out.println(joinResult);
	}
	
	/**
	 * 通过Joiner进行二次合并
	 */
	public void test2(){
		Map<String,String> map = new HashMap<String,String>();
        map.put("a", "b");
		map.put("c","d");
		String mapJoinResult = Joiner.on(",").withKeyValueSeparator("=").join(map);
		System.out.println(mapJoinResult);
	}
	
	/**
	 * 每当我想起将string数组或集合打印出来需要拼接逗号，就感觉特别恶心
	 * 有了guava以后，就变得easy多了
	 */
	public void test3(){
		//对数组进行拼接：hello#guava
		String joinResult = Joiner.on("#").join(new String[]{"hello","guava"});

		String[] strings = new String[]{"1","2","3",null,"4",null};

		//对于null进行打印NA来替换:1,2,3,NA,4,NA
		String str1 = Joiner.on(",").useForNull("NA").join(strings);

		//把null滤掉: 1,2,3,4
		String str2 = Joiner.on(",").skipNulls().join(strings);

		//通过Joiner进行二次合并 map
		Map<String,String> map = new HashMap<String,String>();
		map.put("a", "b");
		map.put("c","d");
		//c=d,a=b
		String mapJoinResult = Joiner.on(",").withKeyValueSeparator("=").join(map);

		//通过Joiner进行二次合并 list
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		//a*b*c
		String listJoinResult = Joiner.on("*").join(list);
		System.out.println(listJoinResult);
	}
}
