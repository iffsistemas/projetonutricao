package tools;

public enum MotivoAtendimento {
	EMAGRECIMENTO("Emagrecimento"),
	REDALIMENTAR("Reeduca��o Alimentar"),
	CONTROLCOLESTEROL("Controlar o colesterol");

    
	public String descricao;
    
	MotivoAtendimento(String valor) {
        descricao = valor;
    }

	public String getDescricao() {
		return descricao;
	}	
	
	

}
