package csi21_icamiaz.daos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="vajillas",schema="esqexados")
public class vajilla {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_elemento",nullable=false)
	private int idElemento;
	
	@Column(name="codigo_elemento")
	private String codigoElemento;
	@Column(name="nombre_elemento",nullable=false)
	private String nombreElemento;
	@Column(name="descripcion_elemento",nullable=false)
	private String descripcionElemento;
	@Column(name="cantidad_elemento",nullable=false)
	private int cantidad;
	
	@ManyToMany
	private List <reserva> reservas1;

	//constructores
	public vajilla(String nombreElemento, List<reserva> reservas,String des,int c) {
		super();
		this.nombreElemento = nombreElemento;
		this.reservas1 = reservas;
		this.descripcionElemento=des;
		this.cantidad=c;
	}

	public vajilla() {
		super();
	}
	
	public vajilla(String nombreElemento, String descripcionElemento, int cantidad,String codigo) {
		super();
		this.nombreElemento = nombreElemento;
		this.descripcionElemento = descripcionElemento;
		this.cantidad = cantidad;
		this.codigoElemento=codigo;
	}

	public vajilla(int idElemento, String codigoElemento, String nombreElemento, List<reserva> reservas,String des,int c) {
		super();
		this.idElemento = idElemento;
		this.codigoElemento = codigoElemento;
		this.nombreElemento = nombreElemento;
		this.reservas1 = reservas;
		this.descripcionElemento=des;
		this.cantidad=c;
	}

	//Geters y seters
	public int getIdElemento() {
		return idElemento;
	}

	public void setIdElemento(int idElemento) {
		this.idElemento = idElemento;
	}

	public String getCodigoElemento() {
		return codigoElemento;
	}

	public void setCodigoElemento(String codigoElemento) {
		this.codigoElemento = codigoElemento;
	}

	public String getNombreElemento() {
		return nombreElemento;
	}

	public void setNombreElemento(String nombreElemento) {
		this.nombreElemento = nombreElemento;
	}

	public List<reserva> getReservas() {
		return reservas1;
	}

	public void setReservas(List<reserva> reservas) {
		this.reservas1 = reservas;
	}

	public String getDescripcionElemento() {
		return descripcionElemento;
	}

	public void setDescripcionElemento(String descripcionElemento) {
		this.descripcionElemento = descripcionElemento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	
	
	
	
	
}
