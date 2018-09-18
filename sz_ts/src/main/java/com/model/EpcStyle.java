package com.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Size;
/**
 * EPC对应款式实体类
 */
public class EpcStyle implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3202422811040880207L;
	private int id;
	@Size(min=1,max=10,message="{ivva.common.error.note}")
	private String epc;
	private String style;
	private String createTime;
    //关联查询字段	
	private GoodsInfo goodsInfo;
	private StyleInfo styleInfo;
	private List<StyleMatch> styleMatchList;
	private List<StyleImg> styleImgList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEpc() {
		return epc;
	}
	public void setEpc(String epc) {
		this.epc = epc;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public GoodsInfo getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	public StyleInfo getStyleInfo() {
		return styleInfo;
	}
	public void setStyleInfo(StyleInfo styleInfo) {
		this.styleInfo = styleInfo;
	}
	public List<StyleMatch> getStyleMatchList() {
		return styleMatchList;
	}
	public void setStyleMatchList(List<StyleMatch> styleMatchList) {
		this.styleMatchList = styleMatchList;
	}
	
	public List<StyleImg> getStyleImgList() {
		return styleImgList;
	}
	public void setStyleImgList(List<StyleImg> styleImgList) {
		this.styleImgList = styleImgList;
	}
	@Override
	public String toString() {
		return "EpcStyle [id=" + id + ", epc=" + epc + ", style=" + style + ", createTime=" + createTime + "]";
	}


	
}
