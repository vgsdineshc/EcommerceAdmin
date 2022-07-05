package com.ecomm.admin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecomm.admin.dao.CatageryDao;
import com.ecomm.admin.dao.ProductDao;
import com.ecomm.admin.pojo.Catagery;
import com.ecomm.admin.pojo.Product;
import com.ecomm.admin.repo.CatageryRepo;

@Controller
@RequestMapping(value="/pages")
public class AdminController {
	
	Logger logger = Logger.getAnonymousLogger();

	@Autowired
	private CatageryDao catDao;
	
	@Autowired
	private ProductDao proDao;
	
		
	@RequestMapping(value="/logindetails")
	public ModelAndView getLoginDetails(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			Model model
			)
	{
		logger.info("-->1-->"+username);
		logger.info("-->1-->"+password);
		ModelAndView mv = new ModelAndView();
		HttpSession httpSession = request.getSession();
		if(username.equals(password))
		{
			httpSession.setAttribute("username",username);
			mv.setViewName("menu");
		}
		else
		{
			model.addAttribute("error", "Wrong username or password!");
			mv.setViewName("loginadmin");
			mv.addObject(model);
		}
		return mv;
	}
	@RequestMapping(value = "/addnewcatagery", method = RequestMethod.POST)
	public ModelAndView addnewCatagery(HttpServletRequest req, HttpServletResponse res, Model model)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("catageryinsert");
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse res, Model model)
	{
		HttpSession session = req.getSession();
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("loginadmin");
		return mv;
	}
	
	@RequestMapping(value = "/categoryInsert", method = RequestMethod.POST)
	public ModelAndView categoryInsert(@RequestParam("categoryname") String categoryname,@RequestParam("catId") String catId, HttpServletRequest req, HttpServletResponse res, Model model)
	{
		HttpSession session = req.getSession();
		ModelAndView mv = new ModelAndView();
		logger.info("------>"+categoryname);
		logger.info("------>"+catId);
		Catagery catagery = new Catagery();
		catagery.setCname(categoryname);
		if(catId.equals(null)||catId==null||catId==""||catId.equals(""))
		{
			catDao.saveCategory(catagery); 
		}
		else
		{
			catagery.setCid(Integer.valueOf(catId));
			catDao.updateCategory(catagery);
		}
		
		List<Catagery> catageries = catageryRet();
		session.setAttribute("catageries", catageries);
		List<Catagery> catageriess = new ArrayList<Catagery>();
		session.setAttribute("catageriess", catageriess);
		mv.setViewName("catageryretriee");
		return mv;
	}
	
	@RequestMapping(value = "editcat", method = RequestMethod.GET)
	public ModelAndView editcat(@RequestParam("id") String actionName, HttpServletRequest req, HttpServletResponse res, Model model)
	{
		HttpSession session = req.getSession();
		int catId = Integer.valueOf(actionName);
		Catagery catagery = catDao.getCategories(catId);
		List<Catagery> catageries = new ArrayList<Catagery>();
		catageries.add(catagery);
		session.setAttribute("catageriess", catageries);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("catageryinsert");
		return mv;
	}
	
	
	@RequestMapping(value = "deletecat", method = RequestMethod.GET)
	public ModelAndView deletecat(@RequestParam("id") String actionName, HttpServletRequest req, HttpServletResponse res, Model model)
	{
		HttpSession session = req.getSession();
		int catId = Integer.valueOf(actionName);
		catDao.deletbyId(catId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("catageryretriee");
		List<Catagery> catageries = catageryRet();
		session.setAttribute("catageries", catageries);
		return mv;
	}
	
	@RequestMapping(value = "/catagerRet", method = RequestMethod.GET)
	public ModelAndView catagerRet(HttpServletRequest req, HttpServletResponse res, Model model)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("catageryretriee");
		HttpSession session = req.getSession();
		List<Catagery> catageries = catageryRet();
		session.setAttribute("catageries", catageries);
		return mv;
	}
	
	
	@RequestMapping("/productView")
	public ModelAndView productView(HttpServletRequest req, HttpServletResponse res)
	{
		HttpSession session = req.getSession();
		List<Product> productList = productRet();
		ModelAndView mv = new ModelAndView();
		session.setAttribute("productRet", productList);
		logger.info("---->product List"+productList.size());
		mv.setViewName("productlist");
		return mv;
	}
	
	@RequestMapping(value = "/productinsert", method = RequestMethod.POST)
	public ModelAndView productInsert(HttpServletRequest req, HttpServletResponse res, Model model,
			@RequestParam("productName") String productName,
			@RequestParam("productPrice") String productPrice,
			@RequestParam("catId") String catId
			)
	{
		HttpSession session = req.getSession();
		ModelAndView mv = new ModelAndView();
		Product product = new Product();
		Catagery catagery = catDao.getCategories(Integer.valueOf(catId));
		product.setCatagery(catagery);
		product.setPname(productName);
		product.setPrice(Integer.valueOf(productPrice));
		proDao.saveProduct(product);
		List<Product> productList = productRet();
		session.setAttribute("productRet", productList);
		logger.info("---->product List"+productList.size());
		mv.setViewName("productlist");
		return mv;
	}
	
	@RequestMapping(value = "/producteditinsert", method = RequestMethod.POST)
	public ModelAndView producteditinsert(HttpServletRequest req, HttpServletResponse res, Model model,
			@RequestParam("productName") String productName,
			@RequestParam("productPrice") String productPrice,
			@RequestParam("catId") String catId
			)
	{
		HttpSession session = req.getSession();
		ModelAndView mv = new ModelAndView();
		Product productEdit = (Product)session.getAttribute("productEdit");
		Product product = new Product();
		Catagery catagery = catDao.getCategories(Integer.valueOf(catId));
		product.setCatagery(catagery);
		product.setPid(productEdit.getPid());
		product.setPname(productName);
		product.setPrice(Integer.valueOf(productPrice));
		proDao.updateProduct(product);
		List<Product> productList = productRet();
		session.setAttribute("productRet", productList);
		logger.info("---->product List"+productList.size());
		mv.setViewName("productlist");
		return mv;
	}
	
	
	
	@RequestMapping("/productDelete")
	public ModelAndView productDelete(HttpServletRequest req, HttpServletResponse res, @RequestParam("proId") String proId)
	{
		HttpSession session = req.getSession();
		ModelAndView mv = new ModelAndView();
		proDao.deleteProduct(Integer.valueOf(proId));
		List<Product> productList = productRet();
		session.setAttribute("productRet", productList);
		logger.info("---->product List"+productList.size());
		mv.setViewName("productlist");
		return mv;
	}
	
	
	@RequestMapping("/productEdit")
	public ModelAndView productEdit(HttpServletRequest req, HttpServletResponse res, @RequestParam("proId") String proId)
	{
		HttpSession session = req.getSession();
		ModelAndView mv = new ModelAndView();
		Product product = proDao.getProduct(Integer.valueOf(proId));
		session.setAttribute("productEdit", product);
		List<Catagery> catageries = catageryRet();
		session.setAttribute("catageries", catageries);
		mv.setViewName("producteditentry");
		return mv;
	}
	
	//productentry
	@RequestMapping(value = "/productentry", method = RequestMethod.GET)
	public ModelAndView productEntry(HttpServletRequest req, HttpServletResponse res, Model model)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("productinsert");
		HttpSession session = req.getSession();
		List<Catagery> catageries = catageryRet();
		session.setAttribute("catageries", catageries);
		List<Product> productRet = productRet();
		session.setAttribute("productRet", productRet);
		return mv;
	}
	
	private List<Product> productRet() {	
		return proDao.getListofProduct();
	}
	public List<Catagery> catageryRet()
	{
		//List<Catagery> catageries = new ArrayList<Catagery>();
		return catDao.getListofCatageries();

	}
	
}
