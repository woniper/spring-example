package net.woniper.querydsl;

import com.querydsl.core.BooleanBuilder;

import net.woniper.querydsl.domain.Foo;
import net.woniper.querydsl.domain.QFoo;
import net.woniper.querydsl.repository.FooRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootQuerydslApplicationTests {

    @Autowired
    private FooRepository repository;

    @Before
    public void setUp() throws Exception {
        repository.save(new Foo("foo1"));
        repository.save(new Foo("foo2"));
        repository.save(new Foo("foo3"));
        repository.save(new Foo("bar1"));
        repository.save(new Foo("bar2"));
        repository.save(new Foo("bar3"));
    }

    @Test
	public void testFoo() {
        Foo foo1 = repository.findByBar("foo1");
        assertThat(foo1.getBar(), is("foo1"));
    }

    @Test
    public void testQuerydslFindLikeBar() throws Exception {
        // given
        String likeWhere = "bar%";
        QFoo foo = QFoo.foo;
        BooleanBuilder builder = new BooleanBuilder().and(foo.bar.like(likeWhere));

        // when
        Iterable<Foo> foos = repository.findAll(builder);

        // then
        foos.forEach(System.out::println);
        foos.forEach(f -> assertTrue(f.getBar().startsWith("bar")));
    }
}
