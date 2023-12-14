package csi21_icamiaz.servicios;

import java.util.List;

import csi21_icamiaz.daos.reserva;
import csi21_icamiaz.daos.vajilla;
import csi21_icamiaz.dtos.reservaDTO;
import csi21_icamiaz.dtos.vajillaDTO;
import jakarta.persistence.EntityManager;

public interface inter {
	public void meterVajilla(List <vajillaDTO> vas,List <vajilla> vasD,EntityManager em);
	public void eliminarVajilla(List <vajillaDTO> vas,List <vajilla> vasD,List <reservaDTO> res,List <reserva> resD,EntityManager em);
	public void eliminarStock(List <vajillaDTO> vas,List <vajilla> vasD,EntityManager em);
}
