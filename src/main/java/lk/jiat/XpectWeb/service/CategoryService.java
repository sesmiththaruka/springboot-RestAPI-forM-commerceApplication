package lk.jiat.XpectWeb.service;

import jakarta.transaction.Transactional;
import lk.jiat.XpectWeb.dto.CategoryDTO;
import lk.jiat.XpectWeb.entity.Category;
import lk.jiat.XpectWeb.repo.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ModelMapper modelMapper;
    public List<CategoryDTO> getAllCategory(){
        List<Category> allcategories = categoryRepo.findAll();
        return modelMapper.map(allcategories,new TypeToken<ArrayList<CategoryDTO>>(){}.getType());
    }
}
