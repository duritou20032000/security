package com.leohorry.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        //授权
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //默认登录,自动的登录页。1.login到 登录页 2.error  重定向到login?error
       // http.formLogin();
        //定制登录页
        http.formLogin().usernameParameter("username").passwordParameter("password").loginPage("/userLogin");


        //默认注销功能。退出，并注销session
       // http.logout();
        //定制注销后的页面
        http.logout().logoutSuccessUrl("/");

        //记住我
       // http.rememberMe();
        http.rememberMe().rememberMeParameter("remenberme");

    }

    //认证
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("zhangsan").password("123456").roles("VIP1", "VIP2")
                .and()
                .withUser("lisi").password("123456").roles("VIP2", "VIP3")
                .and()
                .withUser("wangwu").password("123456").roles("VIP1", "VIP3");

    }
}
