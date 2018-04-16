package com.tgzn.app.appuser.service;

import com.tgzn.app.common.ServerResponse;

public interface UserService {
    ServerResponse getUserBaseInfo(Integer userId);

    ServerResponse modifyPassword(Integer userId, String oldPassword, String newPassword);
}
