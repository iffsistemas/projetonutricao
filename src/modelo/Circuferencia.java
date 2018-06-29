package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Circuferencia {
	
	
		@Id @GeneratedValue
		private Long id;
		private Double cc;
	    private Double cq;
	    private Double cb;
	    private Double cabd;
	    
	    
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Double getCc() {
			return cc;
		}
		public void setCc(Double cc) {
			this.cc = cc;
		}
		public Double getCq() {
			return cq;
		}
		public void setCq(Double cq) {
			this.cq = cq;
		}
		public Double getCb() {
			return cb;
		}
		public void setCb(Double cb) {
			this.cb = cb;
		}
		public Double getCabd() {
			return cabd;
		}
		public void setCabd(Double cabd) {
			this.cabd = cabd;
		}
	    
	    
	    
	    

}
