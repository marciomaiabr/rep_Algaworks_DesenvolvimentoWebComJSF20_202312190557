package pkgs.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ItemEstoque implements Serializable {

	private Integer codigoProduto;
	private String descricao;
	private Short quantidade;
	private BigDecimal valorUnitario;
	private Date dataChecagem;

	public Integer getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Date getDataChecagem() {
		return dataChecagem;
	}

	public void setDataChecagem(Date dataChecagem) {
		this.dataChecagem = dataChecagem;
	}

	public ItemEstoque() {
	}

	public ItemEstoque(Integer codigoProduto, String descricao, Short quantidade, BigDecimal valorUnitario,
			Date dataChecagem) {
		this.codigoProduto = codigoProduto;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.dataChecagem = dataChecagem;
	}

	@Override
	public String toString() {
		return "ItemEstoque [codigoProduto=" + codigoProduto + ", descricao=" + descricao + ", quantidade=" + quantidade
				+ ", valorUnitario=" + valorUnitario + ", dataChecagem=" + dataChecagem + "]";
	}

}
