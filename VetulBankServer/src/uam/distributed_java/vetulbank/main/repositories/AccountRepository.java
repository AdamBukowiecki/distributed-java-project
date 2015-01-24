package uam.distributed_java.vetulbank.main.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uam.distributed_java.vetulbank.main.models.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {

	public Account getById(String id);
	public void deleteAccountById(String id);
	
}
