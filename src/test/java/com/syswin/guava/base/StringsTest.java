package com.syswin.guava.base;

import com.google.common.base.Strings;

import junit.framework.TestCase;

import static com.google.common.base.Strings.commonPrefix;
import static com.google.common.base.Strings.repeat;

public class StringsTest extends TestCase{

	/**
	 * 将""转换成null
	 */
	public void test1(){
		String str = "";
		System.out.println(Strings.emptyToNull(str));
	}
	
	/**
	 * 将null转换成""
	 */
	public void test2(){
		String str = null;
		System.out.println(Strings.nullToEmpty(str));
	}
	
	/**
	 * 判读是否为空
	 */
	public void test3(){
		String str = null;
		System.out.println(Strings.isNullOrEmpty(str));
		
		str = "";
		System.out.println(Strings.isNullOrEmpty(str));

		String str3 = Strings.padEnd("dang", 5, '*');
		String str4 = Strings.padStart("dang", 5, '*');
		System.out.println(str3);
		System.out.println(str4);
		String str5 = repeat("dang", 2);
		System.out.println(str5);
		String a = "11";
		String b = "122";
		String str6 = commonPrefix(a, b);
		System.out.println(str6);


	}
	
	/**
	 * 获取两个字符串相同的前缀或后缀
	 */
	public void test4(){
		String str1 = "this is java crazy";
		String str2 = "this are java crazy";
		System.out.println(commonPrefix(str1, str2));
		System.out.println(Strings.commonSuffix(str1, str2));
	}
	
	/**
	 * 补全字符串
	 */
	public void test5(){
		String str1 = "34";
		String padStartString = Strings.padStart(str1, 4, '0');
		System.out.println(padStartString);
		
		String padEndString = Strings.padEnd(str1, 6, '5');
		System.out.println(padEndString);
	}
	
	/**
	 * 将某个字符串进行重复
	 */
	public void test6(){
		String str1 = "34";
		String str2 = Strings.repeat(str1, 5);
		System.out.println(str2);
		
//		str1 = null;
//		str2 = Strings.repeat(str1, 2);
//		System.out.println(str2);
//		
//		str1 = "";
//		str2 = Strings.repeat(str1, 2);
//		System.out.println(str2);
	}


	public void test7(){
		String a = "0000000000000000";
		String b = "0010";
		String c = Strings.commonPrefix(a,b);
		System.out.println(c);

	}
}
