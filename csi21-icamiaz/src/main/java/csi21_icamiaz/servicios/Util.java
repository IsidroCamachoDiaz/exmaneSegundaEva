package csi21_icamiaz.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import csi21_icamiaz.daos.reserva;
import csi21_icamiaz.daos.vajilla;
import csi21_icamiaz.dtos.reservaDTO;
import csi21_icamiaz.dtos.vajillaDTO;

public class Util {
	
	public static int CapturaEntero(int min,int max,String texto) {
		int num=min-1;
		Scanner leer= new Scanner(System.in);
		do {
			try {
			System.out.println(texto);
			num=leer.nextInt();
			if(num<min||num>max)
				System.out.println("El numero indicado esta fuera de los parametros");
			}catch(Exception e) {
				System.out.println("No introdujo un valor correcto");
				num=999;
			}
			
		}while(num<min||num>max);
		return num;
	}
	
	public static List <reservaDTO> pasarDaoDtoReserva(List <reserva> res){
		List <reservaDTO> reservas= new ArrayList <reservaDTO>();
		for(int i=0;i<res.size();i++) {
			reservas.add(new reservaDTO(res.get(i).getIdReserva(),res.get(i).getFchReserva(),res.get(i).getVajillas()));
		}
		return reservas;
	}
	
	public static List <vajillaDTO> pasarDaoDtoVajilla(List <vajilla> res){
		List <vajillaDTO> vajillas= new ArrayList <vajillaDTO>();
		for(int i=0;i<res.size();i++) {
			vajillas.add(new vajillaDTO(res.get(i).getIdElemento(),
					res.get(i).getCodigoElemento(),
					res.get(i).getNombreElemento(),
					res.get(i).getReservas(),res.get(i).getDescripcionElemento(),res.get(i).getCantidad()));
		}
		return vajillas;
	}

	public static List <vajilla> pasarDtoDaoVajilla(List <vajillaDTO> res){
		List <vajilla> vajillas= new ArrayList <vajilla>();
		for(int i=0;i<res.size();i++) {
			vajillas.add(new vajilla(res.get(i).getIdElemento(),res.get(i).nombreElemento,res.get(i).descripcion,res.get(i).cantidad,res.get(i).getCodigoElemento()));
		}
		return vajillas;
	}
	
	public static List <reserva> pasarDtoDaoReserva(List <reservaDTO> res){
		List <reserva> reservas= new ArrayList <reserva>();
		for(int i=0;i<res.size();i++) {
			reservas.add(new reserva(res.get(i).fchReserva,res.get(i).vajillas));
		}
		return reservas;
	}
}
