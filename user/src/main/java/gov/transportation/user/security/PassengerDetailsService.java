package gov.transportation.user.security;

import gov.transportation.user.User;
import gov.transportation.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PassengerDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public PassengerDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User not found"));
        return PassengerDetails.buildPassengerDetails(user);
    }
}
