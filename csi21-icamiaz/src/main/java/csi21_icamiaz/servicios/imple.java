package csi21_icamiaz.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import csi21_icamiaz.daos.reserva;
import csi21_icamiaz.daos.vajilla;
import csi21_icamiaz.dtos.reservaDTO;
import csi21_icamiaz.dtos.vajillaDTO;
import jakarta.persistence.EntityManager;

public class imple implements inter {

	@Override
	public void meterVajilla(List<vajillaDTO> vas, List<vajilla> vasD,EntityManager em) {
		Scanner leer = new Scanner(System.in);
		Acciones acc = new Acciones();
		System.out.println("Dar de alta");
		System.out.println("Introduzca un Nombre de la vajilla:");
		String nombre=leer.next();
		System.out.println("Introduzca una Descripcion de la vajilla:");
		String des=leer.next();
		int cantidad = Util.CapturaEntero(1, 9999, "Introduzca una cantidad de la vajilla:");
		if(nombre.equals(""));
			nombre="aaaaaaaaa";
		if(des.equals("")||des.length()<3)
			des="aaaaaaaaa";
		if(cantidad!=999) {
		vajillaDTO u1 = new vajillaDTO(nombre,des,cantidad);
		u1.setCodigoElemento(des.substring(3)+"-"+nombre);
		vas.add(u1);
		vasD=Util.pasarDtoDaoVajilla(vas);
		acc.insertarEntidad(em, vasD.get(0));
		System.out.println("Se hizo correctamente");
		}
		else
			System.out.println("No se creo");

	}

	@Override
	public void eliminarVajilla(List<vajillaDTO> vas, List<vajilla> vasD, List<reservaDTO> res, List<reserva> resD,EntityManager em) {
		Scanner leer = new Scanner(System.in);
		Acciones acc = new Acciones();
		System.out.println("Dar de baja");
		vasD=acc.ListarVajillas(em, "SELECT v FROM vajilla v");
		vas=Util.pasarDaoDtoVajilla(vasD);
		if(vas.isEmpty())
			System.out.print("No hay ninguna vajilla registrada");
		else {
			for(int i=0;i<vas.size();i++) {
				String texto="Opcion: "+i+" "+vas.get(i).nombreElemento+" "+vas.get(i).descripcion;
				System.out.println(texto);
			}
			int indexBaja=Util.CapturaEntero(0,vas.size()-1, "Introduzca la Baja que quiere dar");	
			int idBorrar=vas.get(indexBaja).idElemento;
			List <reserva> resBorrar=new ArrayList<reserva>();
			for(int i=0;i<vasD.size();i++) {
				if(idBorrar==vasD.get(i).getIdElemento()) {
					acc.eliminarEntidad(em, vasD.get(indexBaja));
					resD=acc.ListarReserva(em, "SELECT r FROM reserva r");
					for(int e=0;i<resD.size();e++) {
						for(int o=0;o<resD.get(e).getVajillas().size();o++) {
							if(resD.get(e).getVajillas().get(o).getIdElemento()==idBorrar) {
								resBorrar.add(resD.get(e));
							}
						}
					}
					
					for(int u=0;u<resBorrar.size();u++) {
						acc.eliminarEntidad(em, resBorrar.get(u));
					}
				}
			}
		}

	}

	@Override
	public void eliminarStock(List<vajillaDTO> vas, List<vajilla> vasD, EntityManager em) {
		// TODO Auto-generated method stub
		
	}

}
