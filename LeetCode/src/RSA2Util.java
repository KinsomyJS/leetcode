import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author famdetxire
 * @date 2022/7/11 - 11:05
 */
public class RSA2Util {

    /**
     * 编码：utf-8
     */
    private static final String UTF8 = StandardCharsets.UTF_8.name();
    /**
     * Base64 编码/解码器 JDK1.8
     */
    private static final Base64.Decoder decoder = Base64.getDecoder();

    private static final Base64.Encoder encoder = Base64.getEncoder();

    private static KeyFactory keyFactory = null;

    /**
     * 加密算法
     */
    private static final String ALGORITHM = "RSA";

    /**
     * rsa单次最大加密的明文大小 117
     */

    private static final int MAX_ENCRYPT_BLOCK = 117;
    /**
     * rsa单次最大解密的密文大小 128
     */

    private static final int MAX_DECRYPT_BLOCK = 128;

    /**
     * 算法名称/加密模式/数据填充方式 默认：RSA/ECB/PKCS1Padding
     */
    private static final String ALL_ALGORITHMS = "RSA/ECB/PKCS1Padding";

    private static String publicKeyPath;
    private static String privateKeyPath;


    static {
        try {
            keyFactory = KeyFactory.getInstance(ALGORITHM);
//            ClassLoader classLoader = RSA2Util.class.getClassLoader();
//            publicKeyPath = classLoader.getResource("rsa.pub").getPath();
//            privateKeyPath = classLoader.getResource("rsa.pri").getPath();
//            publicKeyPath = UtilConfig.getInterfacePubKeyPath();
            //privateKeyPath = UtilConfig.getInterfacePriKeyPath();
        } catch (NoSuchAlgorithmException e) {
        }
    }

    public static void writeKey2File() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGenerator.initialize(1024);
        //通过keyPairGenerator生成器生产keyPair
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        //把对象转成字节数组
        byte[] publicKeyEncoded = publicKey.getEncoded();
        //使用base64编码
        String publicKeyBase64Str = encoder.encodeToString(publicKeyEncoded);

        PrivateKey privateKey = keyPair.getPrivate();
        byte[] privateKeyEncoded = privateKey.getEncoded();
        //使用base64编码
        String privateKeyBase64Str = encoder.encodeToString(privateKeyEncoded);

//        FileUtils.writeStringToFile(new File(publicKeyPath),publicKeyBase64Str,UTF8);
//        FileUtils.writeStringToFile(new File(privateKeyPath),privateKeyBase64Str,UTF8);

    }

    /**
     * RSA公钥加密
     *
     * @param content 等待加密的数据
     * @param key     RSA 公钥 if null then getPublicKey()
     * @return 加密后的密文(16进制的字符串)
     */
    public static String encryptByPublic(String content, Key key) {
        try {
            if (key == null) {
                return null;
            }
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedByte = deCodec(cipher, content.getBytes(UTF8), MAX_ENCRYPT_BLOCK);
            return new String(encoder.encode(encryptedByte));
        } catch (NoSuchAlgorithmException e) {
        } catch (NoSuchPaddingException e) {
        } catch (InvalidKeyException e) {
        } catch (BadPaddingException e) {
        } catch (IllegalBlockSizeException e) {
        } catch (IOException e) {
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * RSA 私钥界面
     *
     * @param content 等待解密的数据
     * @param key     RSA 私钥 if null then getPrivateKey()
     * @return 加密后的密文(16进制的字符串)
     */
    public static String decryptByPrivate(String content, Key key) {
        try {
            if (key == null) {
                return null;
            }
            byte[] decode = decoder.decode(content);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedByte = deCodec(cipher, decode, MAX_DECRYPT_BLOCK);
            //该密钥能够加密的最大字节长度
            return URLDecoder.decode(new String(decryptedByte), "UTF-8");
        } catch (NoSuchAlgorithmException e) {
        } catch (NoSuchPaddingException e) {
        } catch (InvalidKeyException e) {
        } catch (BadPaddingException e) {
        } catch (IllegalBlockSizeException e) {
        } catch (IOException e) {
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 执行加密或解密
     *
     * @param cipher
     * @param bytes
     * @param maxBlockSize
     * @return
     */
    public static byte[] deCodec(Cipher cipher, byte[] bytes, int maxBlockSize) throws Exception {
        int inputLen = bytes.length;
        int offset = 0;
        byte[] cache;
        int i = 0;
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        //循环分段处理
        while ((inputLen - offset) > 0) {
            if ((inputLen - offset) > maxBlockSize) {
                //第三个参数是要处理多长
                cache = cipher.doFinal(bytes, offset, maxBlockSize);
            } else {
                cache = cipher.doFinal(bytes, offset, inputLen - offset);
            }
            //把当前cache的内容存起来
            out.write(cache, 0, cache.length);
            i++;
            offset = i * maxBlockSize;
        }
        byte[] codecBytes = out.toByteArray();
        out.close();
        return codecBytes;
    }

    /**
     * 根据限定的每组字节长度，将字节数组分组
     *
     * @param bytes       等待分组的字节组
     * @param splitLength 每组长度
     * @return 分组后的字节组
     */
    public static byte[][] splitBytes(byte[] bytes, int splitLength) {
        //bytes与splitLength的余数
        int remainder = bytes.length % splitLength;
        //数据拆分后的组数，余数不为0时加1
        int quotient = remainder != 0 ? bytes.length / splitLength + 1 : bytes.length / splitLength;
        byte[][] arrays = new byte[quotient][];
        byte[] array;
        for (int i = 0; i < quotient; i++) {
            //如果是最后一组（quotient-1）,同时余数不等于0，就将最后一组设置为remainder的长度
            if (i == quotient - 1 && remainder != 0) {
                array = new byte[remainder];
                System.arraycopy(bytes, i * splitLength, array, 0, remainder);
            } else {
                array = new byte[splitLength];
                System.arraycopy(bytes, i * splitLength, array, 0, splitLength);
            }
            arrays[i] = array;
        }
        return arrays;
    }

    /**
     * md5加密方法
     *
     * @param text text
     * @return String
     */
    public static String md5(String text) {

        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(text.getBytes());
            StringBuilder buffer = new StringBuilder();
            // 把没一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    private static String getPublicKey1() {
        return "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCmX1gS4yoGNSLyVqY7t0hJ2uI+TnYz+Zq0S6k5wrCZeaBo1D69NJ0FHBlWzvaiznzTQ+60i+mWeBkdIsffHObYVFlOEDwLFyIE5g/PkUxoSYnOuu/5uBwLAnvueYbCGqdqq7itbV4w01ydQ48hh1FTCXKXpWNL7IzeRG+LJbhj+QIDAQAB";
    }

    private static String getPrivateKey() {
        return "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAKZfWBLjKgY1IvJWpju3SEna4j5OdjP5mrRLqTnCsJl5oGjUPr00nQUcGVbO9qLOfNND7rSL6ZZ4GR0ix98c5thUWU4QPAsXIgTmD8+RTGhJic667/m4HAsCe+55hsIap2qruK1tXjDTXJ1DjyGHUVMJcpelY0vsjN5Eb4sluGP5AgMBAAECgYEAoOOZF4LItAIUzogO77a52HosyhY0ZuTdv7dfajUldPXSsy11kqFbq4JV2sYAascGnYOXRs/6z4FKwAtPgCrB7SfSdLQ549EM9hikzNRPUJUdlFe/Tw3ySTBPBQbJI2qB8muBvT6v7T6yaBzgssXqoSrHyPIU4w83hbyVUvsc0aUCQQDdlhHp5t/zs8LkkAZGol/kdvYrVRL+yv5p4ux+uA/jiuJE+M9/bcSOUrX7bptpBEvffzWSrQTZU7f3e7OR7jWrAkEAwDYO/982TJ3TA9em1wBwNjFPA0CSHHjy9czUsyEGVu+QODtl/gLLRaA0CjBZ8zAGe82+7fV7/moS9LOBbMdg6wJBAIb1nDuGLujTl+R2BByJUTZpbk2+Jy+gm4wKdlhH6wV/1YiEsny+cnTs04IsP+Oahku9wvdvAgEMCIRnh1teZrkCQQCyf0FMs0BcxFAbCGCi14Bdg0sKDSPjFxsh0vdP5oJZp5256sdbrcKRxSWutJpD8byDqlz95PQiHuW9oxm1KC7DAkB6ZhSR4WILu7y2YZSQAgVX/6a3GByL8wffTqY0EDXdYn+Mdrdsk/doXlIcB5qffF0KAuI+VDdqPngDXwv+vpxc";
    }

    public static RSAPublicKey getPublicKey() throws Exception {
        try {
            // String publicKeyBase64Str = FileUtils.readFileToString(new File(publicKeyPath), UTF8);
            String publicKeyBase64Str = new String(getPublicKey1().getBytes(StandardCharsets.UTF_8));
            byte[] keyBytes = decoder.decode(publicKeyBase64Str);
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
            return (RSAPublicKey) keyFactory.generatePublic(x509EncodedKeySpec);
        } catch (InvalidKeySpecException e) {
        }
        return null;
    }

    public static RSAPrivateKey getPrivetKey() {
        try {
            //String privateKeyBase64Str = FileUtils.readFileToString(new File(privateKeyPath), UTF8);
            String privateKeyBase64Str = new String(getPrivateKey().getBytes(StandardCharsets.UTF_8));

            byte[] keyBytes = decoder.decode(privateKeyBase64Str);
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
            return (RSAPrivateKey) keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        } catch (InvalidKeySpecException e) {
        } catch (Exception ex) {

        }
        return null;
    }

//    public static String startEncryption(String password,String zxkPublicKey) {
//        return RSA2Util.encryptByPublic(password.getBytes(), zxkPublicKey);
//    }

    public static String startDecryption(String content) {
        return decryptByPrivate(content, getPrivetKey());
    }


    public static void main(String[] args) throws Exception {
        String androidEnStr = "NHU/NCCkT9/mKFhiEG9ymucspv63QG2FlJCmaBCmMnrHCB86Pm0nUiz5ewE51E0xYIS+cTPF1ber86dxV7YqEXMYgFyl4qH/13pkCKru2ruOHlvDerzdWJoqM5MdJJ8H4dr1nyTJa8wei4D/wuM/WhUUsytvhNZuL3gK5E7MWcw=";
        String serverEnStr = "EKpT4q8dRlYs9tdvVVybdJr9gUFQ+H/GoMm+PNPBj+LiOjrc2KIZLoLd1gWctyenDXbkM9wOzqbrErB86IR9gaf0sZU6EUtO8G/RMJmvOv9b09dD2mgHpjmvvAzTlF1Niw4G99Ysp1aFB09PAGGjc49nvwfGIfpV4rs75VtltrR6ZXOlLhCydpTZWrajlWEl85p/yT9gMfS7fix4yCe8OUpHj3qWReiJMH9knaCfVq4x0IUfRTqjh2uK1/y+nTx1pqhWMmi5gnFqiQGzcu9r3bPud34h2UH4vQ6+K+PbxeByVmcQ91pVeruJtyxZZa8vUVtQg5M8uL4pZWuZ41t+PTPpHVQNDhPwNumZRRCujH72XPCCNinC98TxOYU880SmGNzaNy5uzTfj5yMgfZ2IbatAzuKDmRiR4JGYqr47YFC/yYqsE84zJbfhPJkqBHpy6DR33r0H5z/dE9w8yjUifitlsRgaaSutxsSQScgNTlUbARr434B7k9ckAYN4cM8rm0MQmwyLaIMI74VN57ncWw2OLbWQ8E+hWx3MvG0nUkeWuLWDfTgIOOs6djVwrWPhhZ0EIcWRqil8cAFwdcjRulEDR7tIiJ/nnVlJ+n3eeov6R1F36odyGXD6qUOC1IExIHCIGH/b+wrFol2KD52Ea7RqvuY1kUHkIjj3RiZn6pU=";
        String content = "{\"companyId\":\"70b6f571f75a472b8d51bab0759f0279\",\"serviceId\":\"616b45852dd345dcbf183a41e38383bb\",\"area\":\"扬州\"}";
        String hhcEnStr = "m8ADGmOpO+2S5TY5a6D5s75mrEYp5s4IgzcoTjp89GqTLIn6rqWWlFV2s2IkEYqnkbkqbJ73DdHLiiRTi4I7IDKEWZb8wBvoLW6rZtB0hY+2ibzcSPqJUEOclSMbNv34lyDRz0AVi3zpS9Mljo49WcN+RpxPhl1p+2x85iIhJ7FWxqBaXi1Ab1G3TY71+FEw1Y1LfKV3nUTuuXcv9JCNLcCAYgRTDPjHv/KK8u/17lm/x2j/i8ZMwI808klTwo6xo4+p+89TPn6MJohiVfox8jbu3+3YDl27PgQAiZRNc6ro1yts0U0qKoasdm11HKvjO6sjIIBbLdkA7Mg+RNioxy45iKzdvWMDMupbCaI/IPfimvMrvYxpEKycMUgP1aDHnJRySLkH8Le0Z2oTAtfNimV13A9iQnzg6mJmR0KKFOn4v0bbgB7LrBj3TQFOX+Ytswn2wyFOny/QuZt6gVDfoCfn8iIP+m4uHlS2noqybRHDPOjLcfVxqHjVZl3Sp922PiO1OFnbQm7s+VqEXft2DMT0s6b7HQu2Xt8h3z0JP/OCr1wNGswXrcYPcoNsgfFA4nWQNiQLCWQTxi0Fvb521m3X0XkK+IL57xmHlGYSo/DgwfLLO9BSSJRniux0L2J5649TJXGoTcG0BQ1Gi40EhoQEj731WJq+3kEwJOIBcZA=";
        String encryptedStr = encryptByPublic(content, getPublicKey());
        System.out.println("加密后的密文：" + encryptedStr);
        String decryptedStr = decryptByPrivate(hhcEnStr, getPrivetKey());
        System.out.println("解密后的明文：" + decryptedStr);
        //writeKey2File();
        //System.out.println(privateKeyPath);
    }
}
