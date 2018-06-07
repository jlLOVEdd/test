package com.wdd.test.service.shiro;



public class UsernamePasswordToken extends org.apache.shiro.authc.UsernamePasswordToken {

	 private static final long serialVersionUID = 1L;
	    private String captcha;
	    private String locale;
	    
	    public String getCaptcha() {
	        return captcha;
	    }

	    public void setCaptcha(String captcha) {
	        this.captcha = captcha;
	    }

	    public String getLocale() {
	        return locale;
	    }

	    public void setLocale(String locale) {
	        this.locale = locale;
	    }

	    public UsernamePasswordToken() {
	        super();
	    }

	    public UsernamePasswordToken(String username, char[] password, boolean rememberMe, String host, String captcha) {
	        super(username, password, rememberMe, host);
	        this.captcha = captcha;
	    }
	    public UsernamePasswordToken(String username, char[] password, String locale,boolean rememberMe, String host, String captcha) {
	        super(username, password, rememberMe, host);
	        this.captcha = captcha;
	        this.locale = locale;
	    }

}
