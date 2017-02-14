package model;

import exception.LackOfBalanceException;

public class AccountVO {
	private int accountNo;
	private String name;
	private String password;
	private int balance;

	public AccountVO(int accountNo, String name, String password, int balance) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.password = password;
		this.balance = balance;
	}

	public AccountVO(String name, String password, int balance) throws LackOfBalanceException {
		super();
		this.name = name;
		this.password = password;
		if (balance < 1000)
			throw new LackOfBalanceException("1000원 이상 입금하세요");
		this.balance = balance;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountVO [accountNo=" + accountNo + ", name=" + name + ", balance=" + balance + "]";
	}
}
