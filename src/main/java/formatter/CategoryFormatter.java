package formatter;


import model.Category;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import service.category.ICategoryService;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class CategoryFormatter implements Formatter<Optional<Category>> {

    private ICategoryService categoryService;

    public CategoryFormatter() {
    }

    public CategoryFormatter(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    public Optional<Category> parse(String text, Locale locale) throws ParseException {
       Optional<Category> category=categoryService.findById(Long.parseLong(text));
        return category;
    }

    @Override
    public String print(Optional<Category> object, Locale locale) {
        return null;
    }
}
