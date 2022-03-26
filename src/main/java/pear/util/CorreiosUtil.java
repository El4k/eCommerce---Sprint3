package pear.util;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import pear.controller.PedidoController;
import pear.controller.UsuarioController;
import pear.model.Pedido;
import pear.model.Usuario;

public class CorreiosUtil {
	
	public static String executa(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		Pedido pedido = (Pedido) sessao.getAttribute("pedido");
		PedidoController pedidoController = new PedidoController();
		
		String url = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx?nCdEmpresa=08082650&sDsSenha=564321&sCepOrigem=70002900&sCepDestino="+usuario.getEndereco().getCEP()+"&nVlPeso=1&nCdFormato=1&nVlComprimento=20&nVlAltura=20&nVlLargura=20&sCdMaoPropria=n&nVlValorDeclarado=0&sCdAvisoRecebimento=n&nCdServico=04510&nVlDiametro=0&StrRetorno=xml&nIndicaCalculo=3";
		Document doc = documento(url);
		
		pedido.setValorFrete(getValorFrete(doc));
		pedido.setPrazoEntrega(getPrazoEntrega(doc));
		
		pedidoController.atualizar(pedido);
		sessao.setAttribute("pedido", pedido);
		
		System.err.println("Valor do Frete: " + pedido.getValorFrete());
		System.err.println("Tempo do Prazo: " + pedido.getPrazoEntrega());
		
		return "forward:frete.jsp";
	}
	
	protected static Document documento(String url) {
		try {
			HttpRequest requestClient = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
			HttpClient httpClient = HttpClient.newHttpClient();
			HttpResponse<String> responseClient = httpClient.send(requestClient, BodyHandlers.ofString());
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(responseClient.body())));
			doc.getDocumentElement().normalize();
			return doc;
		} catch (IOException | InterruptedException | ParserConfigurationException | SAXException e) {
			throw new RuntimeException(e);
		}
	}

	protected static Double getValorFrete(Document doc) {
		String frete = doc.getElementsByTagName("Valor").item(0).getTextContent().replace(",", ".");
		Double valorFrete = Double.parseDouble(frete);
		return valorFrete;
	}

	protected static Integer getPrazoEntrega(Document doc) {
		String prazo = doc.getElementsByTagName("PrazoEntrega").item(0).getTextContent().replace(",", ".");
		Integer prazoEntrega = Integer.parseInt(prazo);
		return prazoEntrega;
	}
}
