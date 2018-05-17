package com.test.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;

/**
 * ClassName ： TestController
 * @author xdcui
 * 创建于 2018年5月3日 下午5:40:45
 * 说明：
 */
@RestController
public class TestController {

	private static final Logger log = LoggerFactory.getLogger(TestController.class);
	
    @GetMapping("/helloworld")
    public String helloworld() {
    	log.trace("logback的--trace日志--输出了");
    	log.debug("logback的--debug日志--输出了");
    	log.info("logback的--info日志--输出了");
    	log.warn("logback的--warn日志--输出了");
    	log.error("logback的--error日志--输出了");
        return "helloworld";
    }
    
    @GetMapping("/helloworld2")
    public String helloworld2() {
    	//org.apache.catalina.connector.Request request = null;
    	HttpServletRequest request = null;
    	HttpSession session = request.getSession();
        return "helloworld2fdsddgds";
    }
    
    
    @GetMapping("/helloworld3")
    public String helloworl22d2() {
        return "这是2eee订单3";
    }
    
    
    @GetMapping("/")
    public String helloworl4() {
        
//        return getHtmlByDom();
    	return getHtmlByDomSpan();
        //return getHtmlByCss();
        //return getHtmlByXpath();
    }
    
    
    
    public String getHtmlByDom() {   
    	StringBuffer sb = null;
    	//WebClient webClient = null;
        try(
        	WebClient webClient=new WebClient(BrowserVersion.FIREFOX_45);    //定义一个WebClient
         ) {
        	
        	String url = null;
        	url = "https://www.cnblogs.com/";
        	//url = "http://erp.chinaums.com/";
            final HtmlPage page=webClient.getPage(url);    //从指定URL获取HtmlPage
            //webClient=new WebClient(BrowserVersion.FIREFOX_45);
            sb = new StringBuffer();
            /**
             * DomElement 的子类：HtmlElement
             * HtmlElemnt也有很多子类，基本上涵盖了所有的Html元素
             * 例如：HtmlDivision,HtmlInput
             */
            System.out.println("=============================================");
            //通过id获取指定DOM元素
            HtmlDivision htmlDiv=(HtmlDivision) page.getElementById("header");
            System.out.println(htmlDiv.asXml());

            System.out.println("=============================================");
            //通过tagName来获取元素集合
            DomNodeList<DomElement> nodeList=page.getElementsByTagName("a");
            for (DomElement domElement : nodeList) {
                HtmlAnchor htmlAnchor=(HtmlAnchor) domElement;
                System.out.println("标题:"+htmlAnchor.asText()+"   -->   地址："+htmlAnchor.getAttribute("href"));
                sb.append("标题:"+htmlAnchor.asText()+"   -->   地址："+htmlAnchor.getAttribute("href")+"<br/>");
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }/*finally {
        	if(webClient != null)
        		webClient.close();    //关闭客户端
        }*/
        
        return "爬取完毕,结果如下:"+"<br/>"+sb.toString();
    }
    
    
    public String getHtmlByDomSpan() {
        
        WebClient webClient=null;
        StringBuffer sb = null;
        try {
        	String url = null;
        	url = "http://erp.chinaums.com/";
            webClient= new WebClient(BrowserVersion.FIREFOX_45);    //定义一个WebClient
            final HtmlPage page=webClient.getPage(url);    //从指定URL获取HtmlPage
            sb = new StringBuffer();
            
            /**
             * DomElement 的子类：HtmlElement
             * HtmlElemnt也有很多子类，基本上涵盖了所有的Html元素
             * 例如：HtmlDivision,HtmlInput
             */
            System.out.println("=============================================");
            //通过tagName来获取元素集合
            DomNodeList<DomElement> nodeList=page.getElementsByTagName("span");
            String resultStr = "";
            for (DomElement domElement : nodeList) {
            	HtmlSpan htmlSpan=(HtmlSpan) domElement;
                if(htmlSpan.getAttribute("targetpage") != null) {
                	if(!"".equals(htmlSpan.getAttribute("targetpage")) && !htmlSpan.getAttribute("targetpage").startsWith("http")) {
                		resultStr = "标题:"+htmlSpan.asText()+"   -->   地址："+url+htmlSpan.getAttribute("targetpage");
                	} else {
                		resultStr = "标题:"+htmlSpan.asText()+"   -->   地址："+htmlSpan.getAttribute("targetpage");
                	}
                	System.out.println(resultStr);
                    sb.append(resultStr+"<br/>");
                }
                
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            webClient.close();    //关闭客户端
        }
        
        return "爬取完毕,结果如下:"+"<br/>"+sb.toString();
    }
    
    
    public String getHtmlByCss() {
        

    	StringBuffer sb = null;
        WebClient webClient=null;
        try {
        	sb = new StringBuffer();
            webClient= new WebClient(BrowserVersion.FIREFOX_45);    //定义一个WebClient
            final HtmlPage page=webClient.getPage("https://www.cnblogs.com/");    //从指定URL获取HtmlPage
            
            HtmlDivision htmlDiv =page.querySelector("div");//获取第一个div
            System.out.println(htmlDiv.asXml());
            
            System.out.println("====================================");
            
            HtmlDivision htmlDiv2=page.querySelector("div#footer_bottom");//也可以指定多个选择器，通过‘,’隔开
            System.out.println(htmlDiv2.asXml());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            webClient.close();    //关闭客户端
        }
        
        return "爬取完毕,结果如下:"+"<br/>"+sb.toString();
    }
    
    
    public String getHtmlByXpath() {
        
    	StringBuffer sb = null;
    	WebClient webClient=null;
        try {
        	sb = new StringBuffer();
            webClient= new WebClient(BrowserVersion.FIREFOX_45);    //定义一个WebClient
            final HtmlPage page=webClient.getPage("https://www.cnblogs.com/");    //从指定URL获取HtmlPage
            
            @SuppressWarnings("unchecked")
			List<HtmlDivision> divList=(List<HtmlDivision>) page.getByXPath("//div[@id='cnblogs_a1']");
            for (HtmlDivision htmlDivision : divList) {
                System.out.println("***********************************************8");
                System.out.println(htmlDivision.asXml());
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            webClient.close();    //关闭客户端
        }
        
        return "爬取完毕,结果如下:"+"<br/>"+sb.toString();
    }
    
}