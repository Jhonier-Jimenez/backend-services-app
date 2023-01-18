package marketapp.web.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import marketapp.domain.service.SearchService;
import marketapp.persistence.entity.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/searches")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/all")
    @ApiOperation("Get all searches")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Search>> getAllSearches(){
        return new ResponseEntity<>(searchService.getAllSearches(), HttpStatus.OK);
    }

    @GetMapping("/{productID}")
    @ApiOperation("Find a product search count using its ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product search not found")
    })
    public ResponseEntity<Search> getSearch(
            @ApiParam(value = "The product ID", required = true, example = "7")
            @PathVariable("productID") Integer productID){
        return searchService.getSearchByID(productID)
                .map(search -> new ResponseEntity<>(search, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{productID}")
    public ResponseEntity deleteSearch(@PathVariable("productID") Integer productID){
        if (searchService.deleteSearch(productID)){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/most-searched")
    @ApiOperation("Get most searched products")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Search>> getMostSearchedProducts(){
        return new ResponseEntity<>(searchService.getMostSearchedProducts(), HttpStatus.OK);
    }
}
