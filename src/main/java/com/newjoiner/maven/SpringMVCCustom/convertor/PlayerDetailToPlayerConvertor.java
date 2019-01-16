package com.newjoiner.maven.SpringMVCCustom.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.newjoiner.maven.SpringMVCCustom.model.Player;
import com.newjoiner.maven.SpringMVCCustom.service.PlayerService;

@Component
public class PlayerDetailToPlayerConvertor implements Converter<Object, Player> {
	@Autowired
	PlayerService playerService;
	
	//intercept Player object nested in lineup and retrieve Player POJOS from array of ids
	@Override
	public Player convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		Player player = playerService.findById(id);
		return player;
	}
}
