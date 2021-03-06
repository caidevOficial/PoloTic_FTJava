/*
 * Copyright (C) 2020 caidev
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package Logica;

/**
 * @author caidev
 */
public class Controladora {
	String[] nombres = new String[5];
	
	/**
	 * Busca en el array un indice vacio.
	 * @param array Array en el que buscara.
	 * @return El indice vacio, sino -1 para error.
	 */
	public int BuscarIndiceLibre(String[] array) {
		int freeIndex = -1;
		for(int i = 0;i<array.length;i++) {
			if(array[i]==null) {
				freeIndex = i;
				break;
			}
		}
		return freeIndex;
	}
	
	/**
	 * Carga en una posicion vacia del array el nombre pasado por parametro.
	 * @param nombre Nombre a cargar en el array.
	 * @return true si pudo cargarlo, sino false.
	 */
	public Boolean CargarArray(String nombre) {
		int freeIndex = BuscarIndiceLibre(nombres);
		if(freeIndex!=(-1)) {
			nombres[freeIndex] = nombre;
			return true;
		}
		return false;
	}
	
	/**
	 * Recorre el array buscando en los indices el nombre pasado por parametro, si encuentra devuelve true, sino false.
	 * @author caidev
	 * @param nombre Nombre a buscar en el array.
	 * @return true si lo encuentra, false si no.
	 */
	public Boolean BuscaryMostrarNombre(String nombre) {
		for(int i = 0;i<nombres.length;i++) {
			if(nombres[i]!=null && nombres[i].equals(nombre)) {
				return true;
			}
		}
		return false;
	}
}
