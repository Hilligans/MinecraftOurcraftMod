package dev.Hilligans.Util;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class CryptManager {

    public static SecretKey createNewSharedKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            return keyGenerator.generateKey();
        } catch (Exception ignored) {
            return null;
        }
    }

    public static byte[] getServerIdHash(String serverId, PublicKey publicKey, SecretKey secretKey) {
        try {
            return digestOperation("SHA-1", serverId.getBytes("ISO_8859_1"), secretKey.getEncoded(), publicKey.getEncoded());
        } catch (Exception ignored) {
            return null;
        }
    }

    private static byte[] digestOperation(String algorithm, byte[]... data) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            for(byte[] byteVal : data) {
                messageDigest.update(byteVal);
            }
            return messageDigest.digest();
        } catch (Exception ignored) {
            return null;
        }
    }

    public static PublicKey decodePublicKey(byte[] encodedKey) {
        try {
            EncodedKeySpec encodedKeySpec = new X509EncodedKeySpec(encodedKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(encodedKeySpec);
        } catch (Exception ignored) {
            return null;
        }
    }

    public static Cipher getCipherInstance(int mode, Key key) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");
            cipher.init(mode, key, new IvParameterSpec(key.getEncoded()));
            return cipher;
        } catch (Exception ignored) {
            return null;
        }
    }

    public static Cipher createCipherInstance(int mode, String transformation, Key key) {
        try {
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(mode, key);
            return cipher;
        } catch (Exception ignored) {
            return null;
        }
    }

    public static byte[] encryptData(Key key, byte[] data) {
        return encryptData(1,key,data);
    }

    public static byte[] encryptData(int opMode, Key key, byte[] data) {
        try {
            return createCipherInstance(opMode, key.getAlgorithm(), key).doFinal(data);
        } catch (Exception ignored) {
            return null;
        }
    }

}
