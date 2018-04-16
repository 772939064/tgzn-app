package com.tgzn.app.appuser.service.impl;

import com.tgzn.app.appuser.mapper.UserMapper;
import com.tgzn.app.appuser.pojo.User;
import com.tgzn.app.appuser.service.UserService;
import com.tgzn.app.appuser.utils.CacheUtils;
import com.tgzn.app.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Value("${server.port}")
    private String port;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse getUserBaseInfo(Integer userId) {
        Map<String, Object> resultMap = new HashMap<>(2);
        try {
            User cacheUser = CacheUtils.getBean(userId.toString(), User.class);
            if (cacheUser != null) {
                resultMap.put("user", cacheUser);
                resultMap.put("port", port);
                return ServerResponse.createBySuccess(resultMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = userMapper.selectById(userId);
        if (user != null) {
            resultMap.put("user", user);
            resultMap.put("port", port);
            try {
                CacheUtils.saveBean(userId.toString(), user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return ServerResponse.createBySuccess(resultMap);
        }

        return ServerResponse.createByErrorMessage("没有查询到该用户");
    }

    @Override
    public ServerResponse modifyPassword(Integer userId, String oldPassword, String newPassword) {
        User currentUser = userMapper.selectOne(new User(userId, oldPassword));
        if (currentUser != null) {
            Integer resultRow = userMapper.updateById(new User(userId, newPassword));
            if (resultRow > 0) {
                return ServerResponse.createBySuccessMessage("密码修改成功");
            }
        } else {
            return ServerResponse.createByErrorMessage("旧密码错误");
        }
        return ServerResponse.createByErrorMessage("密码修改失败,请重试");
    }
}
