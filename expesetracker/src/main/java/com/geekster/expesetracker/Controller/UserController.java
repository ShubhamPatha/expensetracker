package com.geekster.expesetracker.Controller;

import com.geekster.expesetracker.Service.AuthenticationService;
import com.geekster.expesetracker.Service.UserService;
import com.geekster.expesetracker.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;


    //sign up, sign in , sign out a particular instagram user
    @PostMapping("user/signup")
    public com.geekster.InstaBackend.model.dto.SignUpOutput signUpInstaUser(@RequestBody User user)
    {

        return userService.signUpUser(user);
    }

    @PostMapping("user/signIn")
    public String sigInInstaUser(@RequestBody @Valid com.geekster.InstaBackend.model.dto.SignInInput signInInput)
    {
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("user/signOut")
    public String sigOutInstaUser(String email, String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.sigOutUser(email);
        }
        else {
            return "Sign out not allowed for non authenticated user.";
        }

    }

    @PostMapping("addexpense")
    public String Addexp(@RequestBody @Valid  User user)
    {
      return   userService.addexpense(user);

    }

    @GetMapping("findall")
    public Iterable<User> findexpense()
    {
        return userService.findallexpense();
    }


    @DeleteMapping("Deleteexpense")
    public String removeexpense(@RequestParam Integer userId, @RequestParam String email, @RequestParam String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.removeexpense(userId,email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }

}
