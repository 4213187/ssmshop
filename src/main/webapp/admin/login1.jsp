<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0" />
		<meta name="format-detection" content="telephone=no, email=no, date=no, address=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="format-detection" content="telephone=no" />
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<meta content="black" name="apple-mobile-web-app-status-bar-style">
		<link href="../css/SYSFrame.css" rel="stylesheet" type="text/css" />
		<link href="../css/skin.css" rel="stylesheet" type="text/css" id="skin" />
		<link href="../css/module.css" rel="stylesheet" type="text/css" />
		<link href="../font/iconfont.css" rel="stylesheet" type="text/css" />
		<title>登录</title>
		<script src="../js/jquery-1.9.1.min.js" type="text/javascript"></script>
		<script src="../js/jquery.cookie.js" type="text/javascript"></script>
		<script src="../js/jquery.nicescroll.js" type="text/javascript"></script>
		<script src="../js/SYSFrame.js" type="text/javascript"></script>
		<!--[if lt IE 9]>
          <script src="../js/html5shiv.js" type="text/javascript"></script>
          <script src="../js/css3-mediaqueries.js"  type="text/javascript"></script>
        <![endif]-->
	</head>
	<body class="login-layout Reg_log_style" id="loginstyle">
		<div class="logintop">
			<span>后台管理界面平台</span>
<%--			<ul>--%>
<%--				<li>--%>
<%--					<a href="#">返回首页</a>--%>
<%--				</li>--%>
<%--				<li>--%>
<%--					<a href="#">帮助</a>--%>
<%--				</li>--%>
<%--				<li>--%>
<%--					<a href="#">关于</a>--%>
<%--				</li>--%>
<%--			</ul>--%>
		</div>
		<div class="loginbody">
			<div class="login-container">
				<div class="center"> <img src="images/logo.png" /></div>
				<div class="space-6"></div>
				<div class="position-relative">
					<div id="login-box" class="login-box widget-box no-border visible">
						<div class="login-main">

							<div class="clearfix">
								<div class="login_icon"><img src="images/login_img.png" /></div>
								<form action="admin.login" method="post"  class="" style="  width:300px; float:right; margin-right:50px;">
									<h4 class="title_name"><img src="images/login_title.png" /></h4>
									<fieldset>
										<ul>
                                            <input name="index" type="text" value="1" hidden />
											<li class="frame_style form_error"><label class="user_icon iconfont">&#xe620;</label><input name="aname" type="text" data-name="用户名" id="username" /><i>用户名</i></li>
											<li class="frame_style form_error"><label class="password_icon iconfont">&#xe625;</label><input name="apwd" type="password" data-name="密码" id="userpwd" /><i>密码</i></li>${msg}

											</li>
										</ul>
										<div class="space"></div>
										<div class="clearfix">
											<label class="inline">
                                      <input type="checkbox" class="ace">
                                      <span class="lbl">保存密码</span>
                                  </label>
											<input type="submit" class="login_btn" id="login_btn" value="登&nbsp;录 ">
										</div>

										<div class="space-4"></div>
									</fieldset>
								</form>
							</div>
							<div class="social-or-login center">
								<span class="bigger-110">通知</span>
							</div>
							<div class="social-login ">
								欢迎使用小新电商管理系统
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="loginbm">版权所有 小新电商</div>
	</body>
</html>
<script type="text/javascript">
	//验证登录
	$(document).ready(function() {	
		$("input[type='text'],input[type='password']").blur(function() {
			var $el = $(this);
			var inputname=0;
			var $parent = $el.parent();
			$parent.attr('class', 'frame_style').removeClass(' form_error');
			if($el.val() == '') {
				var name=$el.attr("data-name");
				$parent.attr('class', 'frame_style').addClass(' form_error form_prompt');
				$parent.find('i').eq(inputname).html(name+"不能为空").addClass("prompt");
			}
		});
		$("input[type='text'],input[type='password']").focus(function() {
			var $el = $(this);
			var $parent = $el.parent();
			if($el.val() == '') {
				$parent.attr('class', 'frame_style').addClass(' form_errors');
			} else {
				$parent.attr('class', 'frame_style').removeClass(' form_errors');
			}
		});
	  $('#login_btn').on('click', function() {
		var num = 0;
		var str = "";
		$("input[type$='text'],input[type$='password']").each(function(n) {
			var $el = $(this);		
			var inputname=0;
			var $parent = $el.parent();
			if($el.val() == "") {
				var name=$el.attr("data-name");
				$parent.attr('class', 'frame_style').addClass(' form_error form_prompt');
                 $parent.find('i').eq(inputname).html(name+"不能为空").addClass("prompt");
				num++;
				return false;
			}
		});
		if(num > 0) {
			return false;
		} else {
			//ajax 判断用户名是否存在
			location.href = "index.html";
		}
	});
	})
	//框架设置
	$(function() {
		$("#loginstyle").SYSFrame({
               //必须保留否则无法进行皮肤更换，以及兼容移动端
               
		})
	});
</script>