package com.example.spring_rest_templete_client_to_consume_restful_crud_api.controller;

import com.example.spring_rest_templete_client_to_consume_restful_crud_api.entity.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RestClient {

    private static final String GET_ALL_USERS_API = "http://localhost:8080/api/users";
    private static final String GET_USER_BY_ID_API= "http://localhost:8080/api/users/{id}";
    private static final String CREATE_USER_API = "http://localhost:8080/api/users";
    private static final String UPDATE_USER_API = "http://localhost:8080/api/users/{id}";
    private static final String DELETE_USER_API = "http://localhost:8080/api/users/{id}";

    RestTemplate restTemplate= new RestTemplate();

    private void callGetAllUsersAPI(){
        HttpHeaders headers= new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity= new HttpEntity<>("parameters",headers);
      ResponseEntity<String> results =  restTemplate.exchange(GET_ALL_USERS_API, HttpMethod.GET,entity,String.class);
        System.out.println(results);
    }

    private void callGetUserByIdAPI(){
        Map<String,Integer> param=new HashMap<>();
        param.put("id",1);
        restTemplate.getForObject(GET_USER_BY_ID_API, CREATE_USER_API.getClass(),param);
    }
    private void callCreateUserAPI(){
        User user=new User("Arafat","Software Programmer","arafat@gmail.com");
       ResponseEntity<User> result = restTemplate.postForEntity(CREATE_USER_API,user,User.class);
        System.out.println(result.getBody());
    }
    private void callUpdateUserAPI(){
        Map<String,Integer> param = new HashMap<>();
        param.put("id",20);

        User updateUser=new User("Rimon","Software Programmer","arafat@gmail.com");

        restTemplate.put(UPDATE_USER_API,updateUser,param);
    }
    private void callDeleteAPI(){
        Map<String,Integer> param =new HashMap<>();
        param.put("id",20);
        restTemplate.delete(DELETE_USER_API,param);
    }
}
