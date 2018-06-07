package com.wdd.test.service.shiro;

import com.wdd.test.comm.util.MD5Password;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
    @Resource
    private CacheManager cacheManager;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        boolean fal = false;
        try {
            fal = MD5Password.validPasswd(String.valueOf(token.getPassword()), getCredentials(info).toString());
            return fal;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return fal;
    }

}
