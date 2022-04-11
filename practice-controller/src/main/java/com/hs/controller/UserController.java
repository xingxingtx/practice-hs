package com.hs.controller;


import com.hs.model.user.UserModel;
import com.hs.model.user.vm.UserModelVM;
import com.hs.service.user.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author a_pen
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private IUserService userService;

    /**
     * 查询用户列表
     * @param vm
     * @return userModel
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<UserModel> selectUserPage(UserModelVM vm) {
        UserModel userModel = userService.selectUser(vm);
        return new ResponseEntity<>(userModel, HttpStatus.OK);

    }

    /**
     * 查询用户详情
     * @param vm
     * @return userModel
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<UserModel> selectUser(UserModelVM vm) {
            UserModel userModel = userService.selectUser(vm);
        return new ResponseEntity<>(userModel, HttpStatus.OK);

    }


    /**
     * 新增用户
     * @param vm
     * @return userModel
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserModel> addUser(@RequestBody UserModelVM vm) {
        userService.insertUser(vm);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * 删除用户
     * @param vm
     * @return userModel
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<UserModel> deleteUser(UserModelVM vm) {
        userService.deleteUser(vm);
        return new ResponseEntity<>( HttpStatus.OK);

    }


    /**
     * 修改用户信息
     * @param vm
     * @return userModel
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<UserModel> updateUser(UserModelVM vm) {
        UserModel userModel = userService.selectUser(vm);
        return new ResponseEntity<>(userModel, HttpStatus.OK);

    }
}
