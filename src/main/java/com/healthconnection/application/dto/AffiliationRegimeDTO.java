package com.healthconnection.application.dto;

import com.healthconnection.shared.helper.TextHelper;
import com.healthconnection.shared.helper.UuidHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.UUID;

@Data
@AllArgsConstructor
public final class AffiliationRegimeDTO {

	private UUID id;

	private String type;

	private String serviceCoverages;

	public AffiliationRegimeDTO() {
		setId(UuidHelper.DEFAULT_UUID);
		setType(TextHelper.EMPTY);
		setServiceCoverages(TextHelper.EMPTY);
	}

}
