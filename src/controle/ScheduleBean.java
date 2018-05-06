package controle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

@ManagedBean
@ViewScoped
public class ScheduleBean {

	
	private ScheduleModel eventoModel;
	
		
	
	public ScheduleModel getEventoModel() {
		return eventoModel;
	}


	public void setEventoModel(ScheduleModel eventoModel) {
		this.eventoModel = eventoModel;
	}


	
	
	
	@PostConstruct
    public void init() {
		
		eventoModel = new DefaultScheduleModel();
		
	}
	
	
}
