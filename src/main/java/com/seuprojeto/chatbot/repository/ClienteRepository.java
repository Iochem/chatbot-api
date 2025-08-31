package com.seuprojeto.chatbot.repository;


import com.seuprojeto.chatbot.entity.ClienteEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.HashMap;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteRepository, Long> {

}



