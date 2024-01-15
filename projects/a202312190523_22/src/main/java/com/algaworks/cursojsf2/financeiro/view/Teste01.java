package com.algaworks.cursojsf2.financeiro.view;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;

import com.algaworks.cursojsf2.financeiro.util.FacesUtil;

@ManagedBean
public class Teste01 implements Serializable {

	public Teste01() {
		System.out.println("Teste01.Teste01()");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Teste01.postConstruct()");
	}

	private String descricao;
	private Part arquivo;

	public void enviar() {
		String nomeArquivoSaida = "C:\\tmp\\"+arquivo.getSubmittedFileName();
		try(
				InputStream is = arquivo.getInputStream();
				OutputStream out = new FileOutputStream(nomeArquivoSaida);
				){

			int read = 0;
			byte [] bytes = new byte[1024];
			
			while((read = is.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Arquivo \""+descricao+"\" enviado com sucesso.");
		} catch(IOException e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Erro ao enviar arquivo.");
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Part getArquivo() {
		return arquivo;
	}

	public void setArquivo(Part arquivo) {
		this.arquivo = arquivo;
	}

}
