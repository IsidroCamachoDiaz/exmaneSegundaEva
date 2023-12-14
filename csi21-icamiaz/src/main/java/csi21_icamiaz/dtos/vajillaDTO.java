package csi21_icamiaz.dtos;

import java.util.List;

import csi21_icamiaz.daos.reserva;

public class vajillaDTO {
	public int idElemento;
	
	public String codigoElemento;
	
	public String nombreElemento;
	
	public String descripcion;
	
	public int cantidad;

	public List <reserva> reservas;

	public vajillaDTO(int idElemento, String codigoElemento, String nombreElemento, List<reserva> reservas,String des,int c) {
		super();
		this.idElemento = idElemento;
		this.codigoElemento = codigoElemento;
		this.nombreElemento = nombreElemento;
		this.reservas = reservas;
		this.descripcion=des;
		this.cantidad=c;
	}

	public vajillaDTO(String nombreElemento,String des,int c) {
		super();
		this.nombreElemento = nombreElemento;
		this.descripcion=des;
		this.cantidad=c;
	}

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
		return reservas;
	}

	public void setReservas(List<reserva> reservas) {
		this.reservas = reservas;
	}
	
	
	
	
}
