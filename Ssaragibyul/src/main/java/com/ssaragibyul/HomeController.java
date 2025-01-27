package com.ssaragibyul;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssaragibyul.donation.domain.Donation;
import com.ssaragibyul.donation.service.DonationService;
import com.ssaragibyul.funding.domain.Funding;
import com.ssaragibyul.funding.service.FundingService;
import com.ssaragibyul.visit.domain.Visit;
import com.ssaragibyul.visit.service.VisitService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private FundingService fService;
	
	@Autowired
	private DonationService dService;
	
	@Autowired
	private VisitService vService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		/*
		 * Date date = new Date(); DateFormat dateFormat =
		 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		 * 
		 * String formattedDate = dateFormat.format(date);
		 * 
		 * model.addAttribute("serverTime", formattedDate );
		 */
		ArrayList<Funding> fListandFile = fService.printAllProjectLimit();
		ArrayList<Funding> fListandFileEnd = fService.printAllProjectEndLimit();
		ArrayList<Donation> dListandFile = dService.printAllProject();
		ArrayList<Donation> dListandFileEnd = dService.printAllProjectEnd();
		ArrayList<Visit> vList = vService.printAll();
		if(!fListandFile.isEmpty() && !dListandFile.isEmpty() && !vList.isEmpty()) {
			model.addAttribute("fListandFile", fListandFile);
			model.addAttribute("fListandFileEnd", fListandFileEnd);
			model.addAttribute("dListandFile", dListandFile); 
			model.addAttribute("dListandFileEnd", dListandFileEnd);
			model.addAttribute("vList", vList);
		}else {
			model.addAttribute("msg", "펀딩 목록조회 실패");
		} 
		
		return "home";
	}
	
	@RequestMapping(value="/guide.do", method = RequestMethod.GET)
	public String guidePage() {
		return "guidePage";
	}
	
}
