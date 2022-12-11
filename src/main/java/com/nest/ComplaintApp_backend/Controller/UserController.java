package com.nest.ComplaintApp_backend.Controller;

import com.nest.ComplaintApp_backend.dao.UserDao;
import com.nest.ComplaintApp_backend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao udao;

    @GetMapping("/")
    public  String Homepage(){

        return "welcome page";
    }
    @PostMapping(path="/userReg",consumes = "application/json",produces = "application/json")
    public HashMap<String,String>UserRegisteration(@RequestBody UserModel um){
        HashMap<String,String>hm=new HashMap<>();
        List<UserModel> result= (List<UserModel>)udao.FindUser(um.getUsername());
        if (result.size() !=0){
            hm.put("status","failed");
        }else{
            udao.save(um);
            hm.put("status","success");
        }

        return hm;

    }
    @PostMapping(path="/userLogin",consumes = "application/json",produces = "application/json")
    public HashMap<String,String>UserLogin(@RequestBody UserModel um){

       List<UserModel> result= (List<UserModel>)udao.UserLogin(um.getUsername(),um.getPassword());
       HashMap<String,String>hm = new HashMap<>();
       if(result.size() == 0){
           hm.put("status","failed");
       }else {
           hm.put("status","success");
       }
       return hm;

    }
}
