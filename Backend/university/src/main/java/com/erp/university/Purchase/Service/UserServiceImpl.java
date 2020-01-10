package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.UserDTO;
import com.erp.university.Purchase.Model.User;
import com.erp.university.Purchase.Repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService {
	private static final Logger logger = LogManager.getLogger(UserService.class);
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user.getUserType().getUserType()));
	}

	private List<SimpleGrantedAuthority> getAuthority(String role) {
		return Arrays.asList(new SimpleGrantedAuthority(role));
	}

//	public List<User> findAll() {
//		List<User> list = userRepository.findAll();
//		//userDao.findAll().iterator().forEachRemaining(list::add);
//		return list;
//	}

//	public List<User> delete(Long id) {
////		List<User> list = new ArrayList<>();
////		userDao.deleteById(id);
////		return list;
//		Optional<User> user = userRepository.findById(id);
//		if (user.isPresent()) {
//			User user1 = user.get();
//			user1.setActive(false);
//			userDao.save(user1);
//		}
//		return this.findAll();
//	}

	//Get All
	public ResponseEntity<?> getAllUser() {
		logger.debug("--------->| Get All Users |<---------");
		List<User> users;
		try {
			users = userRepository.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.NOT_FOUND);
		}
		if (users.isEmpty()) {
			logger.debug("No User Record Found");
			return new ResponseEntity<>("{\"No User Record Found\":1}", HttpStatus.NOT_FOUND);
		} else {
			logger.debug("--------->| Users Found Successfully |<---------");
			return new ResponseEntity<>(users, HttpStatus.FOUND);
		}
	}
public ResponseEntity<String> deleteUser(Long id) {
	logger.debug("---------> Delete User By ID <---------");
	try {
		userRepository.deleteROLE_USERSByUsersId(id);
		userRepository.deleteById(id);
	} catch (Exception e) {
		logger.error(e.getMessage(), e);
		return new ResponseEntity<>("{\"User not found\":1}", HttpStatus.NOT_FOUND);
	}
	logger.debug("--------->| User Deleted Successfully |<---------");
	return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
}


	public User findOne(String username) {
		return userRepository.findByEmail(username);
	}

//	public User findById(Long id) {
//		Optional<User> optionalUser = userRepository.findById(id);
//		return optionalUser.isPresent() ? optionalUser.get() : null;
//	}

//    public UserDTO update(UserDTO userDto, Long id) {
//        User user = findById(id);
//        if(user != null) {
//            BeanUtils.copyProperties(userDto, user, "password");
//			userRepository.save(user);
//        }
//        return userDto;
//    }

//    public ApiResponse save(UserDto user) {
//		User founduser = userDao.findByEmail(user.getEmail());
//		if(founduser == null) {
//			User newUser = new User();
//			newUser.setEmail(user.getEmail());
//			newUser.setName(user.getName());
//			newUser.setClientId(user.getClientId());
//			newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//			newUser.setUserType(user.getUserType());
//			newUser.setActive(user.getActive());
//			return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",	userDao.save(newUser));//return ;
//		}else{
//			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "User Already exsist.",null);//return ;
//		}
//
//    }



	public ResponseEntity<?> saveUser(UserDTO userDTO) {
		logger.debug("--------->| Create User: |<---------");
		logger.debug("UserDTO: {}", userDTO);
		User founduser = userRepository.findByEmail(userDTO.getEmail());
		if(founduser == null) {
			try {
				User user = new User();
				user.setStatus("ACTIVE");
				user.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
				user.setName(userDTO.getName());
				user.setEmail(userDTO.getEmail());
				user.setContactNo(userDTO.getContactNo());
				user.setAddress(userDTO.getAddress());
				user.setAuthorizeSignatory(userDTO.getAuthorizeSignatory());
				user.setDepartment(userDTO.getDepartment());
				user.setUserType(userDTO.getUserType());
				user.setRoles(userDTO.getRoles());
				logger.debug("User (POST): {}", user);
				userRepository.save(user);
				logger.debug("--------->| User Created |<---------");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>("{\"Added Successfully\":1}", HttpStatus.CREATED);
		}else{
			return new ResponseEntity<>("{\"User Already Exist\":1}",HttpStatus.NOT_FOUND);
		}

	}

	//Get By id
	public ResponseEntity<?> getUserById(Long id) {
		logger.debug("--------->| Get User By ID |<---------");
		User user;
		try {
			user = userRepository.findById(id).get();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>("{\"User not found\":1}", HttpStatus.NOT_FOUND);
		}
		logger.debug("--------->| User Found Successfully |<---------");
		logger.debug("User (GET): {}", user);
		return new ResponseEntity<>(user, HttpStatus.FOUND);
	}

	//Update
	public ResponseEntity<String> updateUser(Long id, UserDTO userDTO) {
		logger.debug("---------> Update User By ID <---------");
		logger.debug("ID: {}, UserDTO: {}", id, userDTO);
		try {
			User user = userRepository.findById(id).get();
			logger.debug("Old User: {}", user);
			if(user!=null) {
//				user.setAddress(userDTO.getAddress());
//				user.setContactNo(userDTO.getContactNo());
//				user.setEmail(userDTO.getEmail());
//				user.setName(userDTO.getName());
//				user.setPassword(userDTO.getPassword());
//				user.setStatus(userDTO.getStatus());
//				user.setRoles(userDTO.getRoles());
//				user.setDepartment(userDTO.getDepartment());
//				user.setUserType(userDTO.getUserType());
//				user.setAuthorizeSignatory(userDTO.getAuthorizeSignatory());
				BeanUtils.copyProperties(userDTO, user, "password");
				try {
					logger.debug("Updated User (Save): {}", user);
					userRepository.save(user);
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
					return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>("{\"User not found\":1}", HttpStatus.NOT_FOUND);
		}
		logger.debug("--------->| User Updated Successfully |<---------");
		return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);

	}
}
