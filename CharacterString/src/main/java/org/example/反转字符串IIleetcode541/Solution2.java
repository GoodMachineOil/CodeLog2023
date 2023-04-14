package org.example.反转字符串IIleetcode541;


public class Solution2 {
    public String reverseStr(String s, int k) {
        //StringBuffer 是 Java 中一个可变的字符串类，它允许我们在字符串末尾添加、插入、修改和删除字符，而不会创建新的字符串对象。
        //在 Java 中，StringBuffer 类是线程安全的，因此在多线程环境中使用是安全的。
        // 另外，在 Java 5 及以上版本中，还有一个非线程安全的可变字符串类 StringBuilder，它具有与 StringBuffer 相同的方法和功能，但不保证线程安全。
        StringBuffer result = new StringBuffer();
        int length = s.length();
        int start = 0;
        while(start<length){
            StringBuffer temp = new StringBuffer();
            int firsK = (start+k) > length? length:start+k;
            int secondK = (start+2*k)>length?length:start+2*k;

            temp.append(s.substring(start,firsK));
            result.append(temp.reverse());

            if(start < secondK){
                result.append(s.substring(firsK, secondK));
            }
            start += 2*k;
        }
        return result.toString();
    }
}
