package com.uca.capas.ejemplo.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.text.ParseException;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	//EJEMPLOS DE LA CLASE
	@RequestMapping("/ejemplo")
	public @ResponseBody String ejemplo() {		
		String texto = "Hola Mundo desde Spring MVC! La hora actual es: ";
		return texto.concat(Calendar.getInstance().getTime().toString());
	}
	@RequestMapping("/parametro")
	public @ResponseBody String parametro(HttpServletRequest request) {
		
		Integer param = Integer.parseInt(request.getParameter("dia"));
		String dia;
		
		switch(param) {
			case 1: dia = "Lunes";
			break;
			case 2: dia = "Martes";
			break;
			case 3: dia = "Miercoles";
			break;
			case 4: dia = "Jueves";
			break;
			case 5: dia = "Viernes";
			break;
			case 6: dia = "Sabado";
			break;
			case 7: dia = "Domingo";
			break;
			default: dia = "Ningun dia seleccionado";
			break;
		}
		
		return "Dia de la semana enviado: " + dia;
		
	}
	//Controlador para la informacion de estudiante
	@RequestMapping("/info")
	public @ResponseBody String informacion() {		
		String texto = "Nombre: Ricardo  - Apellido: Gómez - Carnet: 00108517 - Carrera: Ingenieria Informatica - Año cursado: 4";
		return texto;
	}
	
	//Controlador para dia de la semana
	@RequestMapping("/dia")
	public @ResponseBody String dia(HttpServletRequest request) {
		
		Calendar calendar = Calendar.getInstance();
		int año = Integer.parseInt(request.getParameter("año"));
		int mes = Integer.parseInt(request.getParameter("mes"))-1;
		int dia = Integer.parseInt(request.getParameter("dia"));
		try {
		calendar.set(año, mes, dia); 
	    String[] dias = new String[] { "Doming", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado" };
	    return "El dia es: "+dias[calendar.get(Calendar.DAY_OF_WEEK) -1];
		}catch(Exception e) {
			return "error";
		}
		
		
	}
	
}