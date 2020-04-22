package tourism.backstage.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tourism.backstage.entity.SysLog;
import tourism.backstage.service.SysLogService;

import java.util.List;

/**
 * SysLog表现层
 *
 * @author 孙启新
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    private SysLogService sysLogService;

    @Autowired
    public void setSysLogService(SysLogService sysLogService) {
        this.sysLogService = sysLogService;
    }

    /**
     * 查询所有操作日志附带分页
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("findAllSysLog")
    public ModelAndView findAllSysLog(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "pageSize", required = true, defaultValue = "5") int pageSize) {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogList = sysLogService.findAllSyslog(page, pageSize);
        //pageInfo就是一个分页的Bean,里面包含基本的分页信息
        PageInfo pageInfo = new PageInfo(sysLogList);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("sysLogs", sysLogList);
        mv.setViewName("syslog-list");
        return mv;
    }

    /**
     * 根据id删除日志信息
     *
     * @param id
     * @return
     */
    @GetMapping("deleteSysLogById")
    public void deleteSysLogById(String id) {
        sysLogService.deleteSyslogById(id);
    }
}
