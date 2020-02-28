package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.TxrService;

@Controller
public class TxrController {

	@Autowired
	private TxrService txrService;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping(value = "/")
	public String rootPage() {
		return "home";
	}

	@GetMapping(value = "/home")
	public String home() {
		return "home";
	}

	@GetMapping(value = "/txr")
	public String txrForm(Model model) {
		Account account=accountRepository.findById("1").get();
		model.addAttribute("account", account);
		return "txr-form";
	}
	
	@GetMapping(value = "/account")
	public String accountDet(Model model) {
		Account account=accountRepository.findById("1").get();
		model.addAttribute("account", account);
		return "account-det";
	}

	@PostMapping(value = "/txr")
	public String txr(Model model, @ModelAttribute TxrRequest request) {
		boolean b = txrService.txr(request.getAmount(), request.getFromAccNum(), request.getToAccNum());
		TxrResponse response = new TxrResponse();

		if (b) {
			response.setMessage("success");
		} else {
			response.setMessage("failed");
		}
		model.addAttribute("response", response);
		return "redirect:account";

	}

}
