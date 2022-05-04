package net.xdclass.xdvideo;

import io.jsonwebtoken.Claims;
import net.xdclass.xdvideo.domain.User;
import net.xdclass.xdvideo.utils.JwtUtils;
import org.junit.jupiter.api.Test;

/**
 * @program: xdvideo
 * @description: 222
 * @packagename: net.xdclass.xdvideo
 * @author: 姚泽宇
 * @date: 2022-05-04 10:59
 **/
public class CommonTest {
    @Test
    public void testGeneJwt() {
        User user = new User();
        user.setId(999);
        user.setHeadImg("www.xdclass.net");
        user.setName("xd");
        String token = JwtUtils.geneJsonWebToken(user);
        System.out.println(token);
    }
    @Test
    public void testChecK(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4ZGNsYXNzIiwiaWQiOjk5OSwibmFtZSI6InhkIiwiaW1nIjoid3d3LnhkY2xhc3MubmV0IiwiaWF0IjoxNjUxNjMzNDE0LCJleHAiOjE2NTIyMzgyMTR9.HxdnC3glnoXpdhCr4gmKcZU8Sxr4P61yE_gHorpqvIo";
        Claims claims = JwtUtils.checkJWT(token);
        if (claims != null) {
            String name = (String) claims.get("name");
            Integer id = (Integer) claims.get("id");
            String img = (String) claims.get("img");
            System.out.println(name);
            System.out.println(id);
            System.out.println(img);
        } else {
            System.out.println("非法token");
        }
    }
}
