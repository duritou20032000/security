流程
1.搭建可以自由跳转的功能页面。首页和controller
2.引入security.jar 
3.写自己的SecurityConfig.先写授权和和http.formlogin()。测试权限是否加上。
4.写认证。测试认证权限，和页面的跳转。
5.写注销。首页写一个注销的表单--就是主要submit按钮。默认到login?logout,也可以自己定制。
6.登陆后的页眉显示不同和导航栏根据角色显示不同。要导入thymeleaf-springSecurity的整合模块。
7.页面也如security名称空间。页面通过sec：authentication来获取名称和角色信息。启动测试。
8.导航以hasRole（）来做。
9.开启记住我功能.

10.一旦定制LoginPage(),post请求就是登录请求。注意这里的post和get下源码看说明。
11.定制记住我。