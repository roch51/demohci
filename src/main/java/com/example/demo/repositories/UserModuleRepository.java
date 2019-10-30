package com.example.demo.repositories;

import com.example.demo.dto.ModuleByUserDto;
import com.example.demo.models.UserModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserModuleRepository extends JpaRepository<UserModule,Long> {

    @Query("select new com.example.demo.dto.ModuleByUserDto(m.moduleName, um.menuOrder) " +
            "from UserModule um " +
            "inner join Module m ON m.id = um.moduleId " +
            "where um.userId = :userId " +
            "order by um.menuOrder")
    List<ModuleByUserDto> findByUserId(@Param("userId") Long userId) ;
}
