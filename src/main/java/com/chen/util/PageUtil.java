package com.chen.util;

/**
 * 分页工具类
 * 
 * @author Administrator
 * 
 */
public class PageUtil {
	private int curPage;// 当前页码
	private int rowsPrePage;// 每页记录条数
	private int maxPage;// 总共有多少页
	private int maxRowsCount;// 总共有多少条数据

	/**
	 * 构造方法
	 * @param rowsPrePage 每页记录条数
	 * @param maxRowsCount 总共有多少条数据
	 */
	public PageUtil(int rowsPrePage, int maxRowsCount) {

		this.rowsPrePage = rowsPrePage;
		this.maxRowsCount = maxRowsCount;
		maxPage();//
	}

	public PageUtil() {

	}

	// 计算总页码
	public void maxPage() {

		if (maxRowsCount % rowsPrePage == 0) {

			maxPage = maxRowsCount / rowsPrePage;
		} else {
			maxPage = maxRowsCount / rowsPrePage + 1;
		}
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getRowsPrePage() {
		return rowsPrePage;
	}

	public void setRowsPrePage(int rowsPrePage) {
		this.rowsPrePage = rowsPrePage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getMaxRowsCount() {
		return maxRowsCount;
	}

	public void setMaxRowsCount(int maxRowsCount) {
		this.maxRowsCount = maxRowsCount;
	}

}
