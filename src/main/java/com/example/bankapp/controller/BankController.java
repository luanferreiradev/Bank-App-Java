package com.example.bankapp.controller;

import com.example.bankapp.model.Account;
import com.example.bankapp.model.LoanRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/accounts")
public class BankController {

    @GetMapping("/{accountNumber}")
    public String getBalance(@PathVariable String accountNumber, Model model) {
        // Lógica para buscar o saldo da conta com base no número da conta
        double balance = 1000; // Supondo um valor de saldo fixo por enquanto
        model.addAttribute("accountNumber", accountNumber);
        model.addAttribute("balance", balance);
        model.addAttribute("loanRequest", new LoanRequest());
        return "account";
    }

    @PostMapping("/check-balance")
    public String checkBalance(@ModelAttribute("account") Account account, Model model) {
        // Lógica simulada para consulta de saldo
        double balance = 1000;
        model.addAttribute("balance", balance);
        return "account";
    }

    @PostMapping("/request-loan")
    public String requestLoan(@ModelAttribute("loanRequest") LoanRequest loanRequest, Model model) {
        // Lógica simulada para solicitação de empréstimo
        String loanResult = loanRequest.getLoanAmount() <= 10000 ? "Empréstimo aprovado!" : "Empréstimo negado.";
        model.addAttribute("loanResult", loanResult);
        return "account";
    }
}
