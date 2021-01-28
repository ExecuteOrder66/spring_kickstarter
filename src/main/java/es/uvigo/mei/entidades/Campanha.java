package es.uvigo.mei.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Campanha {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campanhaId;
	@ManyToOne
    private Usuario creador;
	private String nombreCampanha;
	@Temporal(TemporalType.DATE)
    private Date fechaInicio;
	@Temporal(TemporalType.DATE)
    private Date fechaFin;
	private Long meta;
	
	@OneToMany(mappedBy = "campanha", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("contribucionId asc")
    private List<TipoContribucion> tipoContribuciones = new ArrayList<>();
	
	@OneToMany(mappedBy = "campanha", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("comentarioId asc")
    private List<Comentario> comentarios = new ArrayList<>();
	
	public Campanha() {}


	public Campanha(Usuario creador, String nombreCampanha, Date fechaInicio, Date fechaFin, Long meta) {
		super();
		this.creador = creador;
		this.nombreCampanha = nombreCampanha;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.meta = meta;
	}


	public Campanha(Usuario creador, String nombreCampanha, Date fechaInicio, Date fechaFin, Long meta,
			List<TipoContribucion> tipoContribuciones, List<Comentario> comentarios) {
		super();
		this.creador = creador;
		this.nombreCampanha = nombreCampanha;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.meta = meta;
		this.tipoContribuciones = tipoContribuciones;
		this.comentarios = comentarios;
	}


	public Campanha(Long campanhaId, Usuario creador, String nombreCampanha, Date fechaInicio, Date fechaFin, Long meta,
			List<TipoContribucion> tipoContribuciones, List<Comentario> comentarios) {
		super();
		this.campanhaId = campanhaId;
		this.creador = creador;
		this.nombreCampanha = nombreCampanha;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.meta = meta;
		this.tipoContribuciones = tipoContribuciones;
		this.comentarios = comentarios;
	}




	public String getNombreCampanha() {
		return nombreCampanha;
	}


	public void setNombreCampanha(String nombreCampanha) {
		this.nombreCampanha = nombreCampanha;
	}


	public Long getCampanhaId() {
		return campanhaId;
	}

	public void setCampanhaId(Long campanhaId) {
		this.campanhaId = campanhaId;
	}

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Long getMeta() {
		return meta;
	}

	public void setMeta(Long meta) {
		this.meta = meta;
	}


	public void anhadirComentario(Comentario nuevoComentario) {
		nuevoComentario.setCampanha(this);
    }

    // Acceso relaciones bidireccionales
    // https://xebia.com/blog/jpa-implementation-patterns-bidirectional-assocations/
    protected void anhadirComentarioInterno(Comentario nuevoComentario) {
        if (comentarios == null) {
            this.comentarios = new ArrayList<>();
        }
        if (!this.comentarios.contains(nuevoComentario)) {
            this.comentarios.add(nuevoComentario);
        }
    }
    
    public void eliminarComentario(Comentario comentario) {
    	comentario.setCampanha(null);
    }

    protected void eliminarComentarioInterno(Comentario comentario) {
        if (comentarios != null) {
            this.comentarios.remove(comentario);
        }
    }

    public void anhadirTipoContribucion(TipoContribucion nuevoTipoContribucion) {
    	nuevoTipoContribucion.setCampanha(this);
    }

    // Acceso relaciones bidireccionales
    // https://xebia.com/blog/jpa-implementation-patterns-bidirectional-assocations/
    protected void anhadirTipoContribucionInterno(TipoContribucion nuevoTipoContribucion) {
        if (tipoContribuciones == null) {
            this.tipoContribuciones = new ArrayList<>();
        }
        if (!this.tipoContribuciones.contains(nuevoTipoContribucion)) {
            this.tipoContribuciones.add(nuevoTipoContribucion);
        }
    }

    public void eliminarTipoContribucion(TipoContribucion tipoContribucion) {
    	tipoContribucion.setCampanha(null);
    }

    protected void eliminarTipoContribucionInterno(TipoContribucion tipoContribucion) {
        if (tipoContribuciones != null) {
            this.tipoContribuciones.remove(tipoContribucion);
        }
    }
    
	public List<TipoContribucion> getTipoContribuciones() {
		return tipoContribuciones;
	}


	public void setTipoContribuciones(List<TipoContribucion> tipoContribuciones) {
		this.tipoContribuciones = tipoContribuciones;
	}


	public List<Comentario> getComentarios() {
		return comentarios;
	}


	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campanhaId == null) ? 0 : campanhaId.hashCode());
		result = prime * result + ((comentarios == null) ? 0 : comentarios.hashCode());
		result = prime * result + ((creador == null) ? 0 : creador.hashCode());
		result = prime * result + ((fechaFin == null) ? 0 : fechaFin.hashCode());
		result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result + ((meta == null) ? 0 : meta.hashCode());
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
		Campanha other = (Campanha) obj;
		if (campanhaId == null) {
			if (other.campanhaId != null)
				return false;
		} else if (!campanhaId.equals(other.campanhaId))
			return false;
		if (comentarios == null) {
			if (other.comentarios != null)
				return false;
		} else if (!comentarios.equals(other.comentarios))
			return false;
		if (creador == null) {
			if (other.creador != null)
				return false;
		} else if (!creador.equals(other.creador))
			return false;
		if (fechaFin == null) {
			if (other.fechaFin != null)
				return false;
		} else if (!fechaFin.equals(other.fechaFin))
			return false;
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
			return false;
		if (meta == null) {
			if (other.meta != null)
				return false;
		} else if (!meta.equals(other.meta))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Campanha [campanhaId=" + campanhaId + ", creador=" + creador + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", meta=" + meta + ", comentarios=" + comentarios + "]";
	}
	
    
}
