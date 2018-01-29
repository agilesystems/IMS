/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.service;

import com.agile.ims.entity.User;

/**
 *
 * @author ramy
 */
public interface UserService {

    User authenticated(String username, String password);
}
