package com.healthconnection.domain;

import com.healthconnection.shared.helper.ObjectHelper;
import com.healthconnection.shared.helper.TextHelper;
import com.healthconnection.shared.helper.UuidHelper;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Getter
@Service
public class AffiliationRegimeDomain {
	
	private UUID id;

	private String type;

	private String serviceCoverages;
	
	public AffiliationRegimeDomain() {
		setId(UuidHelper.DEFAULT_UUID);
		setType(TextHelper.EMPTY);
		setServiceCoverages(TextHelper.EMPTY);
	}

	public AffiliationRegimeDomain(final UUID id, final String type, final String serviceCoverages) {
		setId(id);
		setType(type);
		setServiceCoverages(serviceCoverages);
	}
	
	public static AffiliationRegimeDomain create(final UUID id, final String type, final String serviceCoverages) {
		return new AffiliationRegimeDomain(id, type, serviceCoverages);
	}
	
	public static AffiliationRegimeDomain create() {
		return new AffiliationRegimeDomain();
	}

	public final void setId(UUID id) {
		this.id = ObjectHelper.getDefault(id, UuidHelper.DEFAULT_UUID);
	}

	public final void setType(String type) {
		this.type = ObjectHelper.getDefault(type, TextHelper.EMPTY);
	}

	public final void setServiceCoverages(String serviceCoverages) {
		this.serviceCoverages = ObjectHelper.getDefault(serviceCoverages, TextHelper.EMPTY);
	}
	
	

}
