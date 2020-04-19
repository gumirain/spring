package mrs.domain.model.converter;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

//autoApply属性にtrueを設定することで、エンテティのLocalDate型フィールドに対してこのAttributeConverterが自動で適用される。
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {
	@Override
	public Date convertToDatabaseColumn(LocalDate date) {
		//LocalDateオブジェクトからjava.sql.Dateオブジェクトを変換する。
		return date == null ? null : Date.valueOf(date);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date value) {
		//java.sql.DateオブジェクトからLocalDateオブジェクトに変換する。
		return value == null ? null : value.toLocalDate();
	}

}
