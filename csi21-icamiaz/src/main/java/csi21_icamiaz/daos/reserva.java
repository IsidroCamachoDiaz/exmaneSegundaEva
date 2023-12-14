package csi21_icamiaz.daos;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="reservas",schema="esqexados")
public class reserva {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reserva",nullable=false)
	private int idReserva;
	
	@Column(name="fch_reserva")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fchReserva;
	
	@ManyToMany(mappedBy="reservas1")
	private List <vajilla> vajillas;
	
	//Contructores
	public reserva() {
		super();
	}

	public reserva(Date fchReserva, List<vajilla> vajillas) {
		super();
		this.fchReserva = fchReserva;
		this.vajillas = vajillas;
	}
	
	public reserva(int idReserva, Date fchReserva, List<vajilla> vajillas) {
		super();
		this.idReserva = idReserva;
		this.fchReserva = fchReserva;
		this.vajillas = vajillas;
	}

	//Geters y Serters
	public int getIdReserva() {
		return idReserva;
	}

	

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Date getFchReserva() {
		return fchReserva;
	}

	public void setFchReserva(Date fchReserva) {
		this.fchReserva = fchReserva;
	}

	public List<vajilla> getVajillas() {
		return vajillas;
	}

	public void setVajillas(List<vajilla> vajillas) {
		this.vajillas = vajillas;
	}

	
	
}
