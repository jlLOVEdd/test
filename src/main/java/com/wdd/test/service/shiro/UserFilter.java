package com.wdd.test.service.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;

public class UserFilter extends org.apache.shiro.web.filter.authc.UserFilter {
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
	{
		if (isLoginRequest(request, response))
		{
			return true;
		}
		else
		{
			Subject subject = getSubject(request, response);
			return subject.getPrincipal() != null;
		}
	}

}
