<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改密码</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
 	<%@include file="/common/commonheader.jsp" %>
</head>

<body class="gray-bg">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>个人信息维护 <small>修改密码</small></h5>
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-sm-12">
                                 <form class="form-horizontal" id="updatepasswdform">
								<div class="form-group">
									<label class="col-sm-3 control-label">原密码：</label>
									<div class="col-sm-8">
										<input type="password" id="oldpasswd" name="oldpasswd" placeholder="原密码" class="form-control">
									</div>
								</div>
								<div class="form-group">
                                    <label class="col-sm-3 control-label">新密码：</label>
                                    <div class="col-sm-8">
                                        <input type="password" id="newpassword" name="newpassword" placeholder="密码" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">确认密码：</label>
                                    <div class="col-sm-8">
                                        <input type="password" id="confirm_password" name="confirm_password" placeholder="确认密码" class="form-control">
                                    </div>
                                </div>
								<div class="form-group">
									<div class="col-sm-offset-3 col-sm-8">
										<button class="btn btn-lg btn-info" type="submit">确认修改        </button>
									</div>
								</div>
							</form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
          </div>
    <!-- 全局js -->
    <%@include file="/common/commonfooter.jsp" %>
    <!-- 自定义js -->
  <!-- 自定义js -->
    <script src="${SysPro.system_static_sourceurl_prefix}/js/content${SysPro.system_static_sourceurl_jssuffix}"></script>
    <!-- iCheck -->
    <script src="${SysPro.system_static_sourceurl_prefix}/js/plugins/iCheck/icheck.min${SysPro.system_static_sourceurl_jssuffix}"></script>
        <script src="${SysPro.system_static_sourceurl_prefix}js/plugins/validate/jquery.validate.min${SysPro.system_static_sourceurl_jssuffix}"></script>
    <script src="${SysPro.system_static_sourceurl_prefix}js/plugins/validate/messages_zh.min${SysPro.system_static_sourceurl_jssuffix}"></script>
    <script src="${SysPro.system_static_sourceurl_prefix}js/updatepasswd.validator${SysPro.system_static_sourceurl_jssuffix}"></script>
    <script>
        $(document).ready(function () {
          
        });
        //
    </script>
</body>
</html>

