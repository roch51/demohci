package com.example.demo.services;

import com.example.demo.dto.ModuleByUserDto;
import com.example.demo.repositories.UserModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ModuleService {

    @Autowired
    UserModuleRepository userModuleRepository ;

    public HashMap<String, Object> findByUserId(Long userId) {
        List<ModuleByUserDto> modules = userModuleRepository.findByUserId(userId) ;

        HashMap<String, Object> response = new HashMap<>();
        response.put("modules",modules) ;

        return response ;
    }
}
