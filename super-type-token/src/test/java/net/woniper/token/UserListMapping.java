package net.woniper.token;

import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Created by woniper on 2016. 11. 12..
 */
public class UserListMapping {

    @Test
    public void testMapping() throws Exception {
        // given
        List<UserEntity> users = createUserEntityList();
        ModelMapper mapper = new ModelMapper();

        // when
        List<UserDto> userDtos = mapper.map(users, new TypeToken<List<UserDto>>(){}.getType());

        // then
        assertEquals(users.size(), userDtos.size());
        for (int i = 0; i < users.size(); i++) {
            UserEntity entity = users.get(i);
            UserDto dto = userDtos.get(i);
            assertThat(entity.getUsername(), is(dto.getUsername()));
            assertThat(entity.getAge(), is(dto.getAge()));
        }
    }

    @Test
    public void testFailMapping() throws Exception {
        // given
        List<UserEntity> users = createUserEntityList();
        List<UserDto> userDtos = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();

        // when
        mapper.map(users, userDtos);

        // then
        assertFalse(users.size() == userDtos.size());
    }

    private List<UserEntity> createUserEntityList() {
        List<UserEntity> users = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            users.add(new UserEntity("woniper" + i, 28));
        }

        return users;
    }
}
