package com.lhr13.hpm.service;

import com.lhr13.hpm.POJO.User;
import com.lhr13.hpm.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //从数据库读取用户
        List<User> users = userDAO.findByUsername(username);

        for (User user : users) {
            if (user == null) {
                System.out.println("此用户不存在");
                throw new UsernameNotFoundException("此用户不存在");
            }

            user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));
            return user;
        }
        return null;
    }

    //权限转换
    private List<GrantedAuthority> grantedAuthorities(String roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        String[] roleArray = roles.split(";");
        if (roles != null && !"".equals(roles)) {
            for (String role : roleArray) {
                authorities.add(new SimpleGrantedAuthority(role));
            }
        }
        return authorities;
    }
}
