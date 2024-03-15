package calculadora.danilo.alves.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

	private enum TipoComando {
		ZERAR, SINAL, NUMERO, DIV, MULT, SUB, SOMA, IGUAL, VIRGULA	
	};
	
	private static Memoria instancia;
	private String textoAtual = "";
	private String textoBuffer = "";
	private boolean substituirDisplay = false;
	private TipoComando ultimaOperacao = null;
	private final List<MemoriaObserver> observers = new ArrayList<>();
	
	private Memoria() {

	}
	
	public static Memoria getInstancia() {
		if(instancia == null) {
			instancia = new Memoria();
		}
		
		return instancia;
	}
	
	public void adicionarObserver(MemoriaObserver observer) {
		observers.add(observer);
	}
	
	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0,00" : textoAtual;
	}
	
	public void processarComando(String texto) {
		
		TipoComando tipoComando = detectarTipoComando(texto);
				
		if(tipoComando == null) {
			return;
		} else if (tipoComando == TipoComando.ZERAR) {
			textoAtual = "";
			textoBuffer = "";
			substituirDisplay = false;
			ultimaOperacao = null;
		} else if (tipoComando == TipoComando.SINAL && textoAtual.contains("-")) {
			textoAtual = textoAtual.substring(1);
		} else if (tipoComando == TipoComando.SINAL && !textoAtual.contains("-")) {
			textoAtual = "-" + textoAtual;
		} else if (tipoComando == TipoComando.NUMERO || tipoComando == TipoComando.VIRGULA) {
			textoAtual = substituirDisplay ? texto : textoAtual + texto;
			substituirDisplay = false;
		} else {
			substituirDisplay = true;
			textoAtual = obterResultadoOperacao();
			textoBuffer = textoAtual;
			ultimaOperacao = tipoComando;
		}
		
		observers.forEach(o -> o.valorAlterado(getTextoAtual()));
	}

	private String obterResultadoOperacao() {
		if(ultimaOperacao == null || ultimaOperacao == TipoComando.IGUAL) {
			return textoAtual;
		}
		
		double numeroBuffer = Double.parseDouble(textoBuffer.replace(",", "."));
		double numeroAtual = Double.parseDouble(textoAtual.replace(",", "."));
		
		double resultado = 0;
		
		if(ultimaOperacao == TipoComando.SOMA) {
			resultado = numeroBuffer + numeroAtual; 	
		} else if(ultimaOperacao == TipoComando.SUB) {
			resultado = numeroBuffer - numeroAtual; 	
		} else if(ultimaOperacao == TipoComando.MULT) {
			resultado = numeroBuffer * numeroAtual; 	
		} else if(ultimaOperacao == TipoComando.DIV) {
			resultado = numeroBuffer / numeroAtual; 	
		}
		
		String resultadoString = Double.toString(resultado).replace(".", ",");
		boolean inteiro = resultadoString.endsWith(",0");
		return inteiro ? resultadoString.replace(",0", "") : resultadoString;
	}

	private TipoComando detectarTipoComando(String texto) {
		
		if(textoAtual.isEmpty() && texto == "0") {
			return null;
		}
		
		try {
			Integer.parseInt(texto);
			return TipoComando.NUMERO;
		} catch (NumberFormatException e) {
			if("AC".equals(texto)) {
				return TipoComando.ZERAR;
			} else if("/".equals(texto)) {
				return TipoComando.DIV;
			} else if("±".equals(texto)) {
				return TipoComando.SINAL;
			} else if("*".equals(texto)) {
				return TipoComando.MULT;
			} else if("+".equals(texto)) {
				return TipoComando.SOMA;
			} else if("-".equals(texto)) {
				return TipoComando.SUB;
			} else if("=".equals(texto)) {
				return TipoComando.IGUAL;
			} else if(",".equals(texto) && !textoAtual.contains(",")) {
				return TipoComando.VIRGULA;
			}
		}
		
		return null;
	}
}
