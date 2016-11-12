package net.woniper.token;

import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by woniper on 2016. 11. 12..
 */
public class UserMappingTest {

    private UserEntity user;

    @Before
    public void setUp() throws Exception {
        user = new UserEntity();
        user.setUsername("woniper");
        user.setAge(28);
    }

    @Test
    public void testSetterMapping() throws Exception {
        // given
        UserDto userDto = new UserDto();

        // when
        userDto.setUsername(user.getUsername());
        userDto.setAge(user.getAge());

        // then
        assertUser(user, userDto);
    }

    @Test
    public void testModelMapperMapping() throws Exception {
        // given
        ModelMapper mapper = new ModelMapper();
        UserDto userDto = new UserDto();

        // when
        mapper.map(user, userDto);

        // then
        assertUser(user, userDto);
    }

    private void assertUser(UserEntity entity, UserDto dto) {
        assertThat(entity.getUsername(), is(dto.getUsername()));
        assertThat(entity.getAge(), is(dto.getAge()));
    }
}
