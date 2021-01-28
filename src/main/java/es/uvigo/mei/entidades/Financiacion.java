package es.uvigo.mei.entidades;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Financiacion {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long financiacionId;
	
	@OneToOne(mappedBy = "financiacion", cascade  = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private TipoContribucion tipoContribucion;
	
	@ManyToOne
	private Usuario remitente;
	
	private double cantidad;
	@Temporal(TemporalType.DATE)
    private Date fechaMovimiento;
	
	public Financiacion() {}

	
	public Financiacion(Long financiacionId, TipoContribucion tipoContribucion, double cantidad, Date fechaMovimiento) {
		super();
		this.financiacionId = financiacionId;
		this.tipoContribucion = tipoContribucion;
		this.cantidad = cantidad;
		this.fechaMovimiento = fechaMovimiento;
	}


	public Financiacion(Usuario remitente, double cantidad, Date fechaMovimiento) {
		super();
		this.remitente = remitente;
		this.cantidad = cantidad;
		this.fechaMovimiento = fechaMovimiento;
	}


	public Long getFinanciacionId() {
		return financiacionId;
	}

	public void setFinanciacionId(Long financiacionId) {
		this.financiacionId = financiacionId;
	}

	public TipoContribucion getTipoContribucion() {
		return tipoContribucion;
	}

	public void setTipoContribucion(TipoContribucion tipoContribucion) {
		this.tipoContribucion = tipoContribucion;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cantidad);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((fechaMovimiento == null) ? 0 : fechaMovimiento.hashCode());
		result = prime * result + ((financiacionId == null) ? 0 : financiacionId.hashCode());
		result = prime * result + ((tipoContribucion == null) ? 0 : tipoContribucion.hashCode());
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
		Financiacion other = (Financiacion) obj;
		if (Double.doubleToLongBits(cantidad) != Double.doubleToLongBits(other.cantidad))
			return false;
		if (fechaMovimiento == null) {
			if (other.fechaMovimiento != null)
				return false;
		} else if (!fechaMovimiento.equals(other.fechaMovimiento))
			return false;
		if (financiacionId == null) {
			if (other.financiacionId != null)
				return false;
		} else if (!financiacionId.equals(other.financiacionId))
			return false;
		if (tipoContribucion == null) {
			if (other.tipoContribucion != null)
				return false;
		} else if (!tipoContribucion.equals(other.tipoContribucion))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Financiacion [financiacionId=" + financiacionId + ", tipoContribucion=" + tipoContribucion
				+ ", cantidad=" + cantidad + ", fechaMovimiento=" + fechaMovimiento + "]";
	}
	
	
}
