package com.syswin.guava.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import junit.framework.TestCase;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ImmutableTest extends TestCase{

	/**
	 * 注意：不可变集合的使用和普通集合一样，只是不能使用他们的add，remove等修改集合的方法。
	 * 为什么要用immutable对象？immutable对象有以下的优点：
	 *1.对不可靠的客户代码库来说，它使用安全，可以在未受信任的类库中安全的使用这些对象
	 *2.线程安全的：immutable对象在多线程下安全，没有竞态条件
	 *3.不需要支持可变性, 可以尽量节省空间和时间的开销. 所有的不可变集合实现都比可变集合更加有效的利用内存 (analysis)
	 *4.可以被使用为一个常量，并且期望在未来也是保持不变的

	 　　immutable对象可以很自然地用作常量，因为它们天生就是不可变的对于immutable对象的运用来说，它是一个很好的防御编程（defensive programming）的技术实践。
	 */
	
	/**
	 * 使用builder进行创建
	 */
	public void test1(){
		Set<String> immutableNamedColors = ImmutableSet.<String>builder()
	            .add("red", "green","black","white","grey")
	            .build();
		//一旦不可变集合进行了创建就不可以在操作了
		//immutableNamedColors.add("yellow");
		for (String color : immutableNamedColors) {
	        System.out.println(color);
	    }
	}
	
	/**
	 * 使用of静态方法进行创建
	 */
	public void test2(){
		Set<String> immutableNamedColors = ImmutableSet.of("aa", "bb", "cc");
		for (String color : immutableNamedColors) {
			System.out.println(color);
		}
	}
	
	/**
	 * 第三种方法使用copyOf静态方法创建：
	 */
	public void test3(){
		Set<String> immutableNamedColors = ImmutableSet.copyOf(new String[]{"red","green","black","white","grey"});
		for (String color : immutableNamedColors) {
			System.out.println(color);
		}
	}

	public void testJDKImmutable() {
		List<String> list = Lists.newArrayList("aa", "bb", "cc");
		//JDK的不可变集合
		List<String> unmodifiableList = Collections.unmodifiableList(list);
		//不能执行add操作，报出异常：java.lang.UnsupportedOperationException
		unmodifiableList.add("dd");
		list.add("dd");
		//list内容改变，不可变集合同步变更：size=4 unmodifiableList： [aa, bb, cc, dd, dd]
		int unmodifiableListSise = unmodifiableList.size();
	}


	/**
	 * guava的不可变集合
	 */
	public void test4() {
		List<String> list = Lists.newArrayList("aa", "bb", "cc");
		List<String> unmodifiableList = ImmutableList.copyOf(list);
		//beforeChangeSize = 3
		int beforeChangeSize = unmodifiableList.size();
		list.add("dd");
		//afterChangeSize = 3
		int afterChangeSize = unmodifiableList.size();
		//不能执行add操作，报出异常：java.lang.UnsupportedOperationException
		unmodifiableList.add("ee");
	}
		}
