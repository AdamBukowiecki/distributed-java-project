package uam.distributed_java.vetulbank.main.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uam.distributed_java.vetulbank.main.models.Transaction;
import uam.distributed_java.vetulbank.main.repositories.TransactionRepository;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {

	@Autowired
	private TransactionRepository transactionsRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public void performTransaction(@Valid @RequestBody Transaction transaction) {
		// TODO
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Transaction getTransactionById(@PathVariable String id) {
		// TODO actorManager zleca poszukanie transakcji o podanym id
		return null;
	}
	
}
