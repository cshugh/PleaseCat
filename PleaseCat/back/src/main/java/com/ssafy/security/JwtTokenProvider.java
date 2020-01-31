package com.ssafy.security;

import java.util.Base64; 
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// JWT는 세 파트로 나누어지며, 각 파트는 점로 구분하여 xxxxx.yyyyy.zzzzz 이런식으로 표현됩니다. 
// 순서대로 헤더 (Header), 페이로드 (Payload), 서명 (Sinature)로 구성합니다.
// Base64 인코딩의 경우 “+”, “/”, “=”이 포함되지만 JWT는 URI에서 파라미터로 사용할 수 있도록 URL-Safe 한  Base64url 인코딩을 사용합니다.

// Header는 토큰의 타입과 해시 암호화 알고리즘으로 구성되어 있습니다. 
// 첫째는 토큰의 유형 (JWT)을 나타내고, 두 번째는 HMAC, SHA256 또는 RSA와 같은 해시 알고리즘을 나타내는 부분입니다.
// Payload는 토큰에 담을 클레임(claim) 정보를 포함하고 있습니다. 
// Payload 에 담는 정보의 한 ‘조각’ 을 클레임이라고 부르고, 이는 name / value 의 한 쌍으로 이뤄져있습니다. 

// 토큰에는 여러개의 클레임 들을 넣을 수 있습니다.
// 클레임의 정보는 등록된 (registered) 클레임, 공개 (public) 클레임, 비공개 (private) 클레임으로 세 종류가 있습니다.
// 마지막으로 Signature는 secret key를 포함하여 암호화되어 있습니다.


// [ JwtTokenProvider 설명 ]
/*Jwt 토큰 생성 및 유효성 검증을 하는 컴포넌트입니다. 
Jwt는 여러 가지 암호화 알고리즘을 제공하며
알고리즘(SignatureAlgorithm.XXXXX)과 비밀키(secretKey)를 가지고 토큰을 생성하게 됩니다.
이때 claim정보에는 토큰에 부가적으로 실어 보낼 정보를 세팅할 수 있습니다. 
claim 정보에 회원을 구분할 수 있는 값을 세팅하였다가 토큰이 들어오면
해당 값으로 회원을 구분하여 리소스를 제공하면 됩니다. 

그리고 Jwt토큰에는 expire 시간을 세팅할 수 있습니다. 
토큰 발급 후 일정 시간 이후에는 토큰을 만료시키는 데 사용할 수 있습니다. 
resolveToken 메서드는 Http request header에 세팅된 토큰 값을 가져와 유효성을 체크합니다.
제한된 리소스를 요청할 때 Http header에 토큰을 세팅하여 호출하면 
유효성을 검증하여 사용자 인증을 할 수 있습니다.*/


//@RequiredArgsConstructor //final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 만들어줍니다.

@Component
public class JwtTokenProvider { // JWT 토큰을 생성 및 검증 모듈
	
	 @Value("spring.jwt.secret")
	    private String secretKey;
	    private long tokenValidMilisecond = 1000L * 60 * 60; // 1시간만 토큰 유효
	 
	    //private final UserDetailsService userDetailsService;
	    private UserDetailsService userDetailsService;
	 
	    @PostConstruct
	    protected void init() {
	        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	    }
	 
	    // Jwt 토큰 생성 
	    public String createToken(String userPk, List<String> roles) {
	        Claims claims = Jwts.claims().setSubject(userPk);
	        claims.put("roles", roles);
	        Date now = new Date();
	        return Jwts.builder()
	                .setClaims(claims) // 데이터
	                .setIssuedAt(now) // 토큰 발행일자
	                .setExpiration(new Date(now.getTime() + tokenValidMilisecond)) // set Expire Time
	                .signWith(SignatureAlgorithm.HS256, secretKey) // 암호화 알고리즘, secret값 세팅
	                .compact();
	    }
	 
	    // Jwt 토큰으로 인증 정보를 조회
	    public Authentication getAuthentication(String token) {
	        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
	        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	    }
	 
	    // Jwt 토큰에서 회원 구별 정보 추출
	    public String getUserPk(String token) {
	        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	    }
	 
	    // Request의 Header에서 token 파싱 : "X-AUTH-TOKEN: jwt토큰"
	    public String resolveToken(HttpServletRequest req) {
	        return req.getHeader("X-AUTH-TOKEN");
	    }
	 
	    // Jwt 토큰의 유효성 + 만료일자 확인
	    public boolean validateToken(String jwtToken) {
	        try {
	            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
	            return !claims.getBody().getExpiration().before(new Date());
	        } catch (Exception e) {
	            return false;
	        }
	    }

}
