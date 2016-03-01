package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import data.Fatitie;
import data.FattyDAO;


@Controller
public class EventController {
	
	@Autowired
	FattyDAO fattyDAO;
	
	@ResponseBody
	@RequestMapping("fat1/{int}")
	public Fatitie getFatty(@PathVariable("int")int i){
		Fatitie fat = fattyDAO.getByID(i);
		return fat;
	}

	@ResponseBody
	@RequestMapping("fat1")
	public List<Fatitie> getAllFat(){
		return fattyDAO.getAllFatites();
	}
	
	@ResponseBody
	@RequestMapping(path = "fat1", method = RequestMethod.PUT)
	public Boolean addFat(@RequestBody Fatitie fat){  
		return fattyDAO.newFatitie(fat);
	}

    @ResponseBody
    @RequestMapping(path = "fat1", method = RequestMethod.DELETE)
    public Boolean deleteFat(@RequestBody String id) {
    	fattyDAO.deleteFat(Integer.parseInt(id));
        return true;
   }
}