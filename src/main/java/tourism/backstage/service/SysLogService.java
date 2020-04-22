package tourism.backstage.service;

import tourism.backstage.entity.SysLog;

import java.util.List;

/**
 * @InterfaceName SysLogService
 * @Description (SysLog)表业务层接口
 * @author @孙启新
 * @date 2020-04-04 13:07:45
 **/
public interface SysLogService {

    /**
     * @Description 添加Syslog
     * @param sysLog 实例对象
     * @return 是否成功
     */
    void saveSyslog(SysLog sysLog);

    /**
     * @Description 删除Syslog
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteSyslogById(String id);

    /**
     *  查询所有操作日志附带分页
     * 分页使用MyBatis的插件实现
     * @return 对象列表
     */
    List<SysLog> findAllSyslog(int page, int pageSize);
}