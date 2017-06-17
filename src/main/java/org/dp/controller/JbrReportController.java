package org.dp.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.dp.dao.JbrCategoryMapper;
import org.dp.entity.JbrCategoryWithBLOBs;
import org.dp.entity.JbrJubao;
import org.dp.entity.JbrReport;
import org.dp.entity.PhotoResult;
import org.dp.entity.Result;
import org.dp.service.JbrReportService;
import org.dp.util.ExcelWork;
import org.dp.util.JsonUtil;
import org.dp.util.Validator;
import org.omg.Messaging.SyncScopeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/jubaoManage")
public class JbrReportController extends BaseController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpSession session;
	@Autowired
	private JbrReportService service;

	@RequestMapping(value = "/UploadFile", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Object uploadFile(@RequestParam(name = "uploadfile", required = false) MultipartFile file) {
		String result = "";
		try {
			if (file != null) {
				result = saveFile(file);
			} else {
				result = "result=文件为空";
			}
//			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/UploadReportSignature")
	@ResponseBody
	public Object uploadReportSignature(JbrReport record, @RequestParam(value = "yzm", required = false) String yzm)
			throws IOException {
		Result result = new Result();
		// System.out.println(files.getOriginalFilename());
		// System.out.println(record.toString());
		//System.out.println(session.getAttribute("code"));
	//	String code = session.getAttribute("code").toString();
		/**
		 * 1.验证举报人 姓名 格式和是否空值
		 * 2.验证身份证号
		 * 3.验证联系方式
		 * 4.验证现居住地址
		 */
		if(!Validator.isChinesename(record.getUser_name())){
			result.setStatus("error");
			result.setError("请正确填写举报人姓名");
		}
		else if(!Validator.isIDCard(record.getUser_idcard())){
			result.setStatus("error");
			result.setError("请正确填写身份证号");
		}
		else if(!Validator.isMobile(record.getUser_phone())){
			result.setStatus("error");
			result.setError("请正确填写联系方式");
		}
		else if(record.getUser_dizhi() == null){
			result.setStatus("error");
			result.setError("请填写居住地址");
		}
		/**
		 * 1.验证被举报人 姓名 格式和是否空值 
		 * 2.验证 标题 是否为空 
		 * 3.验证 问题类别 是否填写 
		 * 4.验证问题细类 是否填写 
		 * 5.验证主要问题是否填写
		 */
		else if (!Validator.isChinesename(record.getReport_name()))
		{
			result.setStatus("error");
			result.setError("请正确填写被举报人姓名");
		} 
		else if(record.getTitle() == null){
			result.setStatus("error");
			result.setError("请填写标题");
		}
		else if(record.getQuestion1() == null){
			result.setStatus("error");
			result.setError("请选择问题类别");
		}
		else if(record.getQuestion2() == null){
			result.setStatus("error");
			result.setError("请选择问题细类");
		}
		else if(record.getContent() == null || record.getContent().trim() == ""){
			result.setStatus("error");
			result.setError("请填写主要问题");
		}
//		else if (!code.equals(yzm.toLowerCase())) {
//			result.setStatus("error");
//			result.setError("验证码错误");
//		}
		else {
			record.setContent(record.getContent().trim());
			//指定路径创建excel父文件夹
			String path = request.getSession().getServletContext().getRealPath("/static/report");
			//System.out.println("路径："+path);
			// 设置父级文件
			File parent = new File(path);
			if (!parent.exists()) {
				parent.mkdirs();
			}
			//插入一行数据到excel中
			ExcelWork.writeExcel(record,path);
		//	service.insertSignature(record);
			result.setStatus("提交成功");
		}
		return result;
	}

	@RequestMapping(value = "/UploadReportAnonymous")
	@ResponseBody
	public Object uploadReportAnonymous(JbrReport record, @RequestParam(value = "yzm", required = false) String yzm)
			throws IOException {
		Result result = new Result();
		//System.out.println(session.getAttribute("code"));
		String code = session.getAttribute("code").toString();
		/**
		 * 1.验证被举报人 姓名 格式和是否空值 
		 * 2.验证 标题 是否为空 
		 * 3.验证 问题类别 是否填写 
		 * 4.验证问题细类 是否填写 
		 * 5.验证主要问题是否填写
		 */
		if (!Validator.isChinesename(record.getReport_name()))
		{
			result.setStatus("error");
			result.setError("请正确填写被举报人姓名");
		} 
		else if(record.getTitle() == null){
			result.setStatus("error");
			result.setError("请填写标题");
		}
		else if(record.getQuestion1() == null){
			result.setStatus("error");
			result.setError("请选择问题类别");
		}
		else if(record.getQuestion2() == null){
			result.setStatus("error");
			result.setError("请选择问题细类");
		}
		else if(record.getContent() == null || record.getContent().trim() == ""){
			result.setStatus("error");
			result.setError("请填写主要问题");
		}
		else if (!code.equals(yzm)) {
			result.setStatus("error");
			result.setError("验证码错误");
		}
		else {
			record.setContent(record.getContent().trim());
			//指定路径创建excel父文件夹
			String path = request.getSession().getServletContext().getRealPath("static/report");
			// 设置父级文件
			File parent = new File(path);
			if (!parent.exists()) {
				parent.mkdirs();
			}
			//插入一行数据到excel中
			ExcelWork.writeExcel(record,path);
			//service.insertSignature(record);
			result.setStatus("提交成功");
		}
		return result;
	}

	// 获取验证码
	@RequestMapping(value = "/GetCheckCode")
	@ResponseBody
	public String getCheckCode() {
		String result = "";
		try{
			result = service.getCheckCode();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	// 获取问题类别
	@RequestMapping(value = "/GetCategory")
	@ResponseBody
	public List<JbrCategoryWithBLOBs> getCategory(@RequestParam(value = "catname", required = true) String catname) {
		return service.getCategory(catname);
	}

	// 获取 政治面貌，级别
	@RequestMapping(value = "/GetQustionCategory")
	@ResponseBody
	public List<JbrJubao> getQustionCategory(@RequestParam(value = "catname", required = true) String catname) {
		List<JbrJubao> result = new ArrayList<JbrJubao>();
		if (!catname.equals("请选择")) {
			result = service.getJubao(catname);
			//System.out.println(result.toString());
		}

		return result;
	}

	// 获取 问题细类
	@RequestMapping(value = "/GetCategory2")
	@ResponseBody
	public List<JbrJubao> getSecondCategory(@RequestParam(value = "catid", required = true) String catidString) {
		List<JbrJubao> result = new ArrayList<JbrJubao>();
		if (!catidString.equals("请选择") && !catidString.equals("")) {
			short catid = (short) Integer.parseInt(catidString);
			result = service.getJubaoidByCatid(catid);
			//System.out.println(result.toString());
		}

		return result;
	}

	// 保存文件
	private String saveFile(MultipartFile file) throws IOException {
		String fileList;
		String path = request.getSession().getServletContext().getRealPath("/static/upload");
		// 设置父级文件
		File parent = new File(path);
		if (!parent.exists()) {
			parent.mkdirs();
		}

		// file.getOriginalFilename() 图片名
		// for(MultipartFile file : files){
		fileList = file.getOriginalFilename();
		//System.out.println("文件名"+fileList);
		String prefix = fileList.substring(fileList.lastIndexOf("."));
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String photoname = dateFormat.format(now);
		photoname += prefix;
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path, photoname));
		String photopath = path + "\\" + photoname;
		PhotoResult ptResult = new PhotoResult();
		ptResult.setFilename(file.getOriginalFilename());
		ptResult.setSave(photopath);
		// }

		return JsonUtil.getInstance().toJson(ptResult);
	}
}
