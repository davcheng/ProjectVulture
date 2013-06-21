package com.springAPITest.proV;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springAPITest.proV.forms.searchCandidateForm;
import com.springAPITest.proV.service.OpenSecretService;
import com.springAPITest.proV.service.data.OpenSecretResponse;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes


public class SearchController {

   @RequestMapping(value = "/candidate", method = RequestMethod.GET)
   public ModelAndView searchPage(final Model model) {
	  final searchCandidateForm searchCandidate = new searchCandidateForm();
	  model.addAttribute("search", searchCandidate);
	  System.out.println("candidate get request "+searchCandidate.getCid());
      return new ModelAndView("searchCandidate", "command", new searchCandidateForm());
   }
   
   @RequestMapping(value = "/search-candidate-test", method = RequestMethod.POST)
   public String searchCandidate(@ModelAttribute OpenSecretResponse searchResponse, 
   ModelMap model) throws JsonParseException, JsonMappingException, IOException {
		
	   String CID = "N00002097";
		OpenSecretResponse candidateInfo = OpenSecretService.retrieveOpenSecretCandidateData(CID);
		
	  System.out.println("Test"+candidateInfo.getCash_on_hand()); 
	   
      model.addAttribute("cid", searchResponse.getCid());
      model.addAttribute("cand_name", searchResponse.getCand_name());
      model.addAttribute("cash_on_hand", searchResponse.getCash_on_hand());
      model.addAttribute("total_cash", searchResponse.getTotal());
      model.addAttribute("spent_cash", searchResponse.getSpent());
      
      return "result";
   }

}
