/*
 * Copyright (C) 2020 FacuFalcone - CaidevOficial
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

package logic;

/**
 * @author FacuFalcone - CaidevOficial
 *
 */
public class Main {

    public static void EjemploTryCatch1() {
	   try {
		  double resultado = 3/0;
	   }catch (Exception e) {
		  System.out.println("No se puede dividir por 0!");
	   }
    }
    
    public static void EjemploTryCatch2() {
	   try {
		  int edad[] = {3,6,12,25};
		  System.out.println(edad[4]);
	   }catch (Exception e) {
		  System.out.println("Trataste de ingresar a una posicion que no existe!");
	   }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
	  EjemploTryCatch1();
	  EjemploTryCatch2();
    }
}
