package com.example.project.demo.crypto;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
public class CipherWithGCMParameterSpec {
    public static void main(String[] args) throws Exception {
        String plaintext = "Hello, World!";
        byte[] keyBytes = generateRandomKey(16); // 16字节的随机密钥

        // 创建AES密钥对象
        SecretKey key = new SecretKeySpec(keyBytes, "AES");

        // 创建初始化向量（IV）
        byte[] iv = generateRandomIV(12); // 12字节的随机IV

        // 创建GCMParameterSpec对象
        GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv);

        // 创建Cipher对象并设置为加密模式
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key, gcmSpec);

        // 执行加密操作
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes());

        System.out.println("Plaintext: " + plaintext);
        System.out.println("Ciphertext: " + Base64.getEncoder().encodeToString(ciphertext));

        // 创建Cipher对象并设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, key, gcmSpec);

        // 执行解密操作
        byte[] decryptedBytes = cipher.doFinal(ciphertext);
        String decryptedText = new String(decryptedBytes);

        System.out.println("Decrypted text: " + decryptedText);
    }

    // 生成随机密钥
    private static byte[] generateRandomKey(int length) {
        // 在实际应用中，应使用安全的随机数生成器来生成密钥
        byte[] key = new byte[length];
        // 这里使用伪随机数生成器（仅为示例目的）
        for (int i = 0; i < length; i++) {
            key[i] = (byte) (Math.random() * 256);
        }
        return key;
    }

    // 生成随机初始化向量（IV）
    private static byte[] generateRandomIV(int length) {
        // 在实际应用中，应使用安全的随机数生成器来生成IV
        byte[] iv = new byte[length];
        // 这里使用伪随机数生成器（仅为示例目的）
        for (int i = 0; i < length; i++) {
            iv[i] = (byte) (Math.random() * 256);
        }
        return iv;
    }
}
