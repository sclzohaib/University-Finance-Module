package com.erp.university.Purchase.Controller;


import com.erp.university.Config.ApiResponse;
import com.erp.university.Config.AuthToken;
import com.erp.university.Config.JwtTokenUtil;
import com.erp.university.Purchase.DTO.LoginUser;
import com.erp.university.Purchase.DTO.UserDTO;
import com.erp.university.Purchase.Model.User;
import com.erp.university.Purchase.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ApiResponse<AuthToken> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        final User user = userService.findOne(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);

        return new ApiResponse<>(200, "success",new AuthToken(token,user.getName(),user.getUserType().getUserType(),user.getEmail()));
    }


    @PostMapping("/user/")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);

//        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",userService.saveUser(user));
    }

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers(){
        return this.userService.getAllUser();
    }

//    @DeleteMapping("/user/{id}")
//    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
//        return this.userService.deleteUser(id);
//    }

    //Update
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id, @Valid @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    //delete by id
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable("id") @Min(value = 1, message = "ID must be greater than 1") Long id) {
        return this.userService.deleteUser(id);
    }
}
