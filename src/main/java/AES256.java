import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;


/**
 * java实现AES256加密解密
 * 依赖说明：
 * bcprov-jdk15-133.jar：PKCS7Padding
 * javabase64-1.3.1.jar：base64
 * local_policy.jar 和 US_export_policy.jar需添加到%JAVE_HOME%\jre\lib\security中（lib中版本适合jdk1.7）
 */

public class AES256 {

    /**
     * 加密
     * @param content
     * @param password
     * @return
     */
    public static String encrypt(String content, String password) {
        try {
            //"AES"：请求的密钥算法的标准名称
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            //256：密钥生成参数；securerandom：密钥生成器的随机源
            SecureRandom securerandom = new SecureRandom(password.getBytes());
            kgen.init(256, securerandom);
            //生成秘密（对称）密钥
            SecretKey secretKey = kgen.generateKey();
            //返回基本编码格式的密钥
            byte[] enCodeFormat = secretKey.getEncoded();
            //根据给定的字节数组构造一个密钥。enCodeFormat：密钥内容；"AES"：与给定的密钥内容相关联的密钥算法的名称
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            //将提供程序添加到下一个可用位置
            Security.addProvider(new BouncyCastleProvider());
            //创建一个实现指定转换的 Cipher对象，该转换由指定的提供程序提供。
            //"AES/ECB/PKCS7Padding"：转换的名称；"BC"：提供程序的名称
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");

            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] byteContent = content.getBytes("utf-8");
            byte[] cryptograph = cipher.doFinal(byteContent);
            return new String(new Base64().encode(cryptograph));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     * @param encryptData
     * @param password
     * @return
     * @throws Exception
     */
    public static String decrypt(String encryptData, String password) throws Exception {

        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom securerandom = new SecureRandom(password.getBytes());
        kgen.init(256, securerandom);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");//"算法/模式/补码方式"

        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] content = cipher.doFinal(new Base64().decode(encryptData));
        return new String(content);
    }


    private static byte[] tohash256Deal(String datastr) {
        try {
            MessageDigest digester = MessageDigest.getInstance("SHA-256");
            digester.update(datastr.getBytes());
            byte[] hex = digester.digest();
            return hex;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
