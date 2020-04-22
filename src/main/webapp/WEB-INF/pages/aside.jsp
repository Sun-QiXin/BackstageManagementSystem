<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/img/user7-128x128.jpg"
                     class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <%--使用Spring El表达式可以获取到当前登录的用户名--%>
                <p><security:authentication property="principal.username"></security:authentication></p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

        <!-- search form -->
        <form action="${pageContext.request.contextPath}/product/findAllProductByMsg" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="searchMsg" class="form-control" placeholder="搜索...">
                <span class="input-group-btn">
                    <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i
                            class="fa fa-search"></i></button>
                </span>
            </div>
        </form>
        <!-- /.search form -->

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>
            <li id="admin-index"><a
                    href="${pageContext.request.contextPath}/index.jsp"><i
                    class="fa fa-home"></i> <span>首页</span></a></li>
            <%--作用：只有登录的用户为孙启新或者admin时才能看到里面的内容--%>
            <security:authorize
                    access="authentication.principal.username=='孙启新' || authentication.principal.username=='admin'">
            <li class="treeview"><a href="#"> <i class="fa fa-database"></i>
                <span>系统管理</span> <span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>
				</span></a>
                <ul class="treeview-menu">
                    <li class="system-setting">
                        <a href="${pageContext.request.contextPath}/user/findAllUser?page=1&pageSize=5"> <i
                                class="fa fa-circle-o"></i> 用户管理</a>
                    </li>

                    <li class="system-setting">
                        <a href="${pageContext.request.contextPath}/role/findAllRole?page=1&pageSize=5"> <i
                                class="fa fa-circle-o"></i> 角色管理</a>
                    </li>
                    <li class="system-setting">
                        <a href="${pageContext.request.contextPath}/permission/findAllPermission?page=1&pageSize=5">
                            <i class="fa fa-circle-o"></i> 资源权限管理</a>
                    </li>
                    <li class="system-setting">
                        <a href="${pageContext.request.contextPath}/sysLog/findAllSysLog?page=1&pageSize=5"> <i class="fa fa-circle-o"></i> 访问日志</a>
                    </li>
                </ul>
                </security:authorize>
            </li>
            <li class="treeview"><a href="#"> <i class="fa fa-pie-chart"></i>
                <span>基础数据</span> <span class="pull-right-container"> <i
                        class="fa fa-angle-left pull-right"></i>
				</span>
            </a>
                <ul class="treeview-menu">

                    <li class="system-setting"><a
                            href="${pageContext.request.contextPath}/product/findAllProduct?page=1&pageSize=5">
                        <i class="fa fa-circle-o"></i> 产品管理
                    </a></li>
                    <li class="system-setting"><a
                            href="${pageContext.request.contextPath}/orders/findAllOrders?page=1&pageSize=5"> <i
                            class="fa fa-circle-o"></i> 订单管理
                    </a></li>

                </ul>
            </li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>