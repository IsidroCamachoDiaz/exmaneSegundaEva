package csi21_icamiaz.dtos;

import java.util.Date;
import java.util.List;

import csi21_icamiaz.daos.vajilla;

public class reservaDTO {
	public int idReserva;
	
	public Date fchReserva;
	
	public List <vajilla> vajillas;
	

	public reservaDTO(int idReserva, Date fchReserva, List<vajilla> vajillas) {
		super();
		this.idReserva = idReserva;
		this.fchReserva = fchReserva;
		this.vajillas = vajillas;
		
	}

	public reservaDTO(Date fchReserva) {
		super();
		this.fchReserva = fchReserva;
	}
	
	
}
