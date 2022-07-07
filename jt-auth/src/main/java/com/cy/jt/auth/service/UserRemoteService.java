package com.cy.jt.auth.service;

import com.cy.jt.common.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="jt-system",contextId = "userRemoteService")
public interface UserRemoteService {

     @GetMapping("/user/auth/{username}")
     UserDto selectUserByUsername(@PathVariable("username") String username);

     @GetMapping("/user/perm/{id}")
     public List<String> selectUserPermissions(@PathVariable("id") Integer id);

}
