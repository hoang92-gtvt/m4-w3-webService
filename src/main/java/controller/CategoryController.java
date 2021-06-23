package controller;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.category.ICategoryService;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    public ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> showAll(){
        List<Category> categories = (List<Category>) categoryService.findAll();
        if(categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }
}
