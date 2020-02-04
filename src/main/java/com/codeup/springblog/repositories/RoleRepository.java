package com.codeup.springblog.repositories;

import com.codeup.springblog.models.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.management.relation.Role;
import java.util.List;

public interface RoleRepository extends CrudRepository<UserRole, Long> {
    @Query("SELECT ur.role FROM UserRole ur, User u WHERE u.username=?1 and ur.userId = u.id")
    List<String> ofUserWith(String username);
}