package tech.jianning.common.utils;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;

public class EncryptUtil {

    private static final String SECRET_KEY = "alg_vis_secret_key";
    public static String createJWT(long ttlMillis, Map<String, Object> claims) {
        // 指定签名的时候使用的签名算法，也就是header那部分
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        // 生成JWT的时间
        long expMillis = System.currentTimeMillis() + ttlMillis;
        Date exp = new Date(expMillis);

        // 设置jwt的body
        JwtBuilder builder = Jwts.builder()
            // 如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
            .setClaims(claims)
            // 设置签名使用的签名算法和签名使用的秘钥
            .signWith(signatureAlgorithm, SECRET_KEY.getBytes(StandardCharsets.UTF_8))
            // 设置过期时间
            .setExpiration(exp);

        return builder.compact();
    }

    public static Claims parseJWT( String token) {
        // 得到DefaultJwtParser
        Claims claims = Jwts.parser()
            // 设置签名的秘钥
            .setSigningKey(SECRET_KEY.getBytes(StandardCharsets.UTF_8))
            // 设置需要解析的jwt
            .parseClaimsJws(token).getBody();
        return claims;
    }

    //MD5加密
    public static String md5(Object obj) throws NoSuchAlgorithmException {
        byte[] digest = MessageDigest.getInstance("MD5").digest(JSON.toJSONString(obj).getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

}
