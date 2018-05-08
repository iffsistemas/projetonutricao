package modelo;

public enum MotivoAtendimento {
	EMAGRECIMENTO("Emagrecimento"),    
	MANTERPESO("Manter o peso"),
	REEDUCACAOALIMENTAR("Reeduca��o Alimentar"),
	CONTROLARHIPERTENSAO("Controlar a hipertens�o"),  
	CONTROLARCOLESTEROL("Controlar o colesterol"),
	CONTROLARGLICEMIA("Controlar a glicemia/glicose sangu�nea"),
	GANHARPESO("Ganhar peso"),  
	EXERCICIOFISICO("Nutri��o adequada ao exerc�cio f�sico"),
	CONTROLEINTESTINO("Controle do Intestino preso"),
	CONTROLESINDROME("Controle da S�ndrome do Intestino Irrit�vel"), 
	CONTROLETRANSTORNOS("Controle de outros transtornos do intestino"),
	CONTROLEGASTRITE("Controle da Gastrite/�lcera"),  
	CONTROLEACIDOURICO("Controle do �cido �rico"), 
	PREVENCAOCALCULO("Preven��o e/ou controle do c�lculo renal"), 
	CONTROLEREFLUXO("Controle do Refluxo gastro-esof�gico"),  
	CONTROLETPM("Controle da TPM"),
	CONTROLEENXAQUECA("Controle da Enxaqueca"),  
	ACOMPANHAMENTOGESTA��O("Acompanhamento da Gesta��o"),
	PREVEN��OANEMIA("Preven��o e/ou recupera��o da anemia"),  
	CONTROLEOSTEOPOROSE("Controle da Osteoporose"),
	CIRURGIASONCOLOGICAS("Pr� ou p�s cirurgias oncol�gicas"), 
	NUTRICAOOESTETICA("Nutri��o est�tica � controle da celulite, acne, flacidez"),
	INTOLER�NCIALACTOSE("Intoler�ncia � lactose"),  
	DOEN�ACELIACA("Alimenta��o para doen�a cel�aca"),
	NOREXIA("Anorexia/bulimia nervosa"),  
	HIPOTIREOIDISMO("Hipotireoidismo"),
	DOENCASCARDIOVASCULARES("Preven��o ou Controle de Doen�as cardiovasculares");

    
	public String descricao;
    
	MotivoAtendimento(String valor) {
        descricao = valor;
    }

	public String getDescricao() {
		return descricao;
	}	
	
	

}
