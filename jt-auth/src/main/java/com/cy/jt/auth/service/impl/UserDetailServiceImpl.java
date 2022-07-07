package com.cy.jt.auth.service.impl;

import com.cy.jt.auth.service.UserRemoteService;
import com.cy.jt.common.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRemoteService userRemoteService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto=userRemoteService.selectUserByUsername(username);
        System.out.println("userDto="+userDto);
        if(userDto==null) throw new RuntimeException("用户不存在");
        List<String> permissions=userRemoteService.selectUserPermissions(userDto.getId());
        System.out.println("permissions="+permissions);
        return new User(username, userDto.getPassword(),//来自数据库
                AuthorityUtils.createAuthorityList(permissions.toArray(new String[]{})));
    }
}
