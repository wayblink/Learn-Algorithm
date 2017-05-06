package com.way.rsa;

public class main {
    public static void main(String[] args){
        Test01 test = new Test01();
        
//        System.out.println(Test.privateKey);
//        String msg = new String(Test.resultBytes);
        
        byte[] decBytes = Test01.decrypt(Test01.privateKey, Test01.resultBytes);
        String dec = new String(decBytes);
        
        System.out.println("用私钥加密后的结果是:" + dec);
    }
}
