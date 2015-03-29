package br.com.soeirosantos.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.soeirosantos.entity.Participante;
import br.com.soeirosantos.repository.Participantes;

@Named
@ViewScoped
public class CadastroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Participantes participantes;
	
	private Participante participante = new Participante();

	public Participante getParticipante() {
		return this.participante;
	}
	
	public List<Participante> getParticipantes() {
		return this.participantes.listaTodos();
	}
	
	public void gravar(ActionEvent event) {
		participantes.adicionar(participante);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Você foi cadastrado com sucesso neste Evento."));
	}
	
	
}
