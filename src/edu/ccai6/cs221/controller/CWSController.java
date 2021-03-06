package edu.ccai6.cs221.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cue.lang.WordIterator;
import edu.ccai6.cs221.QueryProcessor;
import edu.ccai6.cs221.Result;
import edu.ccai6.cs221.dao.HTMLDao;
import edu.ccai6.cs221.dao.IFIDF;
import edu.ccai6.cs221.dao.IFIDFDao;
import edu.ccai6.cs221.dao.TextDao;
import edu.ccai6.cs221.dao.URLDao;
import edu.ccai6.cs221.queryBeans.QueryWords;

@Controller
public class CWSController {
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("index", "command", new QueryWords());
	}
	
	@RequestMapping(value="index2", method = RequestMethod.GET)
	public ModelAndView index2() {
		return new ModelAndView("index2", "command", new QueryWords());
	}
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView doQuery(@ModelAttribute("SpringWeb") QueryWords query, ModelMap model) {
		String querySentence = query.getQuery();
//		if (query.isImprovedVersion()) System.out.println("Is improved version!");
		if (querySentence.equals("") || querySentence == null) return new ModelAndView("index", "command", new QueryWords());
		QueryProcessor qp = new QueryProcessor();
		for (String token : new WordIterator(querySentence)) {
			qp.add(token.toLowerCase().trim());
		}
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("Beans.xml");
		IFIDFDao ifidfDao = (IFIDFDao)context.getBean("IFIDFDao");
		HTMLDao htmlDao = (HTMLDao)context.getBean("htmlDao");
		URLDao urlDao = (URLDao)context.getBean("URLDao");
		TextDao textDao = (TextDao)context.getBean("TextDao");

		List<Result> rslList = null;
		if (query.isImprovedVersion()) {
			rslList = qp.rankImproved(ifidfDao, urlDao, textDao, htmlDao);
		} else {
			rslList = qp.rank(ifidfDao, urlDao, textDao, htmlDao);
		} 

		model.addAttribute("rslList", rslList);
		return new ModelAndView("result", "command", new QueryWords());
	}
}
