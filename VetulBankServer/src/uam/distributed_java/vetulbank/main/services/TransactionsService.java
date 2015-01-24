package uam.distributed_java.vetulbank.main.services;

import java.util.List;

import uam.distributed_java.vetulbank.main.models.Transaction;;

public interface TransactionsService {
	public List<Transaction> getTransactionsOfAccountById(String id);
}
