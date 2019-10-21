package com.poscoict.posledger.assets.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poscoict.posledger.assets.model.User;
import com.poscoict.posledger.assets.model.UserDetail;
import com.poscoict.posledger.assets.model.vo.Page;
import com.poscoict.posledger.assets.model.vo.UserVo;
import com.poscoict.posledger.assets.repository.UserDetailRepository;
import com.poscoict.posledger.assets.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserDetailRepository userDetailRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    private List<UserVo> converToUserVoList(List<User> userList) {
    	return userList.stream().map(user -> modelMapper.map(user, UserVo.class)).collect(Collectors.toList());
    }
    
    /**
	 * 사용자 저장
	 */
    @Transactional
    public void addUser(UserDetail userDetail) {
    	if (!userRepository.existsById(userDetail.getId())) {
	    	userRepository.save(userDetail.getUser());
	    	userDetailRepository.save(userDetail);
    	}
    }
    
    /**
	 * 사용자 조회
	 */
    public UserVo getUser(String id) {
    	return modelMapper.map(userRepository.findById(id).orElse(null), UserVo.class);
    }
    
    /**
	 * 사용자 조회
	 */
    public Page<UserVo> getAllUsers() {
		List<UserVo> userList = converToUserVoList(userRepository.findAll());
		return new Page<UserVo>(userList.size(), userList);
    }
    
    /**
	 * 사용자 조회
	 */
    public List<UserVo> getUsers() {
		return converToUserVoList(userRepository.findAll());
    }
}