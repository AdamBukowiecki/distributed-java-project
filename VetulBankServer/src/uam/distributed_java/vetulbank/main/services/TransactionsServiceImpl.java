package uam.distributed_java.vetulbank.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import uam.distributed_java.vetulbank.main.models.Transaction;

@Service
public class TransactionsServiceImpl implements TransactionsService {
	
	@Override
	public List<Transaction> getTransactionsOfAccountById(String id) {
		// TODO actorManager znajduje account'a po id i zwraca liste jego transakcji
		return null;
	}

}
