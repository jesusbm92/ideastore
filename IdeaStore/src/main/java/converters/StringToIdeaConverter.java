package converters;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import repositories.IdeaRepository;
import domain.Idea;

@Component
@Transactional
public class StringToIdeaConverter implements Converter<String, Idea> {

	@Autowired
	IdeaRepository ideaRepository;

	@Override
	public Idea convert(String text) {
		Idea result;
		int id;

		try {
			if (StringUtils.isEmpty(text))
				result = null;
			else {
				id = Integer.valueOf(text);
				result = ideaRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}