package com.newjoiner.maven.SpringMVCCustom.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.newjoiner.maven.SpringMVCCustom.model.Player;
import com.newjoiner.maven.SpringMVCCustom.service.PlayerService;

@Component
public class PlayerToLineupConvertor implements Converter<Object, Player> {
	@Autowired
	PlayerService playerService;
	
	@Override
	public Player convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		Player player = playerService.findById(id);
		System.out.println("Player "+ player);
		return player;
	}
}
