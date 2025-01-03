package com.healthconnection.domain;

import com.healthconnection.shared.helper.ObjectHelper;
import com.healthconnection.shared.helper.TextHelper;
import com.healthconnection.shared.helper.UuidHelper;
import lombok.Getter;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Getter
@Service
public class IdentificationTypeDomain {
	
	private UUID id;

	private String code;

	private String name;

	public IdentificationTypeDomain() {
        setId(UuidHelper.DEFAULT_UUID);
        setCode(TextHelper.EMPTY);
        setName(TextHelper.EMPTY);

	}

	public IdentificationTypeDomain(final UUID id, final String code, final String name) {
    	setId(id);
    	setCode(code);
    	setName(name);
	}

    public static IdentificationTypeDomain create(final UUID id, final String code, final String name) {
    	return new IdentificationTypeDomain(id, code, name);
    }

	public static IdentificationTypeDomain create() {
        return new IdentificationTypeDomain();
    }

    public final String getCode() {
		return code;
    }

    public void setId(UUID id) {
        this.id = ObjectHelper.getDefault(id, UuidHelper.DEFAULT_UUID);
    }

    public final void setCode(String code) {
		this.code = ObjectHelper.getDefault(code, TextHelper.EMPTY);
	}

    public void setName(final String name) {
        this.name = ObjectHelper.getDefault(name, TextHelper.EMPTY);
    }
}
