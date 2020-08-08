package com.cn.share.movie.web.ioc;

public class UserController {

    @MyAutowried
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
}
