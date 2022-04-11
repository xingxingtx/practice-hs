package com.hs.mapper;

import com.hs.model.user.UserModel;
import com.hs.model.user.vm.UserModelVM;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author a_pen
 */
@Repository
@Mapper
public interface UserMapper {

    /**
     *  查询用户信息详情
     * @param vm
     * @return
     * @throws DataAccessException
     */
    UserModel selectUser(@Param(value = "vm") UserModelVM vm) throws DataAccessException;

    /**
     *  删除用户信息
     * @param vm
     * @return
     * @throws DataAccessException
     */
    int deleteUser(UserModelVM vm) throws DataAccessException;

    /**
     *  修改用户信息
     * @param model
     * @return
     * @throws DataAccessException
     */
    int updateUser(UserModel model) throws DataAccessException;

    /**
     *  插入用户信息
     * @param model
     * @return
     * @throws DataAccessException
     */
    int insertUser(@Param("model") UserModel model) throws DataAccessException;

    /**
     * 修改密码
     * @param vm
     * @return
     */
    int updatePassword(UserModelVM vm)throws DataAccessException;


}
