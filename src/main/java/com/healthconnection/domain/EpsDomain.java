package com.healthconnection.domain;


import com.healthconnection.shared.helper.ObjectHelper;
import com.healthconnection.shared.helper.TextHelper;
import com.healthconnection.shared.helper.UuidHelper;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Getter
@Service
public class EpsDomain {
	
	private UUID id;

	private String name;

	public EpsDomain() {
		setId(UuidHelper.DEFAULT_UUID);
		setName(TextHelper.EMPTY);
		
	}
	
	public EpsDomain(final UUID id, final String name) {
		setId(id);
		setName(name);
		
	}
	
	public static EpsDomain create(final UUID id, final String name) {
		return new EpsDomain(id, name);
	}
	
	public static EpsDomain create() {
		return new EpsDomain();
	}

	public final void setId(UUID id) {
		this.id = ObjectHelper.getDefault(id, UuidHelper.DEFAULT_UUID);
	}

	public final void setName(String name) {
		this.name = ObjectHelper.getDefault(name, TextHelper.EMPTY);
	}
	
	
	
	

}
