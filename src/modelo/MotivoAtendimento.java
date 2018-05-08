package modelo;

public enum MotivoAtendimento {
	EMAGRECIMENTO("Emagrecimento"),    
	MANTERPESO("Manter o peso"),
	REEDUCACAOALIMENTAR("Reeducação Alimentar"),
	CONTROLARHIPERTENSAO("Controlar a hipertensão"),  
	CONTROLARCOLESTEROL("Controlar o colesterol"),
	CONTROLARGLICEMIA("Controlar a glicemia/glicose sanguínea"),
	GANHARPESO("Ganhar peso"),  
	EXERCICIOFISICO("Nutrição adequada ao exercício físico"),
	CONTROLEINTESTINO("Controle do Intestino preso"),
	CONTROLESINDROME("Controle da Síndrome do Intestino Irritável"), 
	CONTROLETRANSTORNOS("Controle de outros transtornos do intestino"),
	CONTROLEGASTRITE("Controle da Gastrite/Úlcera"),  
	CONTROLEACIDOURICO("Controle do ácido úrico"), 
	PREVENCAOCALCULO("Prevenção e/ou controle do cálculo renal"), 
	CONTROLEREFLUXO("Controle do Refluxo gastro-esofágico"),  
	CONTROLETPM("Controle da TPM"),
	CONTROLEENXAQUECA("Controle da Enxaqueca"),  
	ACOMPANHAMENTOGESTAÇÃO("Acompanhamento da Gestação"),
	PREVENÇÃOANEMIA("Prevenção e/ou recuperação da anemia"),  
	CONTROLEOSTEOPOROSE("Controle da Osteoporose"),
	CIRURGIASONCOLOGICAS("Pré ou pós cirurgias oncológicas"), 
	NUTRICAOOESTETICA("Nutrição estética – controle da celulite, acne, flacidez"),
	INTOLERÂNCIALACTOSE("Intolerância à lactose"),  
	DOENÇACELIACA("Alimentação para doença celíaca"),
	NOREXIA("Anorexia/bulimia nervosa"),  
	HIPOTIREOIDISMO("Hipotireoidismo"),
	DOENCASCARDIOVASCULARES("Prevenção ou Controle de Doenças cardiovasculares");

    
	public String descricao;
    
	MotivoAtendimento(String valor) {
        descricao = valor;
    }

	public String getDescricao() {
		return descricao;
	}	
	
	

}
