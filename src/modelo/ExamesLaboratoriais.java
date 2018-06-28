package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ExamesLaboratoriais {

	@Id @GeneratedValue
	private Long id;
	
	private Double hematocrito;
	private Double hemoglobina;
	private Double eritrocitos;
	private Double linfocitos;
	private Double leucotitos;
	private Double plaquetas;
	private Double proteinasTotais;
	private Double albumina;
	private Double ferritina;
	private Double leptina;
	private Double transferrina;
	private Double proteinaReativa;
	private Double glicemia;
	private Double hemoglobinaGlicada;
	private Double colesterolTotal;
	private Double hdl;
	private Double vldl;
	private Double ldl;
	private Double triglicerideos;
	private Double calcio;
	private Double cloro;
	private Double cobre;
	private Double fosforo;
	private Double ferro;
	private Double magnesio;
	private Double manganes;
	private Double potassio;
	
	private Double selenio;
	private Double sodio;
	private Double zinco;
	private Double tgo;
	private Double tgp;
	private Double fosfataseAlcalina;
	private Double AtivProtrombina;
	private Double ureia;
	private Double creatinina;
	private Double acidoUrico;
	private Double t3;
	private Double t4; 
	private Double homocisteina;
	private Double insulina;
	private Double clearanceCreatinina;
	private Double testosteronaTotal;
	private Double testosteronaLivre;
	private Double testosteronaDisponivel;
	private Double prolactina;
	private Double estradiol;
	private Double fsh;
	private Double lipoproteina;  
	private Double cortisol;
	private Double bilirrubinaTotal;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getHematocrito() {
		return hematocrito;
	}
	public void setHematocrito(Double hematocrito) {
		this.hematocrito = hematocrito;
	}
	public Double getHemoglobina() {
		return hemoglobina;
	}
	public void setHemoglobina(Double hemoglobina) {
		this.hemoglobina = hemoglobina;
	}
	public Double getEritrocitos() {
		return eritrocitos;
	}
	public void setEritrocitos(Double eritrocitos) {
		this.eritrocitos = eritrocitos;
	}
	public Double getLinfocitos() {
		return linfocitos;
	}
	public void setLinfocitos(Double linfocitos) {
		this.linfocitos = linfocitos;
	}
	public Double getLeucotitos() {
		return leucotitos;
	}
	public void setLeucotitos(Double leucotitos) {
		this.leucotitos = leucotitos;
	}
	public Double getPlaquetas() {
		return plaquetas;
	}
	public void setPlaquetas(Double plaquetas) {
		this.plaquetas = plaquetas;
	}
	public Double getProteinasTotais() {
		return proteinasTotais;
	}
	public void setProteinasTotais(Double proteinasTotais) {
		this.proteinasTotais = proteinasTotais;
	}
	public Double getAlbumina() {
		return albumina;
	}
	public void setAlbumina(Double albumina) {
		this.albumina = albumina;
	}
	public Double getFerritina() {
		return ferritina;
	}
	public void setFerritina(Double ferritina) {
		this.ferritina = ferritina;
	}
	public Double getLeptina() {
		return leptina;
	}
	public void setLeptina(Double leptina) {
		this.leptina = leptina;
	}
	public Double getTransferrina() {
		return transferrina;
	}
	public void setTransferrina(Double transferrina) {
		this.transferrina = transferrina;
	}
	public Double getProteinaReativa() {
		return proteinaReativa;
	}
	public void setProteinaReativa(Double proteinaReativa) {
		this.proteinaReativa = proteinaReativa;
	}
	public Double getGlicemia() {
		return glicemia;
	}
	public void setGlicemia(Double glicemia) {
		this.glicemia = glicemia;
	}
	public Double getHemoglobinaGlicada() {
		return hemoglobinaGlicada;
	}
	public void setHemoglobinaGlicada(Double hemoglobinaGlicada) {
		this.hemoglobinaGlicada = hemoglobinaGlicada;
	}
	public Double getColesterolTotal() {
		return colesterolTotal;
	}
	public void setColesterolTotal(Double colesterolTotal) {
		this.colesterolTotal = colesterolTotal;
	}
	public Double getHdl() {
		return hdl;
	}
	public void setHdl(Double hdl) {
		this.hdl = hdl;
	}
	public Double getVldl() {
		return vldl;
	}
	public void setVldl(Double vldl) {
		this.vldl = vldl;
	}
	public Double getLdl() {
		return ldl;
	}
	public void setLdl(Double ldl) {
		this.ldl = ldl;
	}
	
	public Double getTriglicerideos() {
		return triglicerideos;
	}
	public void setTriglicerideos(Double triglicerideos) {
		this.triglicerideos = triglicerideos;
	}
	public Double getCalcio() {
		return calcio;
	}
	public void setCalcio(Double calcio) {
		this.calcio = calcio;
	}
	public Double getCloro() {
		return cloro;
	}
	public void setCloro(Double cloro) {
		this.cloro = cloro;
	}
	public Double getCobre() {
		return cobre;
	}
	public void setCobre(Double cobre) {
		this.cobre = cobre;
	}
	public Double getFosforo() {
		return fosforo;
	}
	public void setFosforo(Double fosforo) {
		this.fosforo = fosforo;
	}
	public Double getFerro() {
		return ferro;
	}
	public void setFerro(Double ferro) {
		this.ferro = ferro;
	}
	public Double getMagnesio() {
		return magnesio;
	}
	public void setMagnesio(Double magnesio) {
		this.magnesio = magnesio;
	}
	public Double getManganes() {
		return manganes;
	}
	public void setManganes(Double manganes) {
		this.manganes = manganes;
	}
	public Double getPotassio() {
		return potassio;
	}
	public void setPotassio(Double potassio) {
		this.potassio = potassio;
	}
	public Double getSelenio() {
		return selenio;
	}
	public void setSelenio(Double selenio) {
		this.selenio = selenio;
	}
	public Double getSodio() {
		return sodio;
	}
	public void setSodio(Double sodio) {
		this.sodio = sodio;
	}
	public Double getZinco() {
		return zinco;
	}
	public void setZinco(Double zinco) {
		this.zinco = zinco;
	}
	public Double getTgo() {
		return tgo;
	}
	public void setTgo(Double tgo) {
		this.tgo = tgo;
	}
	public Double getTgp() {
		return tgp;
	}
	public void setTgp(Double tgp) {
		this.tgp = tgp;
	}
	public Double getFosfataseAlcalina() {
		return fosfataseAlcalina;
	}
	public void setFosfataseAlcalina(Double fosfataseAlcalina) {
		this.fosfataseAlcalina = fosfataseAlcalina;
	}
	public Double getAtivProtrombina() {
		return AtivProtrombina;
	}
	public void setAtivProtrombina(Double ativProtrombina) {
		AtivProtrombina = ativProtrombina;
	}
	public Double getUreia() {
		return ureia;
	}
	public void setUreia(Double ureia) {
		this.ureia = ureia;
	}
	public Double getCreatinina() {
		return creatinina;
	}
	public void setCreatinina(Double creatinina) {
		this.creatinina = creatinina;
	}
	public Double getAcidoUrico() {
		return acidoUrico;
	}
	public void setAcidoUrico(Double acidoUrico) {
		this.acidoUrico = acidoUrico;
	}
	public Double getT3() {
		return t3;
	}
	public void setT3(Double t3) {
		this.t3 = t3;
	}
	public Double getT4() {
		return t4;
	}
	public void setT4(Double t4) {
		this.t4 = t4;
	}
	public Double getHomocisteina() {
		return homocisteina;
	}
	public void setHomocisteina(Double homocisteina) {
		this.homocisteina = homocisteina;
	}
	public Double getInsulina() {
		return insulina;
	}
	public void setInsulina(Double insulina) {
		this.insulina = insulina;
	}
	public Double getClearanceCreatinina() {
		return clearanceCreatinina;
	}
	public void setClearanceCreatinina(Double clearanceCreatinina) {
		this.clearanceCreatinina = clearanceCreatinina;
	}
	public Double getTestosteronaTotal() {
		return testosteronaTotal;
	}
	public void setTestosteronaTotal(Double testosteronaTotal) {
		this.testosteronaTotal = testosteronaTotal;
	}
	public Double getTestosteronaLivre() {
		return testosteronaLivre;
	}
	public void setTestosteronaLivre(Double testosteronaLivre) {
		this.testosteronaLivre = testosteronaLivre;
	}
	public Double getTestosteronaDisponivel() {
		return testosteronaDisponivel;
	}
	public void setTestosteronaDisponivel(Double testosteronaDisponivel) {
		this.testosteronaDisponivel = testosteronaDisponivel;
	}
	public Double getProlactina() {
		return prolactina;
	}
	public void setProlactina(Double prolactina) {
		this.prolactina = prolactina;
	}
	public Double getEstradiol() {
		return estradiol;
	}
	public void setEstradiol(Double estradiol) {
		this.estradiol = estradiol;
	}
	public Double getFsh() {
		return fsh;
	}
	public void setFsh(Double fsh) {
		this.fsh = fsh;
	}
	public Double getLipoproteina() {
		return lipoproteina;
	}
	public void setLipoproteina(Double lipoproteina) {
		this.lipoproteina = lipoproteina;
	}
	public Double getCortisol() {
		return cortisol;
	}
	public void setCortisol(Double cortisol) {
		this.cortisol = cortisol;
	}
	public Double getBilirrubinaTotal() {
		return bilirrubinaTotal;
	}
	public void setBilirrubinaTotal(Double bilirrubinaTotal) {
		this.bilirrubinaTotal = bilirrubinaTotal;
	}
	
	
	
	
	
	
	
	
}
