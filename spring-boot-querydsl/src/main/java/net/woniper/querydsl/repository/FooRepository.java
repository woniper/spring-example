package net.woniper.querydsl.repository;

import net.woniper.querydsl.domain.Foo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by woniper on 2016. 10. 22..
 */
public interface HelloRepository extends JpaRepository<Foo, Long> {
}
