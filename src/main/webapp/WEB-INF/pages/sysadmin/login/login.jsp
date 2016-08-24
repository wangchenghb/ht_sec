<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>国际物流汇通商贸</title>
<link rel="stylesheet" rev="stylesheet" type="text/css"
	href="${ctx}/staticfile/skin/default/css/login.css" media="all" />
<script src="${ctx}/staticfile/components/pngfix/DD_belatedPNG.js"></script>
<script>
	DD_belatedPNG.fix('*');
</script>
</head>

<body>
	<form id="login_main" method="post" action="/j_spring_security_check">
		<div id="png">


			<div class="box">
				<div class="inputstyle">
					<div class="inputlable">
						用户名： <input type="text" value="" name="j_username" id="username"
							onFocus="this.select();" title="请您输入用户名" />
						<div id="ts" style="z-index: 1;"></div>
					</div>


					<div class="inputlable">
						密 码： <input type="password" value="" name="j_password"
							id="password"
							onfocus="$('#ts').css('display','none');this.select();"
							onKeyDown="javascript:if(event.keyCode==13){ submitFind(); }"
							title="请您输入密码" />
					</div>


				</div>
				<div class="btnstyle">
					<input class="loginImgOut" value="" type="submit"
						onmouseover="this.className='loginImgOver'"
						onmouseout="this.className='loginImgOut'" /> <input
						class="resetImgOut" value="" type="button"
						onmouseover="this.className='resetImgOver'"
						onmouseout="this.className='resetImgOut'" />
				</div>
				<div class="error">
					登陆失败<br>
					${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}
				</div>

				<div class="mirro"></div>
				<logic:notEmpty name="loginFailed">
					<c:if test="${param.sign==2}">
						<c:set var="errorInfo" value="用户名或密码错误, 请重新输入!" />
					</c:if>
					<c:if test="${param.sign==6}">
						<c:set var="errorInfo" value="用户名或密码不能为空" />
					</c:if>
					<div class="erro" id="erro">
						<div class="erro_intro">${errorInfo}</div>
					</div>
				</logic:notEmpty>
			</div>





		</div>
		</div>
		</div>
	</form>

	<script type="text/JavaScript">
		document.getElementById('login_main').username.focus();
	</script>

</body>
</html>


