package pro.sky.exever.employeewebservice;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import pro.sky.exever.employeewebservice.exception.ValidationFailException;

@Service
public class ValdationServiceImpl implements ValidationService{
	@Override
	public String validateName(String name) {
		if (StringUtils.isAlpha(name)) {
			return StringUtils.capitalize(StringUtils.lowerCase(name));
		}
		throw new ValidationFailException();
	}

}
