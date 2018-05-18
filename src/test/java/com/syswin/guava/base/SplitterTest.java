package com.syswin.guava.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import junit.framework.TestCase;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SplitterTest extends TestCase{

	/**
	 * 通过正则表达式进行拆分
	 */
	public void test1(){
		String str = "this is my java program!";
		Splitter split = Splitter.onPattern("[o| ]+"); //支持正则
		Iterable<String> it = split.split(str);
		
		split.omitEmptyStrings(); //排除空字符
		split.trimResults(); //对截取后字符串进行trim
		for(String temp : it){
			System.out.println(temp);
		}
	}
	/**
	 * Splitter做二次拆分
	 */
	public void test2(){
		String toSplitString = "a=b;c=d,e=f";
        Map<String,String> kvs = Splitter.onPattern("[,;]{1,}").withKeyValueSeparator('=').split(toSplitString);
        for (Map.Entry<String,String> entry : kvs.entrySet()) {
            System.out.println(String.format("%s=%s", entry.getKey(),entry.getValue()));
        }
	}
	
	/**
	 * 
	 */
	public void test3(){
		//limit(int) 限制拆分出来的数量
		String str = "hello is world heng";
		List<String> list = Lists.newArrayList(Splitter.on(" ").limit(2).split(str));
		System.out.println(list);
		list = Splitter.on(" ").limit(3).splitToList(str);
		System.out.println(list);
	}
	
	/**
	 * 
	 */
	public void test4(){
		//字符串转换成list
		Splitter splitter = Splitter.on(",")
				.omitEmptyStrings()//去除结果集中的空串
				.trimResults();//去除前后端空格
		String modeIds = " 3,4,5,11,,12 ";
		Iterable<String> it = splitter.split(modeIds);
		//3, 4, 5, 11, 12
		List<String> result= Lists.newArrayList(it);
		System.out.println(result);
	}
	
	/**
	 * 根据,号分割之后，再用=号进行拆分 返回一个map
	 */
	public void test5(){
		String str = "long=2,lat=3";
		Splitter.MapSplitter splitter = Splitter.on(",").omitEmptyStrings().trimResults().withKeyValueSeparator('=');
		Map testmap = splitter.split(str);
		Set keySet= testmap.keySet();
		System.out.println(keySet);
	}

	/**
	 * 去掉字符串中的全部英文
	 */
	public void test6(){
		String str = "1,2,,d53c,4f,5e";
		Splitter splitter = Splitter.on(",").trimResults(CharMatcher.JAVA_LETTER).omitEmptyStrings();
		Iterable iterable  = splitter.split(str);
		System.out.println(Lists.newArrayList(iterable));
		
	}
	public void test7(){
		
	}
	
	
}
