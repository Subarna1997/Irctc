package com.hcl.Irctc.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.hcl.Irctc.dao.UserDao;
import com.hcl.Irctc.dto.UserDto;
import com.hcl.Irctc.model.User;


@Service
public class UserServiceImpl implements UserService{
	
	
	
	@Autowired
	UserDao userdao;
	
	public User getUserById(Integer userid) {
        Optional<User> optionalProduct = userdao.findById(userid);
        if (!optionalProduct.isPresent())
        {
            return null;	
        }
        return optionalProduct.get();
    }
	
	
	@Override
	public boolean saveUserDetails(UserDto userDto) {
	User user = new User();
	BeanUtils.copyProperties(userDto, user);
	User userPerst = userdao.save(user);
	if(ObjectUtils.isEmpty(userPerst)) return false;
	return true;
	}

	 @Override
	public ResponseEntity<String> authenticate(String username, String password) {
	User user = userdao.findByUserNameAndPassword(username, password);

	return new ResponseEntity<>("Login success", HttpStatus.OK);
	
	}


}
