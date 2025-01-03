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
public class IdentificationTypeDTO {

	private UUID id;

	private String code;

	private String name;
	
	public IdentificationTypeDTO() {
        setId(UuidHelper.DEFAULT_UUID);
        setCode(TextHelper.EMPTY);
        setName(TextHelper.EMPTY);
        
	}
}
