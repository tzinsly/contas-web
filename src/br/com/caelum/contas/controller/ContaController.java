package br.com.caelum.contas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {

	@RequestMapping("/")
	public String conta() {

		return "conta/contas";
	}

	@RequestMapping("/formulario")
	public String formulario() {

		return "conta/formulario";
	}

	@RequestMapping("/adicionarConta")
	public ModelAndView addConta(@Valid Conta cnt, BindingResult result) {
		ModelAndView mv;
		String acao = null;

		if (result.hasErrors()) {
			acao = "não adicionada";
			mv = new ModelAndView("conta/formulario");
			mv.addObject("acao", acao);
			return mv;
		}

		acao = "adicionada";
		System.out.println("Conta adicionada é: " + cnt.getDescricao());
		ContaDAO cntDao = new ContaDAO();
		cntDao.adiciona(cnt);

		mv = new ModelAndView("conta/conta-acao");
		mv.addObject("acao", acao);
		return mv;
	}

	@RequestMapping("/removeConta")
	public String removeConta(Conta cnt) {
		System.out.println("Conta removida é: " + cnt.getDescricao());
		ContaDAO cntDao = new ContaDAO();
		cntDao.remove(cnt);

		return "redirect:listaContas";
		//Forward x Redirect
		//Fowrard: proprio servidor faz requisição para a nova url, portanto lado cliente, browser não ve isso e não muda a url
		//Redirect: Servidor pede para o browser, lado cliente, fazer uma nova requisição para a nova url
	}

	//Mandando valores para JSP
	@RequestMapping("/listaContas")
	public ModelAndView lista() {

		ContaDAO cntDao = new ContaDAO();
		List<Conta> contas = cntDao.lista();

		ModelAndView mv = new ModelAndView("conta/lista");
		mv.addObject("todasContas", contas);
		return mv;
	}

	@RequestMapping("/mostraConta")
	public ModelAndView mostra(Long id) {
		ContaDAO dao = new ContaDAO();
		//model.addAttribute("conta", dao.buscaPorId(id));
		//return "conta/mostra";
		ModelAndView mv = new ModelAndView("conta/mostra");
		mv.addObject(dao.buscaPorId(id));

		return mv;
	}

	@RequestMapping("/alteraConta")
	public String altera(Conta conta) {
		ContaDAO dao = new ContaDAO();
		dao.altera(conta);
		return "redirect:listaContas";
	}

}
