package tools;

import java.util.Date;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

//@ManagedBean
public class InitBean {
	
	//@EJB
	//PacienteService pacienteService;

	
	public void iniciar() {
		Paciente pac = new PacienteAdulto();
		pac.setDataNascimento(new Date());
		
		/*
		pac.setEfAbdmon("teste");
		pac.setEfCabeca("cabe�a");
		pac.setEfEdema("edema");
		pac.setEfMmii("membros inferiores");
		pac.setEfMmss("Membros Superiores");
		pac.setEfPescoco("Pesco�o");
		*/
		
		
		/*
		 if(sexo.equals("F")) {
	            if(imc <= 19.1) {
	                System.out.println(" e est� abaixo do peso");
	            }else if(imc > 19.1 && imc <= 25.8) {
	                System.out.println(" e est� no seu peso ideal");
	            }else if(imc > 25.8 && imc <= 27.3 ) {
	                System.out.println(" e est� marginalmente acima do peso");
	            }else if(imc > 27.3 && imc <= 32.3) {
	                System.out.println(" e est� acima do peso ideal");
	            }else {
	                System.out.println(" e est� obesa");
	            }            
	        }else if (sexo.equals("M")){
	            if(imc <= 20.7) {
	                System.out.println(" e est� abaixo do peso");
	            }else if(imc > 20.7 && imc <= 26.4) {
	                System.out.println(" e est� no seu peso ideal");
	            }else if(imc > 26.4 && imc <= 27.8 ) {
	                System.out.println(" e est� marginalmente acima do peso");
	            }else if(imc > 27.8 && imc <= 31.1) {
	                System.out.println(" e est� acima do peso ideal");
	            }else {
	                System.out.println(" e est� obeso");
	            }    
	        }
			
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		pac.setEmail("123@123.com");
		pac.setIdade(25);
		pac.setNome("Fulano da Silva");
	}
	
}
