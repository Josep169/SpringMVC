package com.atos.ejercicios.converter;

import org.springframework.core.convert.converter.Converter;

import com.atos.ejercicios.entitie.Gender;
import com.atos.ejercicios.enums.GeneroEnum;

public class GeneroEnumToGenero implements Converter<GeneroEnum, Gender>{

	@Override
	public Gender convert(GeneroEnum generoEnum) {
		Gender genero = new Gender();
		genero.setTitle(generoEnum.name());
		return genero;
	}

}
