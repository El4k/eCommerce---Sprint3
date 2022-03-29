package pear.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TelaSaida implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession sessao = request.getSession();
			sessao.invalidate();
			return "redirect:pear?acao=TelaEntrada";
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}