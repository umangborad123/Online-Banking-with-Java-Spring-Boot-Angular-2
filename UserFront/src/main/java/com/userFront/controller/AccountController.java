package com.userFront.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userFront.domain.PrimaryAccount;
import com.userFront.domain.PrimaryTransaction;
import com.userFront.domain.SavingsAccount;
import com.userFront.domain.SavingsTransaction;
import com.userFront.domain.User;
import com.userFront.service.AccountService;
import com.userFront.service.TransactionService;
import com.userFront.service.UserService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private UserService userService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private TransactionService transactionService;

	@RequestMapping("/primaryAccount")
	public String primaryAccount(Model model, Principal principal) {
		List<PrimaryTransaction> primaryTransactionList = transactionService
				.findPrimaryTransactionList(principal.getName());

		User user = userService.findByUsername(principal.getName());
		PrimaryAccount primaryAccount = user.getPrimaryAccount();

		model.addAttribute("primaryAccount", primaryAccount);
		model.addAttribute("primaryTransactionList", primaryTransactionList);

		return "primaryAccount";
	}

	@RequestMapping("/savingsAccount")
	public String savingsAccount(Model model, Principal principal) {
		List<SavingsTransaction> savingsTransactionList = transactionService
				.findSavingsTransactionList(principal.getName());
		User user = userService.findByUsername(principal.getName());
		SavingsAccount savingsAccount = user.getSavingsAccount();

		model.addAttribute("savingsAccount", savingsAccount);
		model.addAttribute("savingsTransactionList", savingsTransactionList);

		return "savingsAccount";
	}

	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
	public String deposit(Model model) {
		model.addAttribute("accountType", "");
		model.addAttribute("amount", "");

		return "deposit";
	}

	@RequestMapping(value = "/deposit", method = RequestMethod.POST)
	public String depositPOST(@ModelAttribute("amount") String amount,
			@ModelAttribute("accountType") String accountType, Principal principal) {
		accountService.deposit(accountType, Double.parseDouble(amount), principal);

		return "redirect:/userFront";
	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	public String withdraw(Model model) {
		model.addAttribute("accountType", "");
		model.addAttribute("amount", "");

		return "withdraw";
	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public String withdrawPOST(@ModelAttribute("amount") String amount,
			@ModelAttribute("accountType") String accountType, Principal principal) {
		accountService.withdraw(accountType, Double.parseDouble(amount), principal);

		return "redirect:/userFront";
	}
}
