package Diary.demo;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;

@SpringBootTest
public class Test {
    String t = "76EA5CDA2FFD3D8EBCB16E5446AD8";
    String i = "952008258712-ofadfqepnuq9mjpcls6kolnfbhqiiv3t.apps.googleusercontent.com";
    String s = "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";

    @org.junit.jupiter.api.Test
    void contextLoads() {
    }

    @org.junit.jupiter.api.Test
    void jasypt() {
        String t = "76EA5CDA2FFD3D8EBCB16E5446AD8";
        String i = "952008258712-ofadfqepnuq9mjpcls6kolnfbhqiiv3t.apps.googleusercontent.com";
        String s = "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";
        System.out.println(jasyptEncoding(t));
        System.out.println(jasyptEncoding(i));
        System.out.println(jasyptEncoding(s));
    }

    public String jasyptEncoding(String value) {

        String key = "my_jasypt_key";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);
    }

}
