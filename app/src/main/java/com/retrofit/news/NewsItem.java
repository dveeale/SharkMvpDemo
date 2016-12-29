package com.retrofit.news;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻列表内容
 * **/
public class NewsItem {
	//	private String ctype="";//类型，没什么用
	private String date="";//发表时间
	private String docid="";//新闻id,用于拼接请求image地址
	private String url="";//点击进入详情页地址
	private String rowkey="";//该新闻的唯一标示符
	
	@SerializedName("miniimg")
	private List<NewsImage> mImages;//返回图片数据结果
	private String source="";//来源
	
	@SerializedName("topic")
	private String title="";//标题
	private String itemid="";//等同于docid，用于判断当前是否是空数据
	


	private ArrayList<String> imageUrls;
	
	public NewsItem() {
		super();
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDocid() {
		return docid;
	}
	public void setDocid(String docid) {
		this.docid = docid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<String> getImageUrls() {
		return imageUrls;
	}
	public void setImageUrls(ArrayList<String> imageUrls) {
		this.imageUrls = imageUrls;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getRowkey() {
		return rowkey;
	}
	public void setRowkey(String rowkey) {
		this.rowkey = rowkey;
	}
	public List<NewsImage> getmImages() {
		return mImages;
	}
	public void setmImages(List<NewsImage> mImages) {
		this.mImages = mImages;
	}

}
