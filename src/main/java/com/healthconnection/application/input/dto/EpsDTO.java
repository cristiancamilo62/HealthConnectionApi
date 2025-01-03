package com.healthconnection.application.input.dto;

import com.healthconnection.shared.helper.TextHelper;
import com.healthconnection.shared.helper.UuidHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Data
@AllArgsConstructor
public class EpsDTO {

	private UUID id;

	private String name;
	
	public EpsDTO() {
		setId(UuidHelper.DEFAULT_UUID);
		setName(TextHelper.EMPTY);
		
	}
	
	

	
	
}
