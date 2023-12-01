package com.spring.mvc.chapter04_ajax;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.mvc.dto.ProductDTO;

@Controller
@RequestMapping("/ajax")
public class C2A {

	
	/*
	    # AJAX데이터 전송
	    
	    - pom.xml파일에 의존성 추가
	    
		<!-- jackson-core -->
		<dependency>
		    <groupId>com.fasterxml.jackson.core</groupId>
		    <artifactId>jackson-databind</artifactId>
		    <version>2.9.2</version>
		</dependency>
	*/

	
	@GetMapping("/c2a")
	public String recv() {
		return "chapter04_AJAX/c2a";
	}

	
	// (경우의 수 1) 단일데이터 return
	@GetMapping("/c2aEx01")
	@ResponseBody // @ResponseBody 어노테이션을 추가하여 데이터를 ajax로 전송한다.
	public String c2aEx01() {
		return "y";
	}

	
	// (경우의 수 2) DTO return
	@GetMapping("/c2aEx02")
	@ResponseBody
	public ProductDTO c2aEx02() {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductCd(1);
		productDTO.setProductNm("키보드" + 1);
		productDTO.setPrice(10000);
		productDTO.setDeliveryPrice(2500);
		productDTO.setEnrollDt(new Date());
		productDTO.setBrandCd("b1");
		
		return productDTO;
	}
	
	
	// (경우의 수 3) List<DTO> return
	@GetMapping("/c2aEx03")
	@ResponseBody
	public List<ProductDTO> c2aEx03() {
		
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		
		for (int i = 1; i < 11; i++) {
			ProductDTO ProductDTO = new ProductDTO();
			ProductDTO.setProductCd(i);
			ProductDTO.setProductNm("키보드" +i);
			ProductDTO.setPrice(10000 * i);
			ProductDTO.setDeliveryPrice(2500);
			ProductDTO.setEnrollDt(new Date());
			ProductDTO.setBrandCd("b" + i);
			productList.add(ProductDTO);
		}
		
		return productList;
		
	}
	
	
	// (경우의 수 4) Map return 
	@GetMapping("/c2aEx04")
	@ResponseBody
	public Map<String, Object> c2aEx04() {
		
		Map<String, Object> orderMap = new HashMap<String, Object>();
		orderMap.put("orderCd"  , "order1");
		orderMap.put("orderQty" , 2);
		orderMap.put("cartCd"   , "cart3");
		orderMap.put("cartQty"  , 4);
		
		return orderMap;
		
	}
	
	
	
	
	// (경우의 수 5) List<Map> return
	@GetMapping("/c2aEx05")
	@ResponseBody
	public List<Map<String, Object>> c2aEx05() {
		
		List<Map<String, Object>> orderMapList = new ArrayList<Map<String,Object>>();
		
		for (int i = 1; i < 11; i++) {
			Map<String, Object> orderMap = new HashMap<String, Object>();
			orderMap.put("orderCd", "order" + i);
			orderMap.put("orderQty", i);
			orderMap.put("cartCd", "cart" + i);
			orderMap.put("cartQty", i);
			orderMapList.add(orderMap);
		}
		
		return orderMapList;
		
		
	}
	
	
}
