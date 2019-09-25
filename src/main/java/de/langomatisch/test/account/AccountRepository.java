package de.langomatisch.test.account;

import de.langomatisch.test.user.User;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {

}