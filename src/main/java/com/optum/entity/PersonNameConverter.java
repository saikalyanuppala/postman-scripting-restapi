package com.optum.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.stereotype.Component;

@Converter(autoApply = true)
@Component
public class PersonNameConverter implements AttributeConverter<PersonName, String> {

	@Override
	public String convertToDatabaseColumn(PersonName pname) {
		if (pname == null)
			return null;
		StringBuilder sb = new StringBuilder();
		if (pname.getFirstName() != null && !pname.getFirstName().isEmpty())
			sb.append(pname.getFirstName());

		if (pname.getLastName() != null && !pname.getLastName().isEmpty()) {
			sb.append(":");
			sb.append(pname.getLastName());
		}

		return sb.toString();
	}

	@Override
	public PersonName convertToEntityAttribute(String dbData) {
		if (dbData == null || dbData.isEmpty())
			return null;

		String[] data = dbData.split(":");
		if (data == null || data.length == 0)
			return null;

		PersonName pname = new PersonName();
		String firstName = !data[0].isEmpty() ? data[0] : null;
		if (dbData.contains(":")) {
			pname.setFirstName(firstName);

			if (data.length >= 2 && data[1] != null && !data[1].isEmpty()) {
				pname.setLastName(data[1]);
			}
		} else {
			pname.setFirstName(firstName);
		}

		return null;
	}
}
