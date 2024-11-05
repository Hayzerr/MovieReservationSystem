package com.bolashak.MovieReservationSystem.bootstrap;

import com.bolashak.MovieReservationSystem.entities.Role;
import com.bolashak.MovieReservationSystem.entities.User;
import com.bolashak.MovieReservationSystem.entities.enums.RoleEnum;
import com.bolashak.MovieReservationSystem.repository.RoleRepository;
import com.bolashak.MovieReservationSystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AdminSeeder implements ApplicationListener<ContextRefreshedEvent> {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.createSuperAdmin();
    }

    private void createSuperAdmin() {
        Role role = roleRepository.findByName(RoleEnum.SUPER_ADMIN).orElseGet(() -> {
            Role newRole = new Role();
            newRole.setName(RoleEnum.SUPER_ADMIN);
            newRole.setDescription("Administrator role with full privileges");
            return roleRepository.save(newRole);
        });

        Optional<User> optionalUser = userRepository.findByEmail("admin@mail.ru");

        if(optionalUser.isPresent()){
            return;
        }

        User admin = new User();
        admin.setUsername("admin");
        admin.setEmail("admin@mail.ru");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setRole(role);
        userRepository.save(admin);
    }
}
