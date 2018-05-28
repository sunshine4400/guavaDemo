package com.sunshine.java8;

import junit.framework.TestCase;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author:
 * @Date: 2018-05-28 17:23
 **/
public class OptionalTest extends TestCase {
    public void test1(){
        Stream<String> names = Stream.of("Aaaa","Bbbb","Cccc");
        Optional<String> longest = names.filter(name -> name.startsWith("A")).findFirst();
        longest.ifPresent(name -> {
            String s = name.toUpperCase();
            System.out.println(s);
        });
    }

    public void test2(){
        Stream<String> names = Stream.of("Aaaa","Bbbb","Cccc");
        Optional<String> longest = names.filter(name -> name.startsWith("B")).findFirst();
        Optional<String> lQname = longest.map(String::toUpperCase);
        System.out.println(lQname.toString());
    }

    public void test3(){
        Stream<String> names = Stream.of("Aaaa","Bbbb","Cccc");
        Optional<String> longest = names.filter(name -> name.startsWith("Q")).findFirst();
        String lQname = longest.orElse("Ddddd");
        System.out.println(lQname);
    }

    public void test4(){
        Stream<String> names = Stream.of("Aaaa","Bbbb","Cccc");
        Optional<String> longest = names.filter(name -> name.startsWith("Q")).findFirst();
        String lQname = longest.orElseGet(() -> {
            return "Ddddd";
        });
        System.out.println(lQname);
    }

    public void test5(){
        String aa = null;
        Optional<String> names = Optional.empty();
        names = Optional.of("ccc");
        names = Optional.ofNullable(aa);
        System.out.println(names);
    }

    public void test6(){

        // User user = new User("sun" , 33);
        User user = null;

        String name = Optional.ofNullable(user).map(User :: getName).orElse("taotao");

        System.out.println(name);
    }

    public void test7(){
         Optional<User> optUser = Optional.of(new User("sun",33));
         //Long phoneNum = optUesr.flatMap(User::getPhone).orElse(-1L);
         Long phone = optUser.map(User::getPhone).map(Optional::get).orElse(-1L);
         System.out.println(phone);
        optUser.filter(user ->  user.getAge() > 18).ifPresent(user -> System.out.println("name："+user.getName()));
    }

}
