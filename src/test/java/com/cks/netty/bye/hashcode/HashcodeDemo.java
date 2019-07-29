package com.cks.netty.bye.hashcode;

import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: cks
 * @Date: Created by 2019/7/19 16:08
 * @Package: com.cks.netty.bye.hashcode
 * @Description:
 */
public class HashcodeDemo {

    public static void main(String[] args) {


    }

//    @Test
//    public void testHashCode() {
//        TestHashCode1 thc11= new TestHashCode1("ming");
//        TestHashCode1 thc12= new TestHashCode1("ming");
//        System.out.println(thc11.hashCode());
//        System.out.println(thc12.hashCode());
//        Map<TestHashCode1,String> thcMap = Maps.newHashMap();
//        thcMap.put(thc11,"thc11");
//        System.out.println(thcMap.get(thc12));
//
//        TestHashCode2 thc21 = new TestHashCode2("ming");
//        TestHashCode2 thc22 = new TestHashCode2("ming");
//        System.out.println(thc21.hashCode());
//        System.out.println(thc22.hashCode());
//        Map<TestHashCode2,String> thc2Map = Maps.newHashMap();
//        thc2Map.put(thc21,"thc21");
//        System.out.println(thc2Map.get(thc22));
//    }
//
//    class TestHashCode1 {
//        private String name;
//        public TestHashCode1(String name) {
//            this.name = name;
//        }
//    }
//
//    class TestHashCode2 {
//        private String name;
//
//        public TestHashCode2(String name) {
//            this.name = name;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o)
//                return true;
//            if (o == null || getClass() != o.getClass())
//                return false;
//            TestHashCode2 that = (TestHashCode2) o;
//            return Objects.equals(name, that.name);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(name);
//        }
//    }

    int count = 0;

    public int sum(int n) {
        if (n == 1){
            return 1;
        }
        count = n + sum(n-1);
        return count;
    }

    @Test
    public void count(){
        System.out.println(sum(100));
    }

}
