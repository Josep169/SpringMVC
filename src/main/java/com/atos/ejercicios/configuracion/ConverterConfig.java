package com.atos.ejercicios.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.atos.ejercicios.converter.ClienteRequestToCliente;
import com.atos.ejercicios.converter.ClienteRequestToClienteResponse;
import com.atos.ejercicios.converter.GeneroEnumToGenero;
import com.atos.ejercicios.converter.JuegoRequestToJuego;
import com.atos.ejercicios.converter.JuegoToJuegoResponseCmpl;

@Configuration
public class ConverterConfig implements WebMvcConfigurer{

	public void addConverters(FormatterRegistry registro) {
		registro.addConverter(new GeneroEnumToGenero());
		registro.addConverter(new JuegoRequestToJuego());
		registro.addConverter(new JuegoToJuegoResponseCmpl());
		registro.addConverter(new ClienteRequestToCliente());
		registro.addConverter(new ClienteRequestToClienteResponse());
	}
}
