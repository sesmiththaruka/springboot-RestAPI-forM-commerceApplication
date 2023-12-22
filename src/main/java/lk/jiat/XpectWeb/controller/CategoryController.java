package lk.jiat.XpectWeb.controller;

import lk.jiat.XpectWeb.dto.CategoryDTO;
import lk.jiat.XpectWeb.dto.ResponseDTO;
import lk.jiat.XpectWeb.service.CategoryService;
import lk.jiat.XpectWeb.util.Varlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ResponseDTO responseDTO;

    @GetMapping("/getAllcategory")
    public List<CategoryDTO> getAllCategory(){


            List<CategoryDTO> employeeDTOList = categoryService.getAllCategory();
            responseDTO.setCode(Varlist.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(employeeDTOList);
            new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            return employeeDTOList;

    }
}
