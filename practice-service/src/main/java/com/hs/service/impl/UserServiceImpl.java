package com.hs.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.hs.exception.UserBusinessException;
import com.hs.mapper.UserMapper;
import com.hs.model.user.UserModel;
import com.hs.model.user.vm.UserModelVM;
import com.hs.service.user.IUserService;
import com.hs.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserModel selectUser(UserModelVM vm) {
        return userMapper.selectUser(vm);
    }

    @Override
    public int deleteUser(UserModelVM vm) throws DataAccessException {
        return userMapper.deleteUser(vm);
    }

    @Override
    public int updateUser(UserModelVM vm) throws DataAccessException {
        UserModel model = covertModel(vm);
        return userMapper.updateUser(model);
    }

    private UserModel covertModel(UserModelVM vm) {
        UserModel model= new UserModel();
        model.setUserName(vm.getUserName());
        model.setAddress(vm.getAddress());
        model.setLoginName(vm.getLoginName());
        model.setPassword(vm.getPassword());
        model.setSex(vm.getSex());
        model.setStatus(vm.getStatus());
        return model;
    }

    @Override
    public int insertUser(UserModelVM vm) throws DataAccessException {
        UserModel model = covertModel(vm);
        return userMapper.insertUser(model);
    }

    @Override
    public int updatePassword(UserModelVM vm) {
        String errorMessage =  validatePassword(vm);
        if(StringUtils.isEmpty(errorMessage)){
            throw new UserBusinessException(errorMessage);
        }
        return userMapper.updatePassword(vm);
    }


    @Override
    public UserModel loginUser(UserModelVM vm) throws DataAccessException {
        return null;
    }

    @Override
    public String findPassword(UserModelVM vm) throws DataAccessException {
        return null;
    }

    @Override
    public int informationComplement(UserModelVM vm) {
        return 0;
    }


    /**
     * ????????????????????????
     */
    private String validatePassword(UserModelVM vm)  {
        String result = null;
        if(!StringUtil.lengthValidate(vm.getPassword(), 6, 20)){
            result = "?????????????????????6-20??????";
        }
        //????????????????????????????????????
        UserModel user = userMapper.selectUser(vm);
        if(!StringUtil.isEmpty(vm.getPassword(), false) && vm.getPassword().equals(user.getPassword())){
            result = "??????????????????";
        }
        return result;
    }
}
