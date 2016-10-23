package net.woniper.querydsl.repository;

import net.woniper.querydsl.domain.Foo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by woniper on 2016. 10. 22..
 */
public interface FooRepository extends JpaRepository<Foo, Long>, QueryDslPredicateExecutor<Foo> {
    Foo findByBar(String bar);
}
