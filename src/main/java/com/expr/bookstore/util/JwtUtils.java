//package com.expr.bookstore.util;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.Claim;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.expr.bookstore.entity.User;
//
//import java.util.Calendar;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//public class JwtUtils {
//
//    //token秘钥，请勿泄露，请勿随便更改，backup:HOLLLWX4396jvw
//    private static final String SECRET = "HOLLLWX4396jvw";
//
//    //token过期时间：10天
//    private static final int calendarField = Calendar.DATE;
//    private static final int calendarInterval = 10;
//
//    /**
//     * 创建token
//     * @param user 用户
//     * @return token
//     */
//    public static String createToken(User user) {
//        Date iatDate = new Date();
//        Calendar nowTime = Calendar.getInstance();
//        nowTime.add(calendarField, calendarInterval);
//        Date expiresDate = nowTime.getTime();
//
//        //header Map
//        Map<String, Object> mapHeader = new HashMap<>();
//        mapHeader.put("alg", "HS256");
//        mapHeader.put("typ", "JWT");
//
////        //data Map
////        Map<String, Object> mapData = new HashMap<>();
////        mapData.put("username", user.getUsername());
////        mapData.put("password", user.getPassword());
//
//        Algorithm algorithm = Algorithm.HMAC256(SECRET);
//
//        return JWT.create().withHeader(mapHeader)//头部
//                .withClaim("iss", "Service")//有效负载
//                .withClaim("username", user.getUsername())
//                .withClaim("password", user.getPassword())
//                .withIssuedAt(iatDate)//授权时间
//                .withExpiresAt(expiresDate)//过期时间
//                .sign(algorithm);//验证签名
//    }
//
//    /**
//     * 验证jwt
//     * @param token token
//     * @return decodedJWT
//     */
//    public static Map<String, Claim> verifyJWT(String token) {
//        DecodedJWT decodedJWT = null;
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(SECRET);
//            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
//            decodedJWT = jwtVerifier.verify(token);
//        } catch (Exception e) {
//            e.printStackTrace();//token教研失败，非法token
//        }
//        return decodedJWT.getClaims();
//    }
//
////    public static void validateToken(String token) {
////        try {
////            // parse the token.
////            Map<String, Object> body = Jwts.parser()
////                    .setSigningKey(SECRET)
////                    .parseClaimsJws(token.replace("Bearer ",""))
////                    .getBody();
////        }catch (Exception e){
////            throw new IllegalStateException("Invalid Token. "+e.getMessage());
////        }
////    }
//}
