package project.transaction;

import java.util.List;

import project.actors.BankClient;
import project.utilities.StdInput;

public class DeleteTransaction {
	private List<BankClient> bankClients;
	private int pos;
	
	private int accountNum;

	public DeleteTransaction(List<BankClient> bankClients, int pos) {
		this.bankClients = bankClients;
		this.pos = pos;
		
		provideAccountNumber();
		if(checkTransactionStructure() != null) {
			printErrorMessage(checkTransactionStructure());
		}
		else {
			executeDeleteTransaction();
		}
	}
	
	private void provideAccountNumber() {
		bankClients.get(pos).printAccounts();
		accountNum = Integer.parseInt(StdInput.read("account number"));
		
	}
	
	private String checkTransactionStructure() {
		//TODO look into this, look for a workaround
		if(bankClients != null) {
			for( int index = 0; index < bankClients.get(pos).getAccounts().size(); index++ ) {
				if( bankClients.get(pos).getAccounts().get(index).getAccountNumber() ==  accountNum) {
					return null;
				}
			}
		}
		return "Invalid Bank Account Number";
	}
	
	private void printErrorMessage(String message) {
		System.err.println(message);
	}
	
	private void executeDeleteTransaction() {
			bankClients.remove(pos);
	}
	
}
