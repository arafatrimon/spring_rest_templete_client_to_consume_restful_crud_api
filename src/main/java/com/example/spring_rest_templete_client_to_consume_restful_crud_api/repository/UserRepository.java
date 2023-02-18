package com.example.spring_rest_templete_client_to_consume_restful_crud_api.repository;

import com.example.spring_rest_templete_client_to_consume_restful_crud_api.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
