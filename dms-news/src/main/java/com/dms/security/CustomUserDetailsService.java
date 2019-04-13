package com.dms.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dms.domain.SUser;
import com.dms.service.IUserService;
import com.dms.utils.CommonTools;

public class CustomUserDetailsService implements UserDetailsService {

	
   @Autowired  //数据库服务类
    private IUserService suserService;

   
   
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //SUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        //本例使用SUser中的email作为用户名:
    
    	
    	
        SUser user = suserService.findByName(userName); 
        user.setSignCount(user.getSignCount()+1);
        suserService.save(user);
        
        
        if (user == null) {

            throw new UsernameNotFoundException("UserName " + userName + " not found");

        }

        // SecurityUser实现UserDetails并将SUser的Email映射为username
       
//      List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//      authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getItem().getName()));
//      return new User(user.getUsername(), user.getPassword(), authorities);
        
        return user;
    }

}