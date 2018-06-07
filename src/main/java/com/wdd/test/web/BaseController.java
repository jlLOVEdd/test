package com.wdd.test.web;

import com.wdd.test.bean.PageParameter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BaseController {

    /**
     *
     */
    @ExceptionHandler(Exception.class)
    public void exceptionHandler(Exception ex, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Ajax请求
        //String header = request.getHeader("X-Requested-With");
        if (StringUtils.isNotBlank(request.getHeader("X-Requested-With")) && request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
            if (ex instanceof org.springframework.web.multipart.MaxUploadSizeExceededException) {
                long maxUpLoadSize = ((org.springframework.web.multipart.MaxUploadSizeExceededException) ex).getMaxUploadSize();
                response.setHeader("sessionstatus", "上传文件超过" + (maxUpLoadSize == 0 ? 10 : (maxUpLoadSize / 1024 / 1024)) + "M最大限制!");
                response.sendError(200, ex.getMessage());
                response.setHeader("responseText", "responseText");
            } else if (ex instanceof DataAccessException) {
                response.setHeader("sessionstatus", "exception");
                response.sendError(518, "数据异常，请联系管理员");
            } else {
                response.setHeader("sessionstatus", "exception");
                response.sendError(200, ex.getMessage());
            }
            // Http请求
        } else {
            if (ex.getClass().getSimpleName().equals("ClientAbortException")) {
                if (response.getOutputStream() != null) {
                    response.getOutputStream().close();
                }
            } else {
                response.setHeader("Cache-Control", "no-cache");
                response.setHeader("Pragma", "no-cache");
                response.setDateHeader("Expires", 0);
                //response.sendRedirect(request.getContextPath() + "/static/error/error.jsp");
                System.out.println(request.getContextPath() + "/static/error/error.jsp");
            }
        }
    }

    /**
     * 默认ajax消息信息
     */
    //protected final static MessageBody	DEFAULT_MESSAGE_BODY	= Global.getMessageBody(true);
    @InitBinder
    protected void ininBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    /**
     * 获取Http请求
     *
     * @return
     */
    public HttpServletRequest getHttpServletRequest() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest();
    }

    /**
     * 获取分页信息
     *
     * @return
     */
    protected PageParameter getPageParameter() {
        HttpServletRequest request = this.getHttpServletRequest();
        PageParameter page = new PageParameter();
        //page.setPage(NumberUtils.toInt((request.getParameter("page")), 1));
        //page.setLimit(NumberUtils.toInt((request.getParameter("rows")), 20));
        //page.setSort(this.getSortParameter());
        return page;
    }

    /**
     * 获取分页信息
     *
     * @return
     */
    protected PageParameter getPageParameter(Integer start, Integer limit) {
        PageParameter page = new PageParameter();
        page.setPage(start);
        page.setLimit(limit);
        return page;
    }

    /**
     * 获取排序信息
     *
     * @return
     */
    /*protected SortParameter getSortParameter()
    {
		HttpServletRequest request = this.getHttpServletRequest();
		SortParameter sort = new SortParameter();
		sort.setDir(request.getParameter("sidx"));
		sort.setSort(request.getParameter("sord"));
		return sort;
	}
*/
    /**
     * 获取查找实体
     *
     * @return
     */
    /*protected QueryEntity getQueryEntity()
    {
		return this.getQueryEntity(this.getHttpServletRequest().getParameter("query"));
	}
*/
    /**
     * 获取查找实体
     *
     * @return
     */
	/*protected QueryEntity getQueryEntity(String query)
	{
		return this.getQueryEntity(query, null);
	}*/

    /**
     * 获取查找实体
     *
     * @return
     */
	/*protected QueryEntity getQueryEntity(String query, Object bean)
	{
		return new QueryEntity(query, bean, UserUtils.getUser().getOperateHabit());
	}*/
}
