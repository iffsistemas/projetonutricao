package controle;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import modelo.Schedule;
import service.ScheduleService;

@ManagedBean
@ViewScoped
public class ScheduleBean {
	
	
	
	
	
	
	@EJB
	ScheduleService scheduleService;
	
		
	
	
	private Schedule agenda = new Schedule();
	List<Schedule> listaCompromissos;
	
	

	public List<Schedule> getListaCompromissos() {
	return listaCompromissos;
	}

	public void setListaCompromissos(List<Schedule> listaCompromissos) {
	this.listaCompromissos = listaCompromissos;
	}
	
	public Schedule getAgenda() {
		return agenda;
	}
	
	public void setAgenda(Schedule agenda) {
		this.agenda = agenda;
	}
	

	
	
	public void salvarCompromisso() {

		scheduleService.create(agenda); 
		atualizarCalendario();
	}

	
	private ScheduleModel eventoModel;
	private ScheduleEvent event = new DefaultScheduleEvent();
	
	
	
	public ScheduleEvent getEvent() {
		return event;
	}
	
	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}
		
	
	public ScheduleModel getEventoModel() {
		return eventoModel;
	}


	public void setEventoModel(ScheduleModel eventoModel) {
		this.eventoModel = eventoModel;
	}

	
	public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
        agenda.setDataSelecionada(event.getStartDate());
    }
	
	
	
	@PostConstruct
    public void init() {
		
		atualizarCalendario();
		
		
	}
	
	public void atualizarCalendario() {
		eventoModel = new DefaultScheduleModel();
		List<Schedule> sS = scheduleService.listAll();
		for(Schedule s: sS) {
			eventoModel.addEvent(new DefaultScheduleEvent(s.getCompromisso(), s.getDataSelecionada(), s.getDataSelecionada()));
		}
			
			
	}
	

}
