package com.atos.ejercicios.converter;

import org.springframework.core.convert.converter.Converter;

import com.atos.ejercicios.dto.response.GeneroDto;
import com.atos.ejercicios.entitie.Gender;
public class GeneroToGeneroDto implements Converter<Gender, GeneroDto> {
	
	@Override
	public GeneroDto convert(Gender gender) {
		GeneroDto generoDto = new GeneroDto();
		generoDto.setId(gender.getId());
		generoDto.setNombre(gender.getTitle());
		return generoDto;
	}
}
