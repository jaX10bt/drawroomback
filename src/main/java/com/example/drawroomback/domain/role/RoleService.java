package com.example.drawroomback.domain.role;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import static com.example.drawroomback.business.Role.ROLE_CUSTOMER;


@Service
public class RoleService {


    @Resource
    private RoleRepository roleRepository;

    public Role getRoleCustomer() {
        return roleRepository.getReferenceById(ROLE_CUSTOMER);
    }
}
