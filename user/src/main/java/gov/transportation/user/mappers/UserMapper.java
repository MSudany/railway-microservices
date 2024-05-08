package gov.transportation.user.mappers;

import gov.transportation.user.dtos.SignUpDto;
import gov.transportation.user.dtos.UserDto;
import gov.transportation.user.User;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
