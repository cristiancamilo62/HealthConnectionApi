package com.healthconnection.infrastructure.security.service;

import com.healthconnection.domain.model.patient.PatientDomain;
import com.healthconnection.domain.ports.output.PatientRepositoryPort;
import com.healthconnection.shared.helper.ObjectHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.List;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final PatientRepositoryPort patientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        PatientDomain patientDomain = patientRepository.findByEmail(username)
                .orElse(null);


        if (!ObjectHelper.isNull(patientDomain)) {

            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER_ROLE");

            return new org.springframework.security.core.userdetails.User(
                    patientDomain.getEmail(),
                    patientDomain.getPassword(),
                    patientDomain.isAccountStatement(),
                    true, true, true, List.of(authority)
            );
        }
        return null;
    }
}

