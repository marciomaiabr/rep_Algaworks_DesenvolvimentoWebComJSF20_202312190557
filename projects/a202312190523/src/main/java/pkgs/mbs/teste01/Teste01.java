package pkgs.mbs.teste01;

import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;

@ManagedBean
public class Teste01 {

	private HtmlInputText campo;
	private HtmlCommandButton botao;

	public HtmlInputText getCampo() {
		return campo;
	}

	public void setCampo(HtmlInputText campo) {
		this.campo = campo;
	}

	public HtmlCommandButton getBotao() {
		return botao;
	}

	public void setBotao(HtmlCommandButton botao) {
		this.botao = botao;
	}

	public void testar() {
		System.out.println("[this.campo.isDisabled()=" + this.campo.isDisabled() + "]");
		/*
		 * TODO : qdo um HtmlInputText no mb é setado setDisabled(true) e o atributo
		 * disabled="disabled" é eliminado do front via devtools do chrome o campo no
		 * front fica liberado para edição porém o método isDisabled no mb ainda retorna
		 * true, gerando assim uma problema de segurança na regra de negócio
		 * https://discord.com/channels/525798627486990346/1186987797819695124
		 */
		this.campo.setDisabled(true);
		this.botao.setStyle("background-color: red; color: white");
	}

}
