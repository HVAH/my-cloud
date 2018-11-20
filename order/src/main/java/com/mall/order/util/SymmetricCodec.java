package com.mall.order.util;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * Created by Ken on 7/17/2018.
 */
public final class SymmetricCodec {

    private static final String ALGORITHM = "AES";
    private static final byte[] SECRET = "Storm, earth and fire, heed my call".getBytes();

    public static String encode(String content) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(128, new SecureRandom(SECRET));
            SecretKey originalKey = keyGenerator.generateKey();
            byte[] raw = originalKey.getEncoded();
            SecretKey key = new SecretKeySpec(raw, ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] contentBytes = content.getBytes("utf-8");
            byte[] bytes = cipher.doFinal(contentBytes);
            return Base64.getUrlEncoder().encodeToString(bytes);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | UnsupportedEncodingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException ignore) {
        }
        return null;
    }

    public static String decode(String content) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(128, new SecureRandom(SECRET));
            SecretKey originalKey = keyGenerator.generateKey();
            byte[] raw = originalKey.getEncoded();
            SecretKey key = new SecretKeySpec(raw, ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] contentBytes = content.getBytes("utf-8");
            byte[] decodedBytes = Base64.getUrlDecoder().decode(contentBytes);
            byte[] bytes = cipher.doFinal(decodedBytes);
            return new String(bytes, "utf-8");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | UnsupportedEncodingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | IllegalArgumentException ignore) {
        }
        return null;
    }
}
