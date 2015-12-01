package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.Idea;

@Component
@Transactional
public class IdeaToStringConverter implements Converter<Idea, String>{

	@Override
	public String convert(Idea idea) {
		String result;

		if (idea == null)
			result = null;
		else
			result = String.valueOf(idea.getId());

		return result;
	}
}
