package tools;

import java.util.Date;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import modelo.Paciente;
import modelo.PacienteAdulto;
import service.PacienteService;

@ManagedBean
public class InitBean {
	
	@EJB
	PacienteService pacienteService;

	
	public void iniciar() {
		Paciente pac = new PacienteAdulto();
		pac.setDataNascimento(new Date());
		pac.setEfAbdmon("teste");
		pac.setEfCabeca("cabeça");
		pac.setEfEdema("edema");
		pac.setEfMmii("membros inferiores");
		pac.setEfMmss("Membros Superiores");
		pac.setEfPescoco("Pescoço");
		pac.setEmail("123@123.com");
		pac.setIdade(25);
		pac.setNome("Fulano da Silva");
	}
	
}
