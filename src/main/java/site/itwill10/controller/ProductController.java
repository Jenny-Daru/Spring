package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Product;
import site.itwill10.dto.ProductCollection;

@Controller
public class ProductController {
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String productInput() {
		return "product_input";
	}
	
/*	
	[ �ϳ��� ��ǰ�� ����ϴ� ��� ]
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String productOutput(@ModelAttribute Product product) {
		return "product_output";
	}
*/
	
//	[ �ټ��� ��ǰ�� ����ϴ� ��� ]
//	 => �Է����������� �Է��±��� name���� 
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String productOutput(@ModelAttribute(value = "collection" ) ProductCollection collection) {
		return "product_output";
	}
	

}
















