package es.uvigo.mei.entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class TipoContribucion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tipoContribucionId;
	
	@ManyToOne
	private Campanha campanha;
	
	@OneToOne
	@JoinColumn(name = "FK_FINANCIACION", updatable = false, nullable = false)
	private Financiacion financiacion;
	
	@Enumerated(EnumType.STRING)
    private ModoDePago modoDePago;
	
	public TipoContribucion() {}

	

	public TipoContribucion(Long tipoContribucionId, Campanha campanha, Financiacion financiacion,
			ModoDePago modoDePago) {
		super();
		this.tipoContribucionId = tipoContribucionId;
		this.campanha = campanha;
		this.financiacion = financiacion;
		this.modoDePago = modoDePago;
	}



	public TipoContribucion(Campanha campanha, Financiacion financiacion, ModoDePago modoDePago) {
		super();
		this.campanha = campanha;
		this.financiacion = financiacion;
		this.modoDePago = modoDePago;
	}



	public Financiacion getFinanciacion() {
		return financiacion;
	}



	public void setFinanciacion(Financiacion financiacion) {
		this.financiacion = financiacion;
	}



	public Long getTipoContribucionId() {
		return tipoContribucionId;
	}

	public void setTipoContribucionId(Long tipoContribucionId) {
		this.tipoContribucionId = tipoContribucionId;
	}

	public Campanha getCampanha() {
		return campanha;
	}

	public void setCampanha(Campanha nuevaCampanha) {
		
		if(this.campanha != null) {
			this.campanha.eliminarTipoContribucionInterno(this);
		}
		this.campanha = nuevaCampanha;
		if(nuevaCampanha != null) {
			nuevaCampanha.anhadirTipoContribucionInterno(this);
		}
	}

	public ModoDePago getModoDePago() {
		return modoDePago;
	}

	public void setModoDePago(ModoDePago modoDePago) {
		this.modoDePago = modoDePago;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campanha == null) ? 0 : campanha.hashCode());
		result = prime * result + ((financiacion == null) ? 0 : financiacion.hashCode());
		result = prime * result + ((modoDePago == null) ? 0 : modoDePago.hashCode());
		result = prime * result + ((tipoContribucionId == null) ? 0 : tipoContribucionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoContribucion other = (TipoContribucion) obj;
		if (campanha == null) {
			if (other.campanha != null)
				return false;
		} else if (!campanha.equals(other.campanha))
			return false;
		if (financiacion == null) {
			if (other.financiacion != null)
				return false;
		} else if (!financiacion.equals(other.financiacion))
			return false;
		if (modoDePago != other.modoDePago)
			return false;
		if (tipoContribucionId == null) {
			if (other.tipoContribucionId != null)
				return false;
		} else if (!tipoContribucionId.equals(other.tipoContribucionId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoContribucion [tipoContribucionId=" + tipoContribucionId + ", campanha=" + campanha
				+ ", financiacion=" + financiacion.toString() + ", modoDePago=" + modoDePago + "]";
	}
	
	
}
