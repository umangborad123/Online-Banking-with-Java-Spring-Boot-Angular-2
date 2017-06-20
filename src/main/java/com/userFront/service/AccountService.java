package com.userFront.service;

import com.userFront.domain.PrimaryAccount;
import com.userFront.domain.SavingsAccount;

public interface AccountService {

	PrimaryAccount createPrimaryAccount();
	SavingsAccount createSavingsAccount();
}
