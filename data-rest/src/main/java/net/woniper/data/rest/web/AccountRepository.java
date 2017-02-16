package net.woniper.data.rest.web;

import net.woniper.data.rest.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by woowahan on 2017. 2. 16..
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}
