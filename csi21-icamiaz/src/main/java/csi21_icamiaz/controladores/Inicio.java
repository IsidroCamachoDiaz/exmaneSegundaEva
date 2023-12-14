package csi21_icamiaz.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import csi21_icamiaz.servicios.*;

import csi21_icamiaz.daos.reserva;
import csi21_icamiaz.daos.vajilla;
import csi21_icamiaz.dtos.reservaDTO;
import csi21_icamiaz.dtos.vajillaDTO;
import csi21_icamiaz.servicios.Acciones;
import csi21_icamiaz.servicios.Util;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Inicio {

	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("default");
		EntityManager em = emf.createEntityManager();
		int opcion=3;
		Scanner leer= new Scanner(System.in);
		Acciones acc = new Acciones();
		List <reservaDTO> res= new ArrayList <reservaDTO>();
		List <vajillaDTO> vas= new ArrayList <vajillaDTO>();
		List <reserva> resD = new ArrayList <reserva>();
		List <vajilla> vasD = new ArrayList <vajilla>();
		
		inter it= new imple();

		//--------------------------------------------------------
		do {
			try {
			System.out.println("1-Dar de alta");
			System.out.println("2-Dar de baja");
			System.out.println("3-Eliminar stock");
			System.out.println("4-Mostrar stock");
			System.out.println("5-Crear reserva");
			System.out.println("0-Salir");
			opcion=Util.CapturaEntero(0, 5, "Introduzca Una opcion: ");
			switch(opcion) {
			case 1:
				it.meterVajilla(vas, vasD, em);
				break;
			case 2:
				it.eliminarVajilla(vas, vasD, res, resD, em);
				System.out.println("Se elimino la vajilla");
				break;
			case 3:
				it.eliminarStock(vas, vasD, em);
				System.out.println("Se elimino stock");
				break;
			case 4:
				it.MostrarStock(vas, vasD, em);
				break;
			case 5:
				System.out.println("Crear reserva");
				break;
			}
			}catch(Exception e) {
				System.out.println("Hubo un error en el main"+e.getLocalizedMessage());
				opcion=8;
			}
			
		}while(opcion!=0);

		//--------------------------------------------------------
		em.close();

	}

}
