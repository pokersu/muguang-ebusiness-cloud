package com.muguang.ebusiness.service;

/**
 * @author muguang
 * @date 2017/3/6 13:53.
 */
public interface IAuthorizationService {

    String auth(String name, String password);

    void deAuth(String token);
}
