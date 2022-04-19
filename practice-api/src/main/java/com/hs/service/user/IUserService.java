package com.hs.service.user;

import com.hs.model.user.UserModel;
import com.hs.model.user.vm.UserModelVM;
import org.springframework.dao.DataAccessException;

public interface IUserService {

    /**
     *  查询用户信息
     * @param vm
     * @return
     * @throws DataAccessException
     */
    UserModel selectUser(UserModelVM vm) throws DataAccessException;

    /**
     *  删除用户信息
     * @param vm
     * @return
     * @throws DataAccessException
     */
    int deleteUser(UserModelVM vm) throws DataAccessException;

    /**
     *  修改用户信息
     * @param vm
     * @return
     * @throws DataAccessException
     */
    int updateUser(UserModelVM vm) throws DataAccessException;

    /**
     *  插入用户信息
     * @param vm
     * @return
     * @throws DataAccessException
     */
    int insertUser(UserModelVM vm) throws DataAccessException;

    /**
     * 修改密码
     * @param vm
     * @return
     */
    int updatePassword(UserModelVM vm) throws DataAccessException;

    /**
     * 用户登录
     * @param vm
     * @return
     */
    UserModel loginUser(UserModelVM vm)throws DataAccessException;

    /**
     * 密码找回
     * @param vm
     * @return
     */
    String findPassword(UserModelVM vm)throws DataAccessException;

    /**
     * 用户信息完善
     * @param vm
     * @return
     */
    int informationComplement(UserModelVM vm)throws DataAccessException;
}
