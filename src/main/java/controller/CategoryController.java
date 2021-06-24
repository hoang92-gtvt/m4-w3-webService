package controller;

import model.Category;
import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.category.ICategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    public ICategoryService categoryService;



    @GetMapping
    public ModelAndView showAll(){
        return new ModelAndView("/category/list","categories" , categoryService.findAll() );

    }


    @GetMapping("/list")
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categories = (List<Category>) categoryService.findAll();

        if(categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{

            return new ResponseEntity<>(categories, HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findOne(@PathVariable Long id){
        Optional<Category> categoryOptional = categoryService.findById(id);
        if(!categoryOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryOptional.get(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Category> create(@RequestBody Category category){
        categoryService.save(category);
        return  new ResponseEntity<>( category, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Category> editCategory(@RequestBody Category category, @PathVariable Long id){
        Optional<Category> categoryOptional= categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
       category.setId(id);
       categoryService.save(category);
       return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public  ResponseEntity <Category> deleteCategory(@PathVariable Long id){

       Optional<Category> category1= categoryService.findById(id);
        if (!category1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.remove(id);
       return new ResponseEntity<>(category1.get(), HttpStatus.OK);
    }
}
