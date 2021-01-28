package es.uvigo.mei.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comentario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long comentarioId;
	@ManyToOne
	private Campanha campanha;
	@ManyToOne
	private Usuario autor;
	private String mensaje;
	
	public Comentario() {}

	public Comentario(Long comentarioId, Campanha campanha, Usuario autor, String mensaje) {
		super();
		this.comentarioId = comentarioId;
		this.campanha = campanha;
		this.autor = autor;
		this.mensaje = mensaje;
	}

	public Comentario(Campanha campanha, Usuario autor, String mensaje) {
		super();
		this.campanha = campanha;
		this.autor = autor;
		this.mensaje = mensaje;
	}

	public Long getComentarioId() {
		return comentarioId;
	}

	public void setComentarioId(Long comentarioId) {
		this.comentarioId = comentarioId;
	}

	public Campanha getCampanha() {
		return campanha;
	}

	public void setCampanha(Campanha nuevaCampanha) {
		
		if(this.campanha != null) {
			this.campanha.eliminarComentarioInterno(this);
		}
		this.campanha = nuevaCampanha;
		if(nuevaCampanha != null) {
			nuevaCampanha.anhadirComentarioInterno(this);
		}
	}


	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((campanha == null) ? 0 : campanha.hashCode());
		result = prime * result + ((comentarioId == null) ? 0 : comentarioId.hashCode());
		result = prime * result + ((mensaje == null) ? 0 : mensaje.hashCode());
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
		Comentario other = (Comentario) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (campanha == null) {
			if (other.campanha != null)
				return false;
		} else if (!campanha.equals(other.campanha))
			return false;
		if (comentarioId == null) {
			if (other.comentarioId != null)
				return false;
		} else if (!comentarioId.equals(other.comentarioId))
			return false;
		if (mensaje == null) {
			if (other.mensaje != null)
				return false;
		} else if (!mensaje.equals(other.mensaje))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comentario [comentarioId=" + comentarioId + ", campanha=" + campanha + ", autor=" + autor + ", mensaje="
				+ mensaje + "]";
	}
	
	
}
