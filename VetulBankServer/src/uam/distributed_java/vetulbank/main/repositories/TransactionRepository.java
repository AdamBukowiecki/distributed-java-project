package uam.distributed_java.vetulbank.main.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uam.distributed_java.vetulbank.main.models.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String> {

}
