package com.wdd.test.service.shiro;

import com.wdd.test.bean.Sysuserinfo;
import com.wdd.test.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;


@Consumes
public class securityRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        String userName = userToken.getUsername();
        Sysuserinfo user = userService.selectByName(userName);
        if (user == null) {
            return null;
            //throw new UnknownAccountException("用户不存在");
        }
        String passWord = user.getPassword();
        //user.setUsername("weidongdong");
        //user.setPw(passWord);
        return new SimpleAuthenticationInfo(userName, passWord, getName());
    }

}
