package pear.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pear.util.CorreiosUtil;

public class TelaCorreios implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CorreiosUtil.executa(request, response);
		return "forward:frete.jsp";
	}

}
