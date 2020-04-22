package tourism.backstage.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tourism.backstage.dao.SysLogDao;
import tourism.backstage.entity.SysLog;
import tourism.backstage.service.SysLogService;

import java.util.List;

/**
 * @author @孙启新
 * @ClassName SysLogServiceImpl
 * @Description (Syslog)表业务层接口实现类
 * @date 2020-04-04 13:07:45
 **/
@Service
public class SysLogServiceImpl implements SysLogService {


    protected SysLogDao sysLogDao;

    @Autowired
    public void setSysLogDao(SysLogDao sysLogDao) {
        this.sysLogDao = sysLogDao;
    }

    /**
     * @param syslog 实例对象
     * @Description 添加Syslog
     */
    @Override
    public void saveSyslog(SysLog syslog) {
        sysLogDao.saveSyslog(syslog);
    }

    /**
     * @param id 主键
     * @return 是否成功
     * @Description 删除Syslog
     */
    @Override
    public boolean deleteSyslogById(String id) {
        if (sysLogDao.deleteSyslogById(id) == 1) {
            return true;
        }
        return false;
    }

    /**
     * @return 对象列表
     * 查询所有操作日志附带分页
     * 分页使用MyBatis的插件实现
     */
    @Override
    public List<SysLog> findAllSyslog(int page, int pageSize) {
        //分页插件参数 pageNum:页码值，pageSize：每页显示条数
        PageHelper.startPage(page, pageSize);
        return sysLogDao.findAllSyslog();
    }
}