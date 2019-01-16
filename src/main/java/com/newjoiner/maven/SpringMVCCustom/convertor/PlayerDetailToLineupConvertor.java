package com.newjoiner.maven.SpringMVCCustom.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.newjoiner.maven.SpringMVCCustom.model.Player;
import com.newjoiner.maven.SpringMVCCustom.model.PlayerDetail;
import com.newjoiner.maven.SpringMVCCustom.service.PlayerDetailService;
import com.newjoiner.maven.SpringMVCCustom.service.PlayerService;

@Component
public class PlayerDetailToLineupConvertor implements Converter<Object, PlayerDetail> {
	@Autowired
	PlayerDetailService playerDetailService;
	
	//intercept Player object nested in lineup and retrieve Player POJOS from array of ids
	@Override
	public PlayerDetail convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		PlayerDetail playerDetail = playerDetailService.findById(id);
		return playerDetail;
	}
}
